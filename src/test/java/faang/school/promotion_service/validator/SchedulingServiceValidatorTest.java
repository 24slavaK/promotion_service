package faang.school.promotion_service.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchedulingServiceValidatorTest {
    @Test
    void testNotNullListForCheckListForNull(){
        assertDoesNotThrow(()->SchedulingServiceValidator.checkListForNull(List.of()));
    }
    @Test
    void testNullListForCheckListForNull(){
        assertThrows(NullPointerException.class,
                ()->SchedulingServiceValidator.checkListForNull(null));
    }
}