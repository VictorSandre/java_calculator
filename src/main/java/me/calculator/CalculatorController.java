package me.calculator;

import java.io.IOException;
import javafx.fxml.FXML;

public class CalculatorController {

    private String mathematicalExpression;
    
    @FXML
    private void addZeroToExpression() throws IOException {
        mathematicalExpression += '0';
    }
}
