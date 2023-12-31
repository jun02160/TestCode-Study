package org.example.chap07.credit.dto;

import org.example.chap07.credit.util.CardValidity;

public class RegisterResult {

    private CardValidity validity;

    public RegisterResult(CardValidity validity) {
        this.validity = validity;
    }

    public CardValidity getValidity() {
        return validity;
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(validity);
    }

    public static RegisterResult success() {
        return new RegisterResult(CardValidity.VALID);
    }
}
