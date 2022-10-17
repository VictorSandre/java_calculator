package calculator.service.antlr;

import calculator.service.antlr.generated.MathExprParser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbstractSyntaxTreeVisitorTest {
    
    private final AbstractSyntaxTreeVisitor astVisitor = new AbstractSyntaxTreeVisitor();

    @Test
    public void testVisitNumberExpr_WithAtomicNumber_ReturnNumber() {
       //Given
       final MathExprParser.NumberExprContext numberNode = mock(MathExprParser.NumberExprContext.class);
       final TerminalNodeImpl NumberAtomicLeaf = mock(TerminalNodeImpl.class);

       when(NumberAtomicLeaf.getText()).thenReturn("35");
       when(numberNode.NUMBER()).thenReturn(NumberAtomicLeaf);

       //When
       final Double astVisitorEvaluation = astVisitor.visitNumberExpr(numberNode);

       //Then
       assertThat(astVisitorEvaluation).isEqualTo(35.0);
    }

    @Test
    public void testVisitNegativeNumber_WithAtomicNumber_ReturnNumber() {
       //Given
       final MathExprParser.NegativeNumberContext numberNode = mock(MathExprParser.NegativeNumberContext.class);
       final TerminalNodeImpl NUMBERnode = mock(TerminalNodeImpl.class);

       when(NUMBERnode.getText()).thenReturn("35");
       when(numberNode.NUMBER()).thenReturn(NUMBERnode);

       //When
       final Double astVisitorEvaluation = astVisitor.visitNegativeNumber(numberNode);

       //Then
       assertThat(astVisitorEvaluation).isEqualTo(-35.0);
    }

    @Test
    public void testVisitAddTypeOperation_WithTwoNumber_ReturnExpectedEvaluation() {
        //Given
        final Token addToken = mock(Token.class);
        final MathExprParser.AddTypeOperationContext addNode = mock(MathExprParser.AddTypeOperationContext.class);
        addNode.operator = addToken;
        final MathExprParser.ExpressionContext leftMember
                = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 5.0);
        final MathExprParser.ExpressionContext rightMember
                = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 4.0);

        when(addNode.expression(0)).thenReturn(leftMember);
        when(addNode.expression(1)).thenReturn(rightMember);
        when(addToken.getType()).thenReturn(MathExprParser.ADD);

        //When
        final Double astVisitorEvaluation = astVisitor.visitAddTypeOperation(addNode);

        //Then
        assertThat(astVisitorEvaluation).isEqualTo(9.0);
    }

    @Test
    public void testVisitMultTypeOperation_WithTwoNumber_ReturnExpectedEvaluation() {
        //Given
        final Token divToken = mock(Token.class);
        final MathExprParser.MultTypeOperationContext divNode = mock(MathExprParser.MultTypeOperationContext.class);
        divNode.operator = divToken;
        final MathExprParser.ExpressionContext leftMember
                = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 5.0);
        final MathExprParser.ExpressionContext rightMember
                = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 0.0);

        when(divNode.expression(0)).thenReturn(leftMember);
        when(divNode.expression(1)).thenReturn(rightMember);
        when(divToken.getType()).thenReturn(MathExprParser.DIV);

        //When
        //Then
        assertThrows(ArithmeticException.class, () -> {
            astVisitor.visitMultTypeOperation(divNode);
        });
    }

    @Test
    public void testVisitMultTypeOperation_WithDivisionByZero_ThrowArethmicalException() {
        //Given
        final Token divToken = mock(Token.class);
        final MathExprParser.MultTypeOperationContext divNode  = mock(MathExprParser.MultTypeOperationContext.class);
        divNode.operator = divToken;
        final MathExprParser.ExpressionContext leftMember
                = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 5.0);
        final MathExprParser.ExpressionContext rightMember
                = mockVisitChildNodeResult(MathExprParser.ExpressionContext.class, 0.0);

        when(divNode.expression(0)).thenReturn(leftMember);
        when(divNode.expression(1)).thenReturn(rightMember);
        when(divToken.getType()).thenReturn(MathExprParser.MOD);

        //When
        //Then
        assertThrows(ArithmeticException.class, () -> {
            astVisitor.visitMultTypeOperation(divNode);
        });
    }

    private<T extends RuleContext> T mockVisitChildNodeResult(final Class<T> nodeType, final Double resultOfVisit) {
        final T mock = mock(nodeType);
        when(mock.accept(astVisitor)).thenReturn(resultOfVisit);
        return mock;
    }
}
