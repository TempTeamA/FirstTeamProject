package com.example.fxforsomestufftest.validators;

import com.example.fxforsomestufftest.models.UserDto;

import java.util.HashMap;
import java.util.Map;

/**
 * Для валидации пользователя
 * После ввода и нажатии на кнопку проверяем данные
 * Возвращаем ошибки если данные были некоректны
 */
public class UserValidator {
    private final Validator validatorChain;

    public UserValidator(){
        //Для цепочки валидаторов
        this.validatorChain = buildValidationChain();
    }

    /**
     * Сборка цепочки валидаторов
     * По очереди проверяем name, age, email, password
     */
    private Validator buildValidationChain(){
        Validator nameValidator = new NameValidator();
        Validator ageValidator = new AgeValidator();
        Validator emailValidator = new EmailValidator();
        Validator passwordValidator = new PasswordValidator();

        nameValidator.setNext(ageValidator);
        ageValidator.setNext(emailValidator);
        emailValidator.setNext(passwordValidator);

        return nameValidator;
    }

    /**
     * Запуск валидации Dto по всей цепочки
     *
     */
    public Map<String,String> validate(UserDto dto){
        Map<String,String> errors = new HashMap<>();
        validatorChain.validate(dto, errors);
        return errors;
    }
}
