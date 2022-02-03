package me.calculator.model;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    
    private String mathematicalExpression;
    
    private Double result;
    
    private final Calculator calculator;
    
    public CalculatorTest() {
        calculator = new Calculator();
    }

    @Test
    public void testEvaluateExprWithOnePositiveNumber() {
        mathematicalExpression = "4";
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(Double.parseDouble(mathematicalExpression), result);
    }
    
    @Test
    public void testEvaluateExprWithOneNegativeNumber() {
        mathematicalExpression = "-4";
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(Double.parseDouble(mathematicalExpression), result);
    }
    
    @Test
    public void testEvaluateExprWithPlusExpr() {
        mathematicalExpression = "4+5";
        Double expectedResult = 9.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprResultPositiveWithMinusExpr() {
        mathematicalExpression = "5-4";
        Double expectedResult = 1.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprResultNegativeWithMinusExpr() {
        mathematicalExpression = "4-5";
        Double expectedResult = -1.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprMultiplication() {
        mathematicalExpression = "4*5";
        Double expectedResult = 20.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprMultiplicationByZero() {
        mathematicalExpression = "4*0";
        Double expectedResult = 0.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprDivision() {
        mathematicalExpression = "4/2";
        Double expectedResult = 2.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprDivisionByZero() {
        mathematicalExpression = "4/0";
        
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.evaluateExpr(mathematicalExpression);
        }); 
    }
    
    @Test
    public void testEvaluateExprModulo() {
        mathematicalExpression = "4%2";
        Double expectedResult = 0.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprParenthesedPositiveNumber() {
        mathematicalExpression = "(4)";
        Double expectedResult = 4.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprParenthesedNegativeNumber() {
        mathematicalExpression = "(-4)";
        Double expectedResult = -4.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprParenthesedMultPlusNumber() {
        mathematicalExpression = "(-2 * 5) + 14";
        Double expectedResult = 4.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprUnparenthesedPriorityMultPlus() {
        mathematicalExpression = "-2 * 5 + 14";
        Double expectedResult = 4.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprUnparenthesedPiorityMultOnDiv() {
        mathematicalExpression = "10/2*5";
        Double expectedResult = 25.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprUnparenthesedPiorityDivOnMult() {
        mathematicalExpression = "10*2/10*2";
        Double expectedResult = 4.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testEvaluateExprModuloByZero() {
        mathematicalExpression = "4%0";

        assertThrows(ArithmeticException.class, () -> {
            calculator.evaluateExpr(mathematicalExpression);
        }); 
    }
    
    @Test
    public void testEvaluateExprWithWrongSyntax() {
        mathematicalExpression = "4@2";
        
        assertThrows(ParseCancellationException.class, () -> {
            calculator.evaluateExpr(mathematicalExpression);
        }); 
    }
    
    @Test
    public void testEvaluateExprWithWrongGrammar() {
        mathematicalExpression = "4//8";

        assertThrows(ParseCancellationException.class, () -> {
            calculator.evaluateExpr(mathematicalExpression);
        }); 
    }   
}
