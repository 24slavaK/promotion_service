package faang.school.promotion_service.service.scheduling;

import faang.school.promotion_service.client.UserServiceClient;
import faang.school.promotion_service.dto.premium.PremiumDto;
import faang.school.promotion_service.validator.SchedulingServiceValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchedulingService {
    private final UserServiceClient userServiceClient;

    @Scheduled(cron = "0 0 0 * * ?")
    public void changePremiumStatus() {
        log.info("scheduled task start working");

        log.info("getting list of premium from user_service");
        List<PremiumDto> premiums = userServiceClient.getAllActivePremium();

        log.info("validation for null");
        SchedulingServiceValidator.checkListForNull(premiums);

        List<PremiumDto> updatedPremiums = premiums.stream()
                .filter(premiumDto -> premiumDto.getEndDate().isBefore(LocalDateTime.now()))
                .peek(premiumDto -> premiumDto.setActive(false))
                .toList();

        log.info("send updated list of premiumDto to user_service");
        userServiceClient.updatePremiums(updatedPremiums);
    }
}
