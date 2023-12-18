package appendix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Outer {

    @BeforeEach void outerBefore() {}

    @Test void outer() {
//        List<Integer> ret = getResults();
        List<Integer> ret = Arrays.asList(4,5,6);
        List<Integer> expected = Arrays.asList(1,2,3);
        for (Integer i : expected) {
            assertEquals(expected.get(i), ret.get(i), "ret["+i+"]");
        }
    }

    @AfterEach void outerAfter() {}

    @Nested
    class NestedA {

        @BeforeEach void nestedBefore() {}

        @Test void nested1() {}

        @AfterEach void nestedAfter() {}
    }
}
