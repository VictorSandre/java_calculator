package me.calculator.model.antlr;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ParseTreeBuilderTest {

    private final ParseTreeBuilder astBuilder = new ParseTreeBuilder();

    @Test
    public void testBuildAstFromExpr_WithValidExpr_ThrowNoException() {
        //Given
        String mathematicalExpression = "2--2";

        //When
        //Then
        assertDoesNotThrow(()-> astBuilder
                .buildAstFromExpr(mathematicalExpression));
    }

    @Test
    public void testBuildAstFromExpr_WithWrongSyntax_ThrowExceptionOnParseExpr() {
        //Given
        String mathematicalExpression = "4@2";

        //When
        //Then
        assertThrows(ParseCancellationException.class, () -> {
            astBuilder.buildAstFromExpr(mathematicalExpression);
        }); 
    }

    @Test
    public void testBuildAstFromExpr_WithWrongSemantic_ThrowExceptionOnParseExpr() {
        //Given
        String mathematicalExpression = "4//8";

        //When
        //Then
        assertThrows(ParseCancellationException.class, () -> {
            astBuilder.buildAstFromExpr(mathematicalExpression);
        }); 
    }   
}
