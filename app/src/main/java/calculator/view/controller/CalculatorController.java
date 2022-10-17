package calculator.view.controller;

import calculator.service.Calculator;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.IOException;

public final class CalculatorController implements ListChangeListener<String> {

    /**
     * The calculator variable is used here in order to parse a string and give
     * a result if it's possible.
     */
    private final Calculator calculator;

    /**
     * Here I choosed to use a list of string to store the
     * mathematical expression as list of tokens instead of a simple string.
     * It allows me to consider the input 'cos' for example as an entire token.
     * The mathExprAsTokenList store the mathematical expression or the result
     * of previous mathematical expression.
     */
    private TokensList mathExprAsTokenList;

    /**
     * This label is useful to print the TokensList mathExprAsTokenList
     * to the user.
     */
    @FXML
    private Label mathematicalExpressionLabel;

    public CalculatorController() {
        mathExprAsTokenList = new TokensList();
        mathExprAsTokenList.addListener(this);
        calculator = new Calculator();
    }

    @FXML
    private void addInputToExpr(final ActionEvent event) {
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
        mathExprAsTokenList.removeLastToken();
    }

    /**
     * This function just parse the mathExprAsTokenList in order print it
     * in the view.
     */
    private void updateMathematicalExpressionLabel() {
        String mathExpr = mathExprAsTokenList.concatTokensValues();
        mathematicalExpressionLabel.setText(mathExpr);
    }

    @Override
    public void onChanged(final Change<? extends String> arg0) {
        updateMathematicalExpressionLabel();
    }
}
