package com.example.fxforsomestufftest.controllers;

import com.example.fxforsomestufftest.models.AppModel;
import com.example.fxforsomestufftest.Navigator;
import com.example.fxforsomestufftest.enums.Screens;
import com.example.fxforsomestufftest.interfaces.BaseController;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Контроллер для выбора способа заполнения данных
 */
public class WriteMenu implements BaseController {
    private AppModel model;
    private Navigator navigator;

    @Override
    public void setModel(AppModel model){
        this.model = model;
    }

    @Override
    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }

    @FXML
    protected void inputHandDataButtonClick() throws IOException{
        navigator.switchScene(Screens.WRITE_HAND_MENU);
    }

    @FXML
    protected void backMenuButtonClick() throws IOException {
        navigator.switchScene(Screens.MAIN_MENU);
    }

}
