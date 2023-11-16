package chap07;

import static org.example.chap07.credit.util.CardValidity.INVALID;
import static org.example.chap07.credit.util.CardValidity.THEFT;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.chap07.credit.AutoDebitRegister;
import org.example.chap07.credit.dto.AutoDebitReq;
import org.example.chap07.credit.dto.RegisterResult;
import org.example.chap07.credit.repository.StubAutoDebitInfoRepository;
import org.example.chap07.credit.util.StubCardNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoDebitRegister_Stub_Test {

    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(THEFT, result.getValidity());
    }
}
