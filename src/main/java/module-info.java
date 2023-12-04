module com.example.dsalgoca {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.junit.jupiter.api;
    requires xstream;


    opens com.example.dsalgoca to javafx.fxml;
    exports com.example.dsalgoca;
    opens dataStructures.CustomLinkedList to xstream;
    exports controller;
    opens controller to javafx.fxml;
    exports model;
    opens model to javafx.fxml, xstream;
    opens dataStructures.Hashing to xstream;
}