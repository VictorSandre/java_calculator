module me.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens me.calculator.controller to javafx.fxml;
    exports me.calculator;

    requires org.antlr.antlr4.runtime;

}
