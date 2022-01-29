package me.calculator.model.antlr;

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
        Double leftMember = visit(ctx.expression(0));
        Double rightMember = visit(ctx.expression(1));
        String operator = ctx.plusTypeOperator().getText();
        
        if (operator.equals("+"))//TODO find a way to use a const PLUS instead of "+"
            return (leftMember + rightMember);
        else
            return (leftMember - rightMember);   
    }

    @Override
    public Double visitMultTypeOperation(MathematicalExprParser.MultTypeOperationContext ctx) {
        String operator = ctx.multTypeOperator().getText();
        Double leftMember = visit(ctx.expression(0));
        Double rightMember = visit(ctx.expression(1));
        
        if (operator.equals("*"))//TODO find a way to use a const MULT instead of "*"
            return (leftMember * rightMember);
        else {
            if (rightMember == 0)
                throw new ArithmeticException();
            else {
                if (operator.equals("/"))//TODO find a way to use a const MULT instead of "*"
                    return (leftMember / rightMember);
                else //I consider that the operator is equals to the modulo operation
                    return (leftMember % rightMember);
            }
        }
    }
}
