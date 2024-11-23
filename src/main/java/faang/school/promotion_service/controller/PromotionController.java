package faang.school.promotion_service.controller;

import faang.school.promotion_service.model.AnalyticsEvent;
import faang.school.promotion_service.service.scheduling.PromotionService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @PutMapping("update")
    public ResponseEntity<Map<Integer,Integer>> updatePoints(@NotNull @RequestBody AnalyticsEvent analyticsEvent){
        Map<Integer, Integer> result = promotionService.updatePoints(analyticsEvent);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
