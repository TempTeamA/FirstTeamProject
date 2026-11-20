package com.example.fxforsomestufftest.validators;

import com.example.fxforsomestufftest.models.UserDto;

import java.util.Map;

public class AgeValidator extends AbstractValidator {
    @Override
    public void validate(UserDto dto, Map<String, String> errors) {
        try {
            int age = Integer.parseInt(dto.getAge());
            if (age < 14 || age > 120) {
                errors.put("age", "Возраст только от 14 до 120 лет");
            }
        } catch (NumberFormatException e) {
            errors.put("age", "Введите число");
        }
        if (next != null) {
            next.validate(dto, errors);
        }
    }
}
