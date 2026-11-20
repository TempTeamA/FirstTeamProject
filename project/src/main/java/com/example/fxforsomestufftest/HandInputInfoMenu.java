package com.example.fxforsomestufftest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HandInputInfoMenu implements BaseController{
    private AppModel model;
    private Navigator navigator;

    @FXML private TextField nameText;
    @FXML private TextField ageText;
    @FXML private TextField mailText;
    @FXML private TextField passwordText;

    @FXML private Label setTextiInfo;

    @FXML private Label nameErrorLabel;
    @FXML private Label ageErrorLabel;
    @FXML private Label passwordErrorLabel;
    @FXML private Label mailErrorLabel;


    @Override
    public void setModel(AppModel model){
        this.model = model;
        setTextiInfo.textProperty().bind(model.someTextProperty());
    }

    private void clearErrors(){
        nameErrorLabel.setText("");
        ageErrorLabel.setText("");
        mailErrorLabel.setText("");
        passwordErrorLabel.setText("");
    }

    private void handInputDataValidate(){
        UserDto dto = new UserDto(
                nameText.getText(),
                ageText.getText(),
                mailText.getText(),
                passwordText.getText()
        );
        Validator nameValidator = new NameValidator();
        Validator ageValidator = new AgeValidator();
        Validator emailValidator = new EmailValidator();
        Validator passwordValidator = new PasswordValidator();

        nameValidator.setNext(ageValidator);
        ageValidator.setNext(emailValidator);
        emailValidator.setNext(passwordValidator);

        Map<String, String> errors = new HashMap<>();
        nameValidator.validate(dto, errors);

        if (errors.containsKey("name")) nameErrorLabel.setText(errors.get("name"));
        if (errors.containsKey("age")) ageErrorLabel.setText(errors.get("age"));
        if (errors.containsKey("mail")) mailErrorLabel.setText(errors.get("mail"));
        if (errors.containsKey("password")) passwordErrorLabel.setText(errors.get("password"));

        if (errors.isEmpty()){
            User newUser = new User.UserBuilder()
                    .setName(dto.name)
                    .setAge(Integer.parseInt(dto.age))
                    .setMail(dto.email)
                    .setPass(dto.password)
                    .build();
            model.addUser(newUser);
            model.setSomeText("Пользователь добавлен");

            nameText.clear();
            ageText.clear();
            mailText.clear();
            passwordText.clear();
        }
        else {
            model.setSomeText("Исправьте данные в поле ввода");
        }

    }

    @FXML
    protected void getInfoButton(){
        clearErrors();

        handInputDataValidate();
    }

    @Override
    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }

    @FXML
    protected void backWriteButtonClick() throws IOException {
        navigator.switchScene(Screens.WRITE_MENU_COOSE);
    }



}
