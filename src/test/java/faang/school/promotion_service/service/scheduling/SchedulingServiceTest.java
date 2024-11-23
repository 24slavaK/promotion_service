package faang.school.promotion_service.service.scheduling;

import faang.school.promotion_service.client.UserServiceClient;
import faang.school.promotion_service.dto.premium.PremiumDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SchedulingServiceTest {
    @InjectMocks
    private SchedulingService schedulingService;
    @Mock
    private UserServiceClient userServiceClient;

    @Test
    void testNullListForPremiums(){
        when(userServiceClient.getAllActivePremium()).thenReturn(null);

        assertThrows(NullPointerException.class,
                ()->schedulingService.changePremiumStatus());
    }

    @Test
    void testSuccessfulChangePremiumStatus(){
        PremiumDto activePremium = new PremiumDto();
        activePremium.setEndDate(LocalDateTime.now().minusDays(1));
        activePremium.setActive(true);

        List<PremiumDto> activePremiums = List.of(activePremium);

        when(userServiceClient.getAllActivePremium()).thenReturn(activePremiums);

        schedulingService.changePremiumStatus();

        assertFalse(activePremium.isActive());
        verify(userServiceClient).updatePremiums(List.of(activePremium));
    }
}