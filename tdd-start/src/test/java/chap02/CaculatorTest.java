package chap02;

import org.example.chap02.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaculatorTest {

    @Test
    void plus() {
        int result = Calculator.plus(1,2);
        assertEquals(3, result);
    }
}
