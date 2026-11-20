package com.example.fxforsomestufftest.validators;

import com.example.fxforsomestufftest.models.UserDto;

import java.util.List;
import java.util.Map;

public class PasswordValidator extends AbstractValidator {
    @Override
    public void validate(UserDto dto, Map<String, String> errors) {
        if (dto.getPassword() == null || dto.getPassword().length() < 7) {
            errors.put("password", "Пароль должен содержать больше 8 символов");
        }

        if (!dto.getPassword().matches(".*[!@#$%^&*№%?]+.*")) {
            errors.put("password", "Пароль должен содержать спец символы");
        }

        if (next != null) {
            next.validate(dto, errors);
        }
    }
}
