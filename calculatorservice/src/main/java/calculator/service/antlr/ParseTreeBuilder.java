package calculator.service.antlr;


import calculator.service.antlr.generated.MathExprLexer;
import calculator.service.antlr.generated.MathExprParser;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

public final class ParseTreeBuilder {

    /**
     * This function build an Abstract syntax tree from an expression that
     * matches the grammar in MathExpr.g4 file.
     * @param expr
     * @return an abstract syntax tree that is evaluable.
     * @throws ParseCancellationException if a syntaxic or sementical error is
     * present in the expr.
     */
    public ParseTree buildAstFromExpr(final String expr)
            throws ParseCancellationException {
        CommonTokenStream tokens = lexing(expr);

        return parse(tokens);
    }

    private CommonTokenStream lexing(final String input) {
        MathExprLexer lexer;

        lexer = new MathExprLexer(CharStreams.fromString(input));

        return new CommonTokenStream(lexer);
    }

    private ParseTree parse(final CommonTokenStream tokens)
            throws ParseCancellationException {
        MathExprParser parser = new MathExprParser(tokens);
        // TODO implement a better way to handle Synatx and semantical errors.
        parser.setErrorHandler(new BailErrorStrategy());

        return parser.start();
    }
}
