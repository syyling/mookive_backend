package com.mookive.mookive_backend.movie.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Configuration
public class RestClientConfig {

    @Value("${tmdb.token}")
    private String token;

    @Bean
    public KoficComponent koficService() {
        RestClient restClient = RestClient.builder()
                .baseUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json").build();

        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(KoficComponent.class);
    }

    @Bean
    public TmdbComponent tmdbService() {
        RestClient restClient = RestClient.builder()
                .baseUrl("https://api.themoviedb.org/3/movie/{movie_id}")
                .defaultHeader("Authorization", token)
                .defaultHeader("accept", "application/json")
                .build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(TmdbComponent.class);

    }
}
