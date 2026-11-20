package com.example.fxforsomestufftest;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenu implements BaseController{
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
    protected void writeButtonClick() throws IOException {
        navigator.switchScene(Screens.WRITE_MENU_COOSE);
    }
    @FXML
    protected void readButtonClick() throws IOException{
        navigator.switchScene(Screens.READ_MENU);
    }
}