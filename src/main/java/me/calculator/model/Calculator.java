/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.calculator.model;



import me.calculator.model.antlr.MathematicalExprLexer;
import me.calculator.model.antlr.MathematicalExprParser;
import me.calculator.model.antlr.Visitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {

    private CommonTokenStream tokens;
    
    private MathematicalExprParser parser;
    
    private ParseTree parseTree;
    
    public Calculator() {
    }

    // TODO handle error during lexing
    private CommonTokenStream lexing(String input) {
        MathematicalExprLexer lexer;
        
        lexer = new MathematicalExprLexer(CharStreams.fromString(input));
        return new CommonTokenStream(lexer);
    }
    
    // TODO handle error during parsing
    private void parse(CommonTokenStream tokens) {
        parser = new MathematicalExprParser(tokens);
        parseTree = parser.start();
    }
    
    //TODO handle error like div by zero
    //TODO make this function private or refactor it in a new class 
    // in order to test it
    public Double evaluateExpr(String mathematicalExpr) {
        parse(lexing(mathematicalExpr));
        Double result = new Visitor().visit(parseTree);
        System.out.println("result::" + result);
        return result;
    }
    
    public String getResult(String mathematicalExpr)
    {
        try {
            Double result = evaluateExpr(mathematicalExpr);
            return result.toString();
        } catch (Exception e) {
            // TODO see if i return more explicit eror to view
            return "Error";
        }
    }
}
