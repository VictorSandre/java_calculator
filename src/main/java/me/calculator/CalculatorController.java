package me.calculator;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CalculatorController {

    public CalculatorController() {
        mathematicalExpressionInputOrder = new LinkedList<String>();
    }
    
    @FXML
    private Label mathematicalExpressionLabel;
    
    private LinkedList<String> mathematicalExpressionInputOrder;
    
    @FXML
    private void addZeroToExpression() throws IOException {
        addStringToMathematicalExpression("0");
    }
    
    @FXML
    private void addOneToExpression() throws IOException {
        addStringToMathematicalExpression("1");
    }
    
    @FXML
    private void addTwoToExpression() throws IOException {
        addStringToMathematicalExpression("2");
    }
    
    @FXML
    private void addThreeToExpression() throws IOException {
        addStringToMathematicalExpression("3");
    }
    
    @FXML
    private void addFourToExpression() throws IOException {
        addStringToMathematicalExpression("4");
    }
    
    @FXML
    private void addFiveToExpression() throws IOException {
        addStringToMathematicalExpression("5");
    }
    
    @FXML
    private void addSixToExpression() throws IOException {
        addStringToMathematicalExpression("6");
    }
    
    @FXML
    private void addSevenToExpression() throws IOException {
        addStringToMathematicalExpression("7");
    }
    
    @FXML
    private void addEightToExpression() throws IOException {
        addStringToMathematicalExpression("8");
    }
    
    @FXML
    private void addNineToExpression() throws IOException {
        addStringToMathematicalExpression("9");
    }
    
    @FXML
    private void addPlusToExpression() throws IOException {
        addStringToMathematicalExpression("+");
    }
    
    @FXML
    private void addMinusToExpression() throws IOException {
        addStringToMathematicalExpression("-");
    }
    
    @FXML
    private void addMultiplicationToExpression() throws IOException {
        addStringToMathematicalExpression("*");
    }
    
    @FXML
    private void addDivisionToExpression() throws IOException {
        addStringToMathematicalExpression("/");
    }
    
        
    @FXML
    private void computeResult() throws IOException {
        throw new UnsupportedOperationException("unsupported yet");
    }
    
    @FXML
    private void clearMathematicalExpression() throws IOException {
        mathematicalExpressionInputOrder.clear();
        updateMathematicalExpressionLabel();
    }

    private void addStringToMathematicalExpression(String input) {
        mathematicalExpressionInputOrder.add(input);
        updateMathematicalExpressionLabel();
    }
    
    private void updateMathematicalExpressionLabel() {
        String mathematicalExpression = concatMathematicalExpressionValues();
        mathematicalExpressionLabel.setText(mathematicalExpression);
    }
    
    private String concatMathematicalExpressionValues() {
        StringBuilder fullMathematicalExpression = new StringBuilder();
        
        for (String expression : mathematicalExpressionInputOrder) {
            fullMathematicalExpression.append(expression);
        }
        return fullMathematicalExpression.toString();
    }
}
