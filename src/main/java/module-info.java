module com.example.dsalgoca {
    requires javafx.fxml;
    requires javafx.controls;


    opens com.example.dsalgoca to javafx.fxml;
    exports com.example.dsalgoca;
    exports controller;
    opens controller to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
}