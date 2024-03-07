package com.mookive.mookive_backend.ranking.presentation;

import com.mookive.mookive_backend.ranking.applicaiton.dto.request.RankingRequest;
import com.mookive.mookive_backend.ranking.applicaiton.service.RankingCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankingController {

    private final RankingCreateService rankingCreateService;

    @PostMapping("/ranking")
    public void createRank(@RequestBody List<RankingRequest.RankingCreateRequest> rankingCreateRequestList) {
        rankingCreateService.createRank(rankingCreateRequestList);
    }
}
