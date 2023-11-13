module com.example.dsalgoca2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsalgoca2 to javafx.fxml;
    exports com.example.dsalgoca2;
}