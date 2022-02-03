package me.calculator;

import java.io.IOException;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import me.calculator.controller.TokensList;
import me.calculator.model.Calculator;

public class CalculatorController implements  ListChangeListener<String>{

    private final Calculator calculator;
    
    TokensList mathExprAsTokenList;
    
    @FXML
    private Label mathematicalExpressionLabel;
    
    public CalculatorController() {
        mathExprAsTokenList = new TokensList();
        mathExprAsTokenList.addListener(this);
        calculator = new Calculator();
    }
    
    @FXML
    private void addInputToExpr(ActionEvent event) {
        Button button = (Button) event.getSource();
        String input = button.getText();
        mathExprAsTokenList.add(input);
    }
        
    @FXML
    private void computeResult() throws IOException {
        String mathExpr = mathExprAsTokenList.concatTokensValues();
        String result = calculator.getResult(mathExpr);
        mathExprAsTokenList.clear();
        mathExprAsTokenList.add(result);
    }
    
    @FXML
    private void clearMathematicalExpression() throws IOException {
        mathExprAsTokenList.clear();
    }
    
    @FXML
    private void deleteLastTokenOfMathExpr() {
        int lastTokenPosition = mathExprAsTokenList.size() - 1;
        if (lastTokenPosition >= 0)
            mathExprAsTokenList.remove(lastTokenPosition);
    }
    
    private void updateMathematicalExpressionLabel() {
        String mathExpr = mathExprAsTokenList.concatTokensValues();
        mathematicalExpressionLabel.setText(mathExpr);
    }
    
    @Override
    public void onChanged(Change<? extends String> arg0) {
        updateMathematicalExpressionLabel();
    }
}
