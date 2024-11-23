package faang.school.promotion_service.validator;

import faang.school.promotion_service.dto.premium.PremiumDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class SchedulingServiceValidator {
    public static void checkListForNull(List<PremiumDto> list){
        if (list == null) {
          throw new NullPointerException("Пустой лист");
        }
    }
}
