package appendix.mock;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * 행위 검증
 */
public class GameTest {

    @Test
    void init() {
        GameNumGen genMock = mock(GameNumGen.class);
        Game game = new Game(genMock);
        game.init(GameLevel.EASY);

        then(genMock).should().generate(GameLevel.EASY);
    }
}
