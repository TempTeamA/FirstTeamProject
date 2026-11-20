module com.example.fxforsomestufftest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxforsomestufftest to javafx.fxml;
    exports com.example.fxforsomestufftest;
}