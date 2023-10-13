package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    @Test
    void meetsAllCriteria_Then_Strong() {

        // 테스트 코드의 형태
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("ab12!Add");
        assertEquals(PasswordStrength.STRONG, result2);
    }


    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
