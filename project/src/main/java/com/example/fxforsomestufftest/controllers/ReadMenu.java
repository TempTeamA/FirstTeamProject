package com.example.fxforsomestufftest.controllers;

import com.example.fxforsomestufftest.models.AppModel;
import com.example.fxforsomestufftest.Navigator;
import com.example.fxforsomestufftest.models.User;
import com.example.fxforsomestufftest.enums.Screens;
import com.example.fxforsomestufftest.interfaces.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

/**
 * Контроллер меню для чтения данных
 */
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
