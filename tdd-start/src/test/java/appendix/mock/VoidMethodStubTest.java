package appendix.mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.Test;

public class VoidMethodStubTest {

    @Test
    void voidMethodWillStubTest() {
        List<String> mockList = mock(List.class);
        willThrow(UnsupportedOperationException.class)
                .given(mockList)
                .clear();

        assertThrows(
                UnsupportedOperationException.class,
                () -> mockList.clear());
    }
}
