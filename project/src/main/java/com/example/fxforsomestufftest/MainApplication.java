package com.example.fxforsomestufftest;

import com.example.fxforsomestufftest.enums.Screens;
import com.example.fxforsomestufftest.models.AppModel;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AppModel model = new AppModel();
        Navigator navigator = new Navigator(stage, model);

        navigator.switchScene(Screens.MAIN_MENU);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}