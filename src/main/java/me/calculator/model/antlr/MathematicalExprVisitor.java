// Generated from language/recognition/MathematicalExpr.g4 by ANTLR 4.9.3
package me.calculator.model.antlr;
import language.recognition.*;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MathematicalExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MathematicalExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code binaryOperationExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperationExpr(MathematicalExprParser.BinaryOperationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numbeExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumbeExpr(MathematicalExprParser.NumbeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesedExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesedExpr(MathematicalExprParser.ParenthesedExprContext ctx);
}