package com.example.fxforsomestufftest.controllers;

import com.example.fxforsomestufftest.*;
import com.example.fxforsomestufftest.enums.Screens;
import com.example.fxforsomestufftest.interfaces.BaseController;
import com.example.fxforsomestufftest.models.AppModel;
import com.example.fxforsomestufftest.models.UserDto;
import com.example.fxforsomestufftest.validators.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Map;

/**
 * Контроллер для ручного ввода данных
 */
public class HandInputInfoMenu implements BaseController {
    private AppModel model;
    private Navigator navigator;
    private UserRegistrationService registrationService;

    @FXML private TextField nameText;
    @FXML private TextField ageText;
    @FXML private TextField mailText;
    @FXML private TextField passwordText;

    @FXML private Label setTextInfo;

    @FXML private Label nameErrorLabel;
    @FXML private Label ageErrorLabel;
    @FXML private Label passwordErrorLabel;
    @FXML private Label mailErrorLabel;

    /**
     * Вызывается Navigator'ом при загрузке сцены.
     * Здесь создаём сервис и привязываем Label к модели.
     */
    @Override
    public void setModel(AppModel model){
        this.model = model;
        this.registrationService = new UserRegistrationService(model);
        setTextInfo.textProperty().bind(model.someTextProperty());
    }

    private void clearErrors(){
        nameErrorLabel.setText("");
        ageErrorLabel.setText("");
        mailErrorLabel.setText("");
        passwordErrorLabel.setText("");
    }

    /** Логина обработки данных при нажатии на кнопку */
    private void handInputDataValidate(){
        UserDto dto = new UserDto(
                nameText.getText(),
                ageText.getText(),
                mailText.getText(),
                passwordText.getText()
        );

        Map<String,String> errors = registrationService.register(dto);

        if(errors.isEmpty()){
            model.setSomeText("Пользователь добавлен");
            clearTextField();
        }
        else
        {
            model.setSomeText("Исправьте данные в поле ввода");
            showErrors(errors);
        }
    }

    /** Отображение ошибки в Label'ы */
    private void showErrors(Map<String,String> errors){
        if (errors.containsKey("name")) nameErrorLabel.setText(errors.get("name"));
        if (errors.containsKey("age")) ageErrorLabel.setText(errors.get("age"));
        if (errors.containsKey("mail")) mailErrorLabel.setText(errors.get("mail"));
        if (errors.containsKey("password")) passwordErrorLabel.setText(errors.get("password"));
    }

    /** Для очистки данных после ввода */
    private void clearTextField(){
        nameText.clear();
        ageText.clear();
        mailText.clear();
        passwordText.clear();
    }
    /** Сама кнопка для добавления пользователя*/
    @FXML
    protected void getInfoButton(){
        clearErrors();
        handInputDataValidate();
    }

    @Override
    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }

    /** Кнопка назад */
    @FXML
    protected void backWriteButtonClick() throws IOException {
        navigator.switchScene(Screens.WRITE_MENU_COOSE);
    }



}
