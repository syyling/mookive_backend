package com.mookive.mookive_backend.movie.application.service;

import com.mookive.mookive_backend.movie.application.dto.response.MovieResponse;
import com.mookive.mookive_backend.movie.application.infra.KmdbComponent;
import com.mookive.mookive_backend.movie.application.infra.KoficComponent;
import com.mookive.mookive_backend.movie.application.mapper.MovieMapper;
import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.service.MovieQueryService;
import com.mookive.mookive_backend.movie.domain.service.MovieSaveService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieGetService {

    private final MovieQueryService movieQueryService;
    private final MovieSaveService movieSaveService;
    private final KmdbComponent kmdbComponent;
    private final KoficComponent koficComponent;

    @Value("${kmdb.service-key}")
    private String kmdbServiceKey;

    @Value("${kmdb.collection}")
    private String collection;

    @Value("${kofic.service-key}")
    private String koficKey;

    /**
    TODO: 예외처리
     */
    public MovieResponse.MovieDetailResponse getMovieInfo(String title) throws JSONException {
        Movie movie = movieQueryService.findByTitle(title);
        if(movie == null) {
            KmdbResponse kmdbResponse = getKmdbResponse(title);
            KoficResponse koficResponse = getKoficResponse(title);
            movie = Movie.builder()
                    .title(koficResponse.getTitle())
                    .director(kmdbResponse.getDirector())
                    .genre(kmdbResponse.getGenre())
                    .plot(kmdbResponse.getPlot())
                    .year(koficResponse.getYear())
                    .build();
            movieSaveService.saveMovie(movie);
        }
        return MovieMapper.mapToMovieDetailResponse(movie);
    }

    private JSONObject getDataResponse(String title) {
        JSONObject json = new JSONObject(kmdbComponent.findMovieByTitle(collection, kmdbServiceKey, title, "N"));
        JSONArray dataArray = (JSONArray) json.get("Data");
        JSONObject dataObject = (JSONObject) dataArray.get(0);
        JSONArray dataResult = (JSONArray) dataObject.get("Result");
        return (JSONObject) dataResult.get(0);
    }

    private KmdbResponse getKmdbResponse(String title) {
        JSONObject dataObject = getDataResponse(title);
        System.out.println(dataObject.toString());
        Object genre = dataObject.get("genre");
        Object director = getDirector(dataObject);
        Object plot = getPlotText(dataObject);
        return KmdbResponse.builder()
                .director((String) director)
                .genre((String) genre)
                .plot((String) plot)
                .build();
    }

    private static Object getPlotText(JSONObject dataObject) {
        JSONObject plotObject = (JSONObject) dataObject.get("plots");
        JSONArray plotArray = (JSONArray) plotObject.get("plot");
        JSONObject plotData = (JSONObject) plotArray.get(0);
        return plotData.get("plotText");
    }

    private static Object getDirector(JSONObject dataObject) {
        JSONObject directorObject = (JSONObject) dataObject.get("directors");
        JSONArray directorArray = (JSONArray) directorObject.get("director");
        JSONObject directorData = (JSONObject) directorArray.get(0);
        return directorData.get("directorNm");
    }

    private KoficResponse getKoficResponse(String movieTitle) {
        JSONObject json = new JSONObject(koficComponent.findMovieByTitle(koficKey, movieTitle));
        JSONObject jsonObject = (JSONObject) json.get("movieListResult");
        JSONArray dataResult = (JSONArray) jsonObject.get("movieList");
        JSONObject movie = (JSONObject) dataResult.get(0); //결과값이 여러개일 때 문제
        String title = movie.get("movieNm").toString();
        System.out.println(title);
        String year = movie.get("openDt").toString().substring(0, 4);
        return KoficResponse.builder()
                .title(title)
                .year(year)
                .build();
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    private static class KmdbResponse {
        private String director;
        private String genre;
        private String plot;

        @Builder
        public KmdbResponse(String director, String genre, String plot) {
            this.director = director;
            this.genre = genre;
            this.plot = plot;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    private static class KoficResponse {
        private String title;
        private String year;

        @Builder
        public KoficResponse(String title, String year) {
            this.title = title;
            this.year = year;
        }
    }
}
