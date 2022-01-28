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

    private CommonTokenStream lexing(String input) {
        MathematicalExprLexer lexer;
        
        lexer = new MathematicalExprLexer(CharStreams.fromString(input));
        return new CommonTokenStream(lexer);
    }
    
    private void parse(CommonTokenStream tokens) {
        parser = new MathematicalExprParser(tokens);
        parseTree = parser.start();
    }
    
    public double getMathematicalExprResult(String mathematicalExpr) {

        parse(lexing(mathematicalExpr));
        Double result = new Visitor().visit(parseTree);
        System.out.println("RESSSS"+result);
        return 0;
    }
}
