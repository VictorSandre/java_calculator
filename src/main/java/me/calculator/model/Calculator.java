package me.calculator.model;

import me.calculator.model.antlr.generated.MathExprLexer;
import me.calculator.model.antlr.generated.MathExprParser;
import me.calculator.model.antlr.Visitor;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

public final class Calculator {

    private CommonTokenStream lexing(final String input) {
        MathExprLexer lexer;

        lexer = new MathExprLexer(CharStreams.fromString(input));

        return new CommonTokenStream(lexer);
    }

    private ParseTree parse(final CommonTokenStream tokens)
            throws ParseCancellationException {
        MathExprParser parser;

        parser = new MathExprParser(tokens);
        // TODO implement a better way to handle Synatx and semantical errors.
        parser.setErrorHandler(new BailErrorStrategy());

        return parser.start();
    }

    /* TODO find a way to test this as private function or refactor it in a new
       class likes an ASTBuilder in order to test it
       TODO this function does 3 things i have got to explode it in 2 functions.
    */
    /**
     * This function evaluate an Abstract syntax tree (ParseTree) and return a
     * result or throw error if exception occurs during lexing, parsing or
     * evaluation.
     * @param mathematicalExpr
     * @return value of result of the mathematical expression.
     * @throws ArithmeticException
     * @throws ParseCancellationException
     */
    public Double evaluateExpr(final String mathematicalExpr)
            throws ArithmeticException, ParseCancellationException {
        ParseTree parseTree = parse(lexing(mathematicalExpr));
        return new Visitor().visit(parseTree);
    }

    /**
     * This method takes a expression as string and try to compute a result
     * from this expression.
     * @param mathematicalExpr a string that contain a mathematical expression
     * that should match with the grammar MathExpr.g4
     * @return the result of the mathematial expression if lexing, parsing and
     * evaluation of the builded AST has success. Return the message "Error"
     * otherwise.
     */
    public String getResult(final String mathematicalExpr) {
        try {
            Double result = evaluateExpr(mathematicalExpr);
            return result.toString();
        } catch (ArithmeticException | ParseCancellationException e) {
            // TODO see if i return more explicit eror to view
            return "Error";
        }
    }
}
