module me.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens me.calculator to javafx.fxml;
    exports me.calculator;
}
