package com.example.fxforsomestufftest.validators;

import com.example.fxforsomestufftest.enums.Mails;
import com.example.fxforsomestufftest.models.UserDto;

import java.util.Map;

public class EmailValidator extends AbstractValidator {

    @Override
    public void validate(UserDto dto, Map<String, String> errors) {
        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
            errors.put("mail", "Пустое поле почты");
        }
        if (!Mails.isValidDomain(dto.getEmail()) || dto.getEmail().indexOf("@") == 0) {
            errors.put("mail", "Неверный домен почты");
        }
        if (next != null) {
            next.validate(dto, errors);
        }
    }
}
