package me.calculator.model.antlr;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParseTreeBuilderTest {

    private final ParseTreeBuilder astBuilder = new ParseTreeBuilder();

    @Test
    public void testThrowNoExceptionWithValidExpr() {
        String mathematicalExpression = "2--2";
        assertDoesNotThrow(()-> astBuilder
                .buildAstFromExpr(mathematicalExpression));
    }

    @Test
    public void testThrowExceptionOnParseExprWithWrongSyntax() {
        String mathematicalExpression = "4@2";

        assertThrows(ParseCancellationException.class, () -> {
            astBuilder.buildAstFromExpr(mathematicalExpression);
        }); 
    }

    @Test
    public void testThrowExceptionOnParseExprWithWrongSemantic() {
        String mathematicalExpression = "4//8";

        assertThrows(ParseCancellationException.class, () -> {
            astBuilder.buildAstFromExpr(mathematicalExpression);
        }); 
    }   
}
