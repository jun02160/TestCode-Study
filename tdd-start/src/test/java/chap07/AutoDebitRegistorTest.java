package chap07;

import static org.example.chap07.credit.util.CardValidity.THEFT;
import static org.example.chap07.credit.util.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.chap07.credit.AutoDebitRegister;
import org.example.chap07.credit.repository.AutoDebitRepository;
import org.example.chap07.credit.dto.AutoDebitReq;
import org.example.chap07.credit.util.CardNumberValidator;
import org.example.chap07.credit.repository.JpaAutoDebitInfoRepository;
import org.example.chap07.credit.dto.RegisterResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoDebitRegistorTest {

    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator();
        AutoDebitRepository repository = new JpaAutoDebitInfoRepository();
        register = new AutoDebitRegister(validator, repository);
    }

    @Test
    void validCard() {
        // 업체에서 받은 테스트용 유효한 카드번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);
        assertEquals(VALID, result.getValidity());
    }

    @Test
    void theftCard() {
        // 업체에서 받은 도난 테스트용 카드번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);
        assertEquals(THEFT, result.getValidity());
    }
}
