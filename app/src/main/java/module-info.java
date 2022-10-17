module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires calculatorservice;

    opens calculator.view.controller to javafx.fxml;
    exports calculator.view;
}