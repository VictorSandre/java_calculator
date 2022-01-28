/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.calculator.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
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
    //TODO implement visitor division function
    public void testEvaluateExprDivisionByZero() {
        mathematicalExpression = "4/0";
        result = calculator.evaluateExpr(mathematicalExpression);
        
        fail("unsupported yet");
    }
    
    @Test
    public void testEvaluateExprModulo() {
        mathematicalExpression = "4%2";
        Double expectedResult = 0.0;
        result = calculator.evaluateExpr(mathematicalExpression);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    //TODO implement visitor modulo function
    public void testEvaluateExprModuloByZero() {
        mathematicalExpression = "4%0";
        result = calculator.evaluateExpr(mathematicalExpression);
        
        fail("unsupported yet");
    }
    
    @Test
    //TODO implement calculator error handeling
    public void testEvaluateExprWithWrongSyntax() {
        mathematicalExpression = "4@2";
        result = calculator.evaluateExpr(mathematicalExpression);
        
        fail("unsupported yet");
    }
    
    @Test
    //TODO implement calculator error handeling
    public void testEvaluateExprWithWrongGrammar() {
        mathematicalExpression = "4//0";
        result = calculator.evaluateExpr(mathematicalExpression);
        
        fail("unsupported yet");
    }
    
    
}
