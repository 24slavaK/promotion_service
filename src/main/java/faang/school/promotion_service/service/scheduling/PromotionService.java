package faang.school.promotion_service.service.scheduling;

import faang.school.promotion_service.model.AnalyticsEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
public class PromotionService {

    public Map<Integer,Integer> updatePoints(@RequestBody AnalyticsEvent analyticsEvent){
        return null;
    }
}
