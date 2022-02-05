package me.calculator.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    
    private String mathExpression;

    private final Calculator calculator;

    public CalculatorTest() {
        calculator = new Calculator();
    }

    @Test
    public void testGetResultWithOnePositiveNumber() {
        mathExpression = "4";
        assertExprCalculatedResultEquals(mathExpression, "4.0");
    }

    @Test
    public void testGetResultWithOneNegativeNumber() {
        mathExpression = "-4";
        assertExprCalculatedResultEquals(mathExpression, "-4.0");
    }

    @Test
    public void testGetResultWithPlusExpr() {
        mathExpression = "4+5";
        assertExprCalculatedResultEquals(mathExpression, "9.0");
    }

    @Test
    public void testGetResultResultPositiveWithMinusExpr() {
        mathExpression = "5-4";
        assertExprCalculatedResultEquals(mathExpression, "1.0");
    }

    @Test
    public void testGetResultResultFromMinusMinusExpr() {
        mathExpression = "5--4";
        assertExprCalculatedResultEquals(mathExpression, "9.0");
    }

    @Test
    public void testGetResultResultNegativeWithMinusExpr() {
        mathExpression = "4-5";
        assertExprCalculatedResultEquals(mathExpression, "-1.0");
    }

    @Test
    public void testGetResultMultiplication() {
        mathExpression = "4*5";
        assertExprCalculatedResultEquals(mathExpression, "20.0");
    }

    @Test
    public void testGetResultMultiplicationByZero() {
        mathExpression = "4*0";
        assertExprCalculatedResultEquals(mathExpression, "0.0");
    }

    @Test
    public void testGetResultDivision() {
        mathExpression = "4/2";
        assertExprCalculatedResultEquals(mathExpression, "2.0");
    }

    @Test
    public void testGetResultDivisionByZero() {
        mathExpression = "4/0";
        assertExprCalculatedResultEquals(mathExpression, "Error");
    }

    @Test
    public void testGetResultModulo() {
        mathExpression = "4%2";
        assertExprCalculatedResultEquals(mathExpression, "0.0");
    }

    @Test
    public void testGestGetResultParenthesedPositiveNumber() {
        mathExpression = "(4)";
        assertExprCalculatedResultEquals(mathExpression, "4.0");

    }

    @Test
    public void testGestGetResultParenthesedNegativeNumber() {
        mathExpression = "(-4)";
        assertExprCalculatedResultEquals(mathExpression, "-4.0");
    }

    @Test
    public void testGetResultParenthesedMultPlusNumber() {
        mathExpression = "(-2 * 5) + 14";
        assertExprCalculatedResultEquals(mathExpression, "4.0");
    }

    @Test
    public void testGetResultUnparenthesedPriorityMultPlus() {
        mathExpression = "-2 * 5 + 14";
        assertExprCalculatedResultEquals(mathExpression, "4.0");
    }

    @Test
    public void testGetResultUnparenthesedPiorityMultOnDiv() {
        mathExpression = "10/2*5";
        assertExprCalculatedResultEquals(mathExpression, "25.0");
    }

    @Test
    public void testGetResultUnparenthesedPiorityDivOnMult() {
        mathExpression = "10*2/10*2";
        assertExprCalculatedResultEquals(mathExpression, "4.0");
    }

    @Test
    public void testGetResultModuloByZero() {
        mathExpression = "4%0";
        assertExprCalculatedResultEquals(mathExpression, "Error");
    }

    @Test
    public void testGetResultWithWrongSyntax() {
        mathExpression = "4@2";
        assertExprCalculatedResultEquals(mathExpression, "Error");
    }

    @Test
    public void testGetResultWithWrongGrammar() {
        mathExpression = "4//8";
        assertExprCalculatedResultEquals(mathExpression, "Error");
    }

    private void assertExprCalculatedResultEquals(final String expr,
            final String expected) {
        String result = calculator.getResult(mathExpression);
        assertEquals(expected.toString(), result);
    }
}
