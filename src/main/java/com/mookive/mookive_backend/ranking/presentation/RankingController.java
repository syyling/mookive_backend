package com.mookive.mookive_backend.ranking.presentation;

import com.mookive.mookive_backend.ranking.applicaiton.dto.request.RankingRequest;
import com.mookive.mookive_backend.ranking.applicaiton.dto.response.RankingResponse;
import com.mookive.mookive_backend.ranking.applicaiton.service.RankingCreateService;
import com.mookive.mookive_backend.ranking.applicaiton.service.RankingGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankingController {

    private final RankingCreateService rankingCreateService;
    private final RankingGetService rankingGetService;

    @PostMapping("/ranking")
    public void createRanking(@RequestBody List<RankingRequest.RankingCreateRequest> rankingCreateRequestList) {
        rankingCreateService.createRanking(rankingCreateRequestList);
    }

    @GetMapping("/ranking/{userId}")
    public List<RankingResponse.RankingInfoResponse> getRanking(@PathVariable Long userId) {
        return rankingGetService.getRanking(userId);
    }
}
