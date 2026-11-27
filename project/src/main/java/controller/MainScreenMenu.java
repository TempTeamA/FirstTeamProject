package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import controller.abstractions.BaseController;

import java.io.IOException;

public class MainScreenMenu implements BaseController {
    private AppModel model;
    private Navigator navigator;

    @FXML private ChoiceBox<String> objectChoiceBox;
    @FXML private ListView<String> mainListView;

    @FXML
    protected void onHandInputClick() throws IOException {
        String selectedObject = objectChoiceBox.getValue();
        model.setCurrentObjectType(selectedObject);

        navigator.switchScene("/HandInput-menu.fxml", "Ручной ввод");
    }

    @Override
    public void setModel(AppModel model){
        this.model = model;
        objectChoiceBox.getItems().addAll("Пользователь", "Автобус", "Машина");
        objectChoiceBox.setValue("Пользователь");
    }

    @Override
    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }
}
