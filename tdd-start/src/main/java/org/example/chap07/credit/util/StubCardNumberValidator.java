package org.example.chap07.credit.util;

/**
 * ## 스텁 대역
 * 카드 정보 API를 대신하여 유효한 카드번호, 도난 카드번호와 같은 상황을 흉내낸다.
 */
public class StubCardNumberValidator extends CardNumberValidator {

    private String invalidNo;
    private String theftNo;

    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    public void setTheftNo(String theftNo) {
        this.theftNo = theftNo;
    }

    @Override
    public CardValidity validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }
        if (theftNo != null && theftNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }
        return CardValidity.VALID;
    }
}
