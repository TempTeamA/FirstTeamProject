package com.example.fxforsomestufftest.validators;

import com.example.fxforsomestufftest.models.AppModel;
import com.example.fxforsomestufftest.models.User;
import com.example.fxforsomestufftest.models.UserDto;

import java.util.Map;

/**
 * Сервис регистрации пользователя
 * Отвечает за валидацию данных
 * Преобразование Dto в User
 * Сохранение пользователя в AppModel
 */
public class UserRegistrationService {
    private final UserValidator validator;
    private final AppModel model;

    public UserRegistrationService(AppModel model){
        this.model = model;
        this.validator = new UserValidator();
    }

    /**
     * Валидируем Dto
     * Если ошибок нет, создаем User и сохраняем
     */
    public Map<String,String> register(UserDto dto){
        Map<String,String> errors = validator.validate(dto);

        if (errors.isEmpty()){
            User newUser = mapDtoToUser(dto);
            model.addUser(newUser);
        }
        return errors;
    }
    private User mapDtoToUser(UserDto dto){
        return new User.UserBuilder()
                .setName(dto.getName())
                .setAge(Integer.parseInt(dto.getAge()))
                .setMail(dto.getEmail())
                .setPass(dto.getPassword())
                .build();
    }
}
