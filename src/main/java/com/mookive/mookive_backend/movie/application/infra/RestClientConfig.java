package com.mookive.mookive_backend.movie.application.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Configuration
public class RestClientConfig {

    @Bean
    public KmdbComponent kmdbService() {
        RestClient restClient = RestClient.builder()
                .baseUrl("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp").build();

        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(KmdbComponent.class);
    }

    @Bean
    public KoficComponent koficService() {
        RestClient restClient = RestClient.builder()
                .baseUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json").build();

        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(KoficComponent.class);
    }
}
