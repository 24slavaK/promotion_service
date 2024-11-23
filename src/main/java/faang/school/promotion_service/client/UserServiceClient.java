package faang.school.promotion_service.client;

import faang.school.promotion_service.dto.premium.PremiumDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user-service",url = "${user-service.host}:${user-service.port}")
public interface UserServiceClient {
    @GetMapping("/buy-premium/getActivePremium")
    List<PremiumDto> getAllActivePremium();

    @PutMapping("/buy-premium/updatePremium")
    List<PremiumDto> updatePremiums(@RequestBody List<PremiumDto> premiums);
}
