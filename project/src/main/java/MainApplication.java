
import javafx.application.Application;
import javafx.stage.Stage;
import controller.AppModel;
import controller.Navigator;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        AppModel model = new AppModel();
        Navigator navigator = new Navigator(stage, model);

        navigator.switchScene("/MainScreen-menu.fxml", "Главное меню");

        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}