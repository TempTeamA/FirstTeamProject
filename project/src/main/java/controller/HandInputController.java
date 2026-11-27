package controller;

import controller.abstractions.BaseController;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class HandInputController implements BaseController {
    private AppModel model;
    private Navigator navigator;

    @FXML private GridPane formContainer;
    @FXML private Label errorLabel;
    @FXML private Label headerLabel;

    private Map<String, TextField> inputFields = new HashMap<>();

    @Override
    public void setModel(AppModel model){
        this.model = model;
        buildForm();
    }

    @Override
    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }

    @FXML
    protected void onBackClick(){
        try {
            navigator.switchScene("/MainScreen-menu.fxml", "Главное меню");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // Чтобы не создавать новые формы создаем содержимое для одной формы
    private void buildForm(){
        formContainer.getChildren().clear();
        inputFields.clear();
        errorLabel.setText("");

        String type = model.getCurrentObjectType();

        headerLabel.setText("Ввод данных: " + type);

        switch (type){
            case "Пользователь":
                addField("Имя", "name", 0);
                addField("Возраст", "age", 1);
                addField("Почта", "email", 2);
                addField("Пароль", "password", 3);
                break;
            case "Автобус":
                addField("Номер", "number", 0);
                addField("Модель", "model", 1);
                addField("Пробег", "mileage", 2);
                break;
            case "Машина":
                addField("Мощность", "power", 0);
                addField("Модель", "model", 1);
                addField("Год выпуска", "year", 2);
                break;
            default:
                errorLabel.setText("Неизвестный тип объекта: " + type);
        }
    }
    // Добавляем поля в форму
    private void addField(String labelText, String key, int row){
        Label label = new Label(labelText);
        TextField textField = new TextField();

        formContainer.add(label, 0, row);
        formContainer.add(textField, 1, row);

        inputFields.put(key,textField);
    }
}
