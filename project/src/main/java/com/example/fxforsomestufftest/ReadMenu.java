package com.example.fxforsomestufftest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.stream.BaseStream;

public class ReadMenu implements BaseController {
    private AppModel model;
    private Navigator navigator;

    @FXML ListView<User> userListView;


    @Override
    public void setModel(AppModel model){
        this.model = model;
        if (model.getUsers() != null){
            userListView.setItems(model.getUsers());
        }
        userListView.setPlaceholder(new Label("Список пуст"));
    }

    @Override
    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }



    @FXML
    public void backMenuButtonClick() throws IOException {
        navigator.switchScene(Screens.MAIN_MENU);
    }


}
