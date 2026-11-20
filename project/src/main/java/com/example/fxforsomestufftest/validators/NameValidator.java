package com.example.fxforsomestufftest.validators;

import com.example.fxforsomestufftest.models.UserDto;

import java.util.Map;

/**
 * Валидатор для проверки имени
 */
public class NameValidator extends AbstractValidator {
    @Override
    public void validate(UserDto dto, Map<String, String> errors) {
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            errors.put("name", "Пустое поле");
        }
        if (next != null) {
            next.validate(dto, errors);
        }
    }
}
