package com.mookive.mookive_backend.movie.infra;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@Component
@HttpExchange
public interface KoficComponent {

    @GetExchange()
    String findMovieByTitleAndYear(@RequestParam String key, @RequestParam String movieNm, @RequestParam String openStartDt);
}
