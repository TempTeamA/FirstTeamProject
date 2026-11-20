package com.example.fxforsomestufftest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {
    private final AppModel model;
    private final Stage stage;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public Navigator(Stage stage, AppModel model){
        this.model = model;
        this.stage = stage;
    }

    public void switchScene(Screens screen) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(screen.getFxmlFile()));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);

        BaseController controller = loader.getController();
        controller.setModel(this.model);
        controller.setNavigator(this);

        stage.setTitle(screen.getTitle());
        stage.setScene(scene);

    }
}
