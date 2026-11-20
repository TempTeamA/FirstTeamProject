package com.example.fxforsomestufftest;

import java.util.List;
import java.util.Map;

public interface Validator {
    void setNext(Validator next);
    void validate(UserDto dto, Map<String, String> errors);
}

abstract class AbstractValidator implements Validator{
    protected Validator next;

    @Override
    public void setNext(Validator next){
        this.next = next;
    }
}

class NameValidator extends AbstractValidator{
    @Override
    public void validate(UserDto dto, Map<String, String> errors){
        if (dto.name == null || dto.name.trim().isEmpty()){
            errors.put("name", "Пустое поле");
        }
        if (next != null) {
            next.validate(dto, errors);
        }
    }
}

class AgeValidator extends AbstractValidator{
    @Override
    public void validate(UserDto dto, Map<String, String> errors){
        try {
            int age = Integer.parseInt(dto.age);
            if (age < 14 || age > 120){
                errors.put("age", "Возраст только от 14 до 120 лет");
            }
        }
        catch (NumberFormatException e){
            errors.put("age", "Введите число");
        }
        if (next != null) {
            next.validate(dto, errors);
        }
    }
}


class EmailValidator extends AbstractValidator{

    @Override
    public void validate(UserDto dto, Map<String, String> errors){
        if (dto.email == null || dto.email.trim().isEmpty()){
            errors.put("mail", "Пустое поле почты");
        }
        if (!Mails.isValidDomain(dto.email) || dto.email.indexOf("@") == 0){
            errors.put("mail", "Неверный домен почты");
        }
        if(next != null){
            next.validate(dto,errors);
        }
    }
}

class PasswordValidator extends AbstractValidator{
    List<String> symbolValidate = List.of("@", "!", "#", "$");
    @Override
    public void validate(UserDto dto, Map<String, String> errors){
        if (dto.password == null || dto.password.length() < 7){
            errors.put("password", "Пароль должен содержать больше 8 символов");
        }

        if (!dto.password.matches(".*[!@#$%^&*№%?]*." ))
        {
            errors.put("password", "Пароль должен содержать спец символы");
        }

        if (next != null){
            next.validate(dto,errors);
        }
    }
}