package com.example.fxforsomestufftest.validators;

/**
 * Для всех конкретных валидаторов
 */
public abstract class AbstractValidator implements Validator {
    protected Validator next;

    @Override
    public void setNext(Validator next) {
        this.next = next;
    }
}
