module org.example.alifx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.alifx to javafx.fxml;
    exports org.example.alifx.view_controller;
    opens org.example.alifx.view_controller to javafx.fxml;
}