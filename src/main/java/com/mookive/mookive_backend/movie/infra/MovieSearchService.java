package com.mookive.mookive_backend.movie.infra;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieSearchService {

    private final KoficComponent koficComponent;
    private final TmdbComponent tmdbComponent;


    @Value("${kofic.service-key}")
    private String koficKey;

    public Movie searchMovie(String tmdbId) {
        TmdbResponse tmdbResponse = getTmdbResponse(tmdbId);
        KoficResponse koficResponse = getKoficResponse(tmdbResponse.getTitle(), tmdbResponse.getYear());
        return Movie.builder()
                .tmdbId(tmdbId)
                .title(tmdbResponse.getTitle())
                .year(tmdbResponse.getYear())
                .genre(tmdbResponse.getGenre())
                .plot(tmdbResponse.getPlot())
                .poster(tmdbResponse.getPoster())
                .nation(koficResponse.getNation())
                .director(koficResponse.getDirector())
                .build();
    }

    private TmdbResponse getTmdbResponse(String tmdbMovieId) {
        JSONObject jsonObject = new JSONObject(tmdbComponent.findMovieById(tmdbMovieId, "ko"));
        Object title = jsonObject.get("title");
        JSONArray genres = (JSONArray) jsonObject.get("genres");
        StringBuilder genre = new StringBuilder();
        for(int i=0; i<2; i++) {
            JSONObject genreObject = (JSONObject) genres.get(i);
            genre.append(genreObject.get("name"));
            if(i==0) genre.append(",");
        }
        Object plot  = jsonObject.get("overview");
        Object poster = "https://image.tmdb.org/t/p/original" + jsonObject.get("poster_path");
        Object year = jsonObject.get("release_date").toString().substring(0, 4);

        return TmdbResponse.builder()
                .title(title.toString())
                .year(year.toString())
                .genre(genre.toString())
                .plot(plot.toString())
                .poster(poster.toString())
                .build();
    }

    private KoficResponse getKoficResponse(String title, String year) {
        JSONObject apiResponse = new JSONObject(koficComponent.findMovieByTitleAndYear(koficKey, title, year));
        JSONObject jsonObject = (JSONObject) apiResponse.get("movieListResult");
        JSONArray dataResult = (JSONArray) jsonObject.get("movieList");
        JSONObject movie = (JSONObject) dataResult.get(0);
        String nation = movie.get("nationAlt").toString();
        JSONArray directors = (JSONArray) movie.get("directors");
        StringBuilder director = new StringBuilder();
        for(int i=0; i<directors.length(); i++) {
            JSONObject directorObject = (JSONObject) directors.get(i);
            director.append(directorObject.get("peopleNm"));
            if(i<directors.length()-1) director.append(",");
        }
        return KoficResponse.builder()
                .nation(nation)
                .director(director.toString())
                .build();
    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    private static class TmdbResponse {
        private String title;
        private String year;
        private String genre;
        private String plot;
        private String poster;

        @Builder
        public TmdbResponse(String title, String year, String genre, String plot, String poster) {
            this.title = title;
            this.year = year;
            this.genre = genre;
            this.plot = plot;
            this.poster = poster;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    private static class KoficResponse {
        private String director;
        private String nation;

        @Builder
        public KoficResponse(String director, String nation) {
            this.director = director;
            this.nation = nation;
        }
    }
}
