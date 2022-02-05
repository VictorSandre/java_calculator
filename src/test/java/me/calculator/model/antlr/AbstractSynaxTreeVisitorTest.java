package me.calculator.model.antlr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import me.calculator.model.antlr.generated.MathExprParser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;

// TODO refactorevery tests.
public class AbstractSynaxTreeVisitorTest {
    
    private final AbstractSynaxTreeVisitor astVisitor 
            = new AbstractSynaxTreeVisitor();

    @Test
    public void testGetResultWithOnePositiveNumber() {
       final MathExprParser.NumberExprContext numberNode;
       final TerminalNodeImpl NUMBERnode = mock(TerminalNodeImpl.class);
       final Double astVisitorEvaluation;
       numberNode = mock(MathExprParser.NumberExprContext.class);

       when(NUMBERnode.getText()).thenReturn("35");
       when(numberNode.NUMBER()).thenReturn(NUMBERnode);

       astVisitorEvaluation = astVisitor.visitNumberExpr(numberNode);
       assertEquals(astVisitorEvaluation, 35.0);
    }

    @Test
    public void testGetResultWithOneNegativeNumber() {
       final MathExprParser.NegativeNumberContext numberNode;
       final TerminalNodeImpl NUMBERnode = mock(TerminalNodeImpl.class);
       final Double astVisitorEvaluation;
       numberNode = mock(MathExprParser.NegativeNumberContext.class);

       when(NUMBERnode.getText())
               .thenReturn("35");
       when(numberNode.NUMBER())
               .thenReturn(NUMBERnode);

       astVisitorEvaluation = astVisitor.visitNegativeNumber(numberNode);
       assertEquals(astVisitorEvaluation, -35.0);
    }

    @Test
    public void testGetResultWithAddExpr() {
        final MathExprParser.AddTypeOperationContext addNode;
        final MathExprParser.ExpressionContext leftMember;
        final MathExprParser.ExpressionContext rightMember;
        final Token addToken;
        final Double astVisitorEvaluation;

        addNode = mock(MathExprParser.AddTypeOperationContext.class);
        leftMember = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 5.0);
        rightMember = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 4.0);
        addToken = mock(Token.class);
        addNode.operator = addToken;

        when(addNode.expression(0)).thenReturn(leftMember);
        when(addNode.expression(1)).thenReturn(rightMember);
        when(addToken.getType()).thenReturn(MathExprParser.ADD);

        astVisitorEvaluation = astVisitor.visitAddTypeOperation(addNode);
        assertEquals(astVisitorEvaluation, 9.0);
    }

    @Test
    public void testGetResultDivisionByZero() {
        final MathExprParser.MultTypeOperationContext divNode;
        final MathExprParser.ExpressionContext leftMember;
        final MathExprParser.ExpressionContext rightMember;
        final Token divToken;

        divNode = mock(MathExprParser.MultTypeOperationContext.class);
        leftMember = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 5.0);
        rightMember = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 0.0);
        divToken = mock(Token.class);
        divNode.operator = divToken;

        when(divNode.expression(0)).thenReturn(leftMember);
        when(divNode.expression(1)).thenReturn(rightMember);
        when(divToken.getType()).thenReturn(MathExprParser.DIV);

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            astVisitor.visitMultTypeOperation(divNode);
        });
    }

    @Test
    public void testGetResultModuloByZero() {
        final MathExprParser.MultTypeOperationContext divNode;
        final MathExprParser.ExpressionContext leftMember;
        final MathExprParser.ExpressionContext rightMember;
        final Token divToken;

        divNode = mock(MathExprParser.MultTypeOperationContext.class);
        leftMember = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 5.0);
        rightMember = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 0.0);
        divToken = mock(Token.class);
        divNode.operator = divToken;

        when(divNode.expression(0)).thenReturn(leftMember);
        when(divNode.expression(1)).thenReturn(rightMember);
        when(divToken.getType()).thenReturn(MathExprParser.MOD);

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            astVisitor.visitMultTypeOperation(divNode);
        });
    }

    private<T extends RuleContext> T mockVisitChildNodeResult(
            final Class<T> nodeType,
            final Double resultOfVisit) {
        final T mock = mock(nodeType);
        when(mock.accept(astVisitor)).thenReturn(resultOfVisit);
        return mock;
    }
}
