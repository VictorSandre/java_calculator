package me.calculator.model;

import me.calculator.model.antlr.AbstractSynaxTreeVisitor;
import me.calculator.model.antlr.ParseTreeBuilder;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

public final class Calculator {

    /**
     * This method takes a expression as string and try to compute a result
     * from this expression.
     * @param mathematicalExpr a string that contain a mathematical expression
     * that should match with the grammar MathExpr.g4
     * @return the result of the mathematical expression if lexing, parsing and
     * evaluation of the builded AST has success. Return the message "Error"
     * otherwise.
     */
    public String getResult(final String mathematicalExpr) {
        ParseTree ast;
        try {
            ast = new ParseTreeBuilder().buildAstFromExpr(mathematicalExpr);
            Double result = evaluateExpr(ast);
            return result.toString();
        } catch (ArithmeticException | ParseCancellationException e) {
            // TODO define if I return more explicit error to the view
            return "Error";
        }
    }

    private Double evaluateExpr(final ParseTree ast) 
            throws ArithmeticException {
        return new AbstractSynaxTreeVisitor().visit(ast);
    }
}
