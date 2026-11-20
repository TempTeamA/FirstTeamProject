package com.example.fxforsomestufftest.validators;

import com.example.fxforsomestufftest.models.UserDto;

import java.util.Map;

/**
 * Для паттерна "Цепочка ответственности"
 * Для проверки вводимых данных пользователя
 */
public interface Validator {
    // Для установки следующего валидатора
    void setNext(Validator next);
    //Для проверки и выдачи ошибки после ввода
    void validate(UserDto dto, Map<String, String> errors);
}


