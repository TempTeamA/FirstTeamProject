module com.example.firstteamproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.firstteamproject to javafx.fxml;
    exports com.example.firstteamproject;
    exports com.example.firstteamproject.interfaces;
    opens com.example.firstteamproject.interfaces to javafx.fxml;
    exports com.example.firstteamproject.enums;
    opens com.example.firstteamproject.enums to javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;
    exports com.example.firstteamproject.models;
    opens com.example.firstteamproject.models to javafx.fxml;
    exports com.example.firstteamproject.validators;
    opens com.example.firstteamproject.validators to javafx.fxml;
}