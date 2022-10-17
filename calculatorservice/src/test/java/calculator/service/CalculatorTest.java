package calculator.service;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private final Calculator calculator;

    public CalculatorTest() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "test with atomic expression : {0} sould return {1}")
    @CsvSource(
            {
                    "4,4.0",
                    "-4,-4.0"
            }
    )
    public void testGetResult_WithAtomicNumber_ReturnNumber(String mathExpressionInput, String expectedCalculatorResult) {
        //When
        String calculatorResult = calculator.getResult(mathExpressionInput);

        //Then
        assertThat(calculatorResult)
                .isEqualTo(expectedCalculatorResult);
    }

    @Test
    public void testGetResult_WithPlusExpr_ReturnResultOfAddition() {
        //When
        String calculatorResult = calculator.getResult("4+5");

        //Then
        assertThat(calculatorResult)
                .isEqualTo("9.0");
    }

    @ParameterizedTest(name = "getResult from substraction : {0} should return {1}")
    @CsvSource(
            {
                    "5-4,1.0",
                    "4-5,-1.0",
            }
    )
    public void testGetResult_WithMinusExpr_ReturnExpectedResult(String mathExpressionInput, String expectedCalculatorResult) {
        //When
        String calculatorResult = calculator.getResult(mathExpressionInput);

        //Then
        assertThat(calculatorResult)
                .isEqualTo(expectedCalculatorResult);
    }

    @ParameterizedTest(name = "getResult from multiplication : {0} should return {1}")
    @CsvSource(
            {
                    "4*5,20.0",
                    "-4*0,-0.0",
                    "4*0,0.0"
            }
    )
    public void testGetResult_WithMultiplicationExpr_ReturnExpectedResult(String mathExpressionInput, String expectedCalculatorResult) {
        //When
        String calculatorResult = calculator.getResult(mathExpressionInput);

        //Then
        assertThat(calculatorResult)
                .isEqualTo(expectedCalculatorResult);
    }

    @ParameterizedTest(name = "getResult from division : {0} should return {1}")
    @CsvSource(
            {
                    "4/2,2.0",
                    "-4/2,-2.0",
                    "3/2,1.5"
            }
    )
    public void testGetResult_WithDivisionExpr_ReturnExpectedResult(String mathExpressionInput, String expectedCalculatorResult) {
        //When
        String calculatorResult = calculator.getResult(mathExpressionInput);

        //Then
        assertThat(calculatorResult)
                .isEqualTo(expectedCalculatorResult);
    }

    @Test
    public void testGetResult_WithModuloExpr_ReturnExpectedResult() {
        //When
        String calculatorResult = calculator.getResult("4%2");

        //Then
        assertThat(calculatorResult)
                .isEqualTo("0.0");
    }

    @Tag("CalculationOnExpressionReturnError")
    @ParameterizedTest(name = "getResult operation : {0} should return {1}")
    @CsvSource(
            {
                    "4/0,Error",
                    "-4%0,Error",
            }
    )
    public void testGetResult_WithWrongArithmicalExpr_ReturnErrorMessage(String mathExpressionInput, String expectedCalculatorResult) {
        //When
        String calculatorResult = calculator.getResult(mathExpressionInput);

        //Then
        assertThat(calculatorResult)
                .isEqualTo(expectedCalculatorResult);
    }

    @Test
    @Tag("CalculationOnExpressionReturnError")
    public void testGetResult_WithWrongSyntaxExpr_ReturnErrorMessage() {
        //When
        String calculatorResult = calculator.getResult("4@2");

        //Then
        assertThat(calculatorResult)
                .isEqualTo("Error");
    }

    @Tag("CalculationOnExpressionReturnError")
    @ParameterizedTest(name = "getResult operation : {0} should return {1}")
    @CsvSource(
            {
                    "4//8,Error",
                    "4---2,Error",
                    "4+.2,Error",
                    ".2,Error"
            }
    )
    public void testGetResult_WithWrongGrammarExpr_ReturnErrorMessage(String mathExpressionInput, String expectedCalculatorResult) {
        //When
        String calculatorResult = calculator.getResult(mathExpressionInput);

        //Then
        assertThat(calculatorResult)
                .isEqualTo(expectedCalculatorResult);
    }

    @ParameterizedTest(name = "getResult operation : {0} should return {1}")
    @CsvSource(
            {
                    "5--4,9.0",
                    "(4),4.0",
                    "(-4),-4.0",
                    "(-2 * 5) + 14,4.0",
                    "-2 * 5 + 14,4.0",
                    "10/2*5,25.0",
                    "10*2/10*2,4.0"
            }
    )
    public void testGetResult_WithPriority_ReturnExpectedResult(String mathExpressionInput, String expectedCalculatorResult) {
        //When
        String calculatorResult = calculator.getResult(mathExpressionInput);

        //Then
        assertThat(calculatorResult)
                .isEqualTo(expectedCalculatorResult);
    }
}
