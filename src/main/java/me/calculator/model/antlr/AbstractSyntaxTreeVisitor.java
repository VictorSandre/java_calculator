package me.calculator.model.antlr;

import me.calculator.model.antlr.generated.MathExprBaseVisitor;
import me.calculator.model.antlr.generated.MathExprParser;

public final class AbstractSyntaxTreeVisitor
        extends MathExprBaseVisitor<Double> {

    @Override
    public Double visitStart(final MathExprParser.StartContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitNumberExpr(final MathExprParser.NumberExprContext ctx) {
        String numberAsString = ctx.NUMBER().getText();
        return Double.parseDouble(numberAsString);
    }

    @Override
    public Double visitNegativeNumber(
            final MathExprParser.NegativeNumberContext ctx) {
        Double numberValue = Double.parseDouble(ctx.NUMBER().getText());
        return (numberValue * -1.0);
    }

    @Override
    public Double visitParenthesedExpr(
            final MathExprParser.ParenthesedExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitAddTypeOperation(
            final MathExprParser.AddTypeOperationContext ctx) {
        Double leftMember = visit(ctx.expression(0));
        Double rightMember = visit(ctx.expression(1));
        int operator = ctx.operator.getType();

        if (operator == MathExprParser.ADD) {
            return (leftMember + rightMember);
        } else {
            return (leftMember - rightMember);
        }
    }

    @Override
    public Double visitMultTypeOperation(
            final MathExprParser.MultTypeOperationContext ctx) {
        int operator = ctx.operator.getType();
        Double leftMember = visit(ctx.expression(0));
        Double rightMember = visit(ctx.expression(1));

        if (operator == MathExprParser.MULT) {
            return (leftMember * rightMember);
        } else {
            if (rightMember == 0) {
                throw new ArithmeticException();
            } else {
                if (operator == MathExprParser.DIV) {
                    return (leftMember / rightMember);
                // Else I consider that operator is equals to modulo operation.
                } else {
                    return (leftMember % rightMember);
                }
            }
        }
    }
}
