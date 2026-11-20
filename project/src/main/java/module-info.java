module com.example.fxforsomestufftest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxforsomestufftest to javafx.fxml;
    exports com.example.fxforsomestufftest;
    exports com.example.fxforsomestufftest.interfaces;
    opens com.example.fxforsomestufftest.interfaces to javafx.fxml;
    exports com.example.fxforsomestufftest.enums;
    opens com.example.fxforsomestufftest.enums to javafx.fxml;
    exports com.example.fxforsomestufftest.controllers;
    opens com.example.fxforsomestufftest.controllers to javafx.fxml;
    exports com.example.fxforsomestufftest.models;
    opens com.example.fxforsomestufftest.models to javafx.fxml;
    exports com.example.fxforsomestufftest.validators;
    opens com.example.fxforsomestufftest.validators to javafx.fxml;
}