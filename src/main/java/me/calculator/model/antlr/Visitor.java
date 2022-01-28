package me.calculator.model.antlr;

import me.calculator.model.antlr.MathematicalExprParser;

public class Visitor extends MathematicalExprBaseVisitor<Double>{
    
    @Override
    public Double visitStart(MathematicalExprParser.StartContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitDoubleAtom(MathematicalExprParser.DoubleAtomContext ctx) {
        return Double.parseDouble(ctx.DOUBLE().getText());
    }

    @Override
    public Double visitIntAtom(MathematicalExprParser.IntAtomContext ctx) {
        return Double.parseDouble(ctx.INT().getText());
    }

    @Override
    public Double visitNumberExpr(MathematicalExprParser.NumberExprContext ctx) {
        return super.visit(ctx.number()); 
    }

    @Override
    public Double visitNegativeNumber(MathematicalExprParser.NegativeNumberContext ctx) {
        return (super.visit(ctx.number()) * -1.0);
    }

    @Override
    public Double visitParenthesedExpr(MathematicalExprParser.ParenthesedExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitPlusTypeOperation(MathematicalExprParser.PlusTypeOperationContext ctx) {
        String operator = ctx.plusTypeOperator().getText();
        if (operator.equals("+"))//TODO find a way to use a const PLUS instead of "+"
            return (visit(ctx.expression(0)) + visit(ctx.expression(1)));
        else
            return (visit(ctx.expression(0)) - visit(ctx.expression(1)));   
    }

    @Override
    public Double visitMultTypeOperation(MathematicalExprParser.MultTypeOperationContext ctx) {
        String operator = ctx.multTypeOperator().getText();
        if (operator.equals("*"))//TODO find a way to use a const MULT instead of "*"
            return (visit(ctx.expression(0)) * visit(ctx.expression(1)));
        else {
            Double leftMember = visit(ctx.expression(1));
            if (leftMember == 0)
                throw new ArithmeticException();
            else {
                if (operator.equals("/"))
                    return (visit(ctx.expression(0)) / visit(ctx.expression(1)));
                else
                    return (visit(ctx.expression(0)) % visit(ctx.expression(1)));
            }
        }
    }
    
    
    
    
}
