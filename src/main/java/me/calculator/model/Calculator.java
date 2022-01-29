package me.calculator.model;

import me.calculator.model.antlr.MathematicalExprErrorListener;
import me.calculator.model.antlr.MathematicalExprLexer;
import me.calculator.model.antlr.MathematicalExprParser;
import me.calculator.model.antlr.Visitor;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;


// TODO better way to handle Synatx and semantical errors
public class Calculator {

    private CommonTokenStream tokens;
    
    private MathematicalExprParser parser;
    
    private ParseTree parseTree;

    private CommonTokenStream lexing(String input) {
        MathematicalExprLexer lexer;
        
        lexer = new MathematicalExprLexer(CharStreams.fromString(input));
   
        return new CommonTokenStream(lexer);
    }
   
    private void parse(CommonTokenStream tokens) throws ParseCancellationException {
        parser = new MathematicalExprParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());    
        parseTree = parser.start();
    }
    
    /* TODO make this function private or refactor it in a new class 
     in order to test it */
    public Double evaluateExpr(String mathematicalExpr) throws ArithmeticException, ParseCancellationException {
        parse(lexing(mathematicalExpr));
        return new Visitor().visit(parseTree);
    }
    
    public String getResult(String mathematicalExpr)
    {       
        try {
            Double result = evaluateExpr(mathematicalExpr);
            return result.toString();
        } catch (ArithmeticException | ParseCancellationException e) {
            // TODO see if i return more explicit eror to view
            return "Error";
        }
    }
}
