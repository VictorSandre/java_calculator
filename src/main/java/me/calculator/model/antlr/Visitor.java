/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.calculator.model.antlr;

/**
 *
 * @author user
 */
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
    public Double visitPlusExpr(MathematicalExprParser.PlusExprContext ctx) {
        return (visit(ctx.expression(0)) + visit(ctx.expression(1)));
    }

    @Override
    public Double visitMinusExpr(MathematicalExprParser.MinusExprContext ctx) {
        return (visit(ctx.expression(0)) - visit(ctx.expression(1)));
    }

    @Override
    public Double visitNumberExpr(MathematicalExprParser.NumberExprContext ctx) {
        return super.visit(ctx.number()); 
    }
}
