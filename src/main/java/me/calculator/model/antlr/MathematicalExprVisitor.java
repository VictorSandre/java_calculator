// Generated from antlr/MathematicalExpr.g4 by ANTLR 4.9.3
package me.calculator.model.antlr;
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
	 * Visit a parse tree produced by {@link MathematicalExprParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MathematicalExprParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModExpr(MathematicalExprParser.ModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(MathematicalExprParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(MathematicalExprParser.DivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(MathematicalExprParser.MinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(MathematicalExprParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(MathematicalExprParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link MathematicalExprParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntAtom(MathematicalExprParser.IntAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleAtom}
	 * labeled alternative in {@link MathematicalExprParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleAtom(MathematicalExprParser.DoubleAtomContext ctx);
}