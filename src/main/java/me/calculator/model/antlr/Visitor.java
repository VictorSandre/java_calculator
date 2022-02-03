package me.calculator.model.antlr;

import me.calculator.model.antlr.generated.MathExprBaseVisitor;
import me.calculator.model.antlr.generated.MathExprParser;

public final class Visitor extends MathExprBaseVisitor<Double> {

    @Override
    public Double visitStart(final MathExprParser.StartContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitDoubleAtom(final MathExprParser.DoubleAtomContext ctx) {
        return Double.parseDouble(ctx.DOUBLE().getText());
    }

    @Override
    public Double visitIntAtom(final MathExprParser.IntAtomContext ctx) {
        return Double.parseDouble(ctx.INT().getText());
    }

    @Override
    public Double visitNumberExpr(final MathExprParser.NumberExprContext ctx) {
        return super.visit(ctx.number());
    }

    @Override
    public Double visitNegativeNumber(final MathExprParser.NegativeNumberContext
            ctx) {
        return (super.visit(ctx.number()) * -1.0);
    }

    @Override
    public Double visitParenthesedExpr(
            final MathExprParser.ParenthesedExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitPlusTypeOperation(
            final MathExprParser.PlusTypeOperationContext ctx) {
        Double leftMember = visit(ctx.expression(0));
        Double rightMember = visit(ctx.expression(1));
        String operator = ctx.plusTypeOperator().getText();
        //TODO find a way to use a const PLUS instead of "+"
        if (operator.equals("+")) {
            return (leftMember + rightMember);
        } else {
            return (leftMember - rightMember);
        }
    }

    @Override
    public Double visitMultTypeOperation(
            final MathExprParser.MultTypeOperationContext ctx) {
        String operator = ctx.multTypeOperator().getText();
        Double leftMember = visit(ctx.expression(0));
        Double rightMember = visit(ctx.expression(1));
        //TODO find a way to use a const MULT instead of "*"
        if (operator.equals("*")) {
            return (leftMember * rightMember);
        } else {
            if (rightMember == 0) {
                throw new ArithmeticException();
            } else {
                //TODO find a way to use a const MULT from grammar instead of"*"
                if (operator.equals("/")) {
                    return (leftMember / rightMember);
                } else {
                    // Else I consider that operator is equals to modulo
                    //operation.
                    return (leftMember % rightMember);
                }
            }
        }
    }
}
