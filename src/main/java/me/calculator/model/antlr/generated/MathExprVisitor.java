// Generated from antlr/MathExpr.g4 by ANTLR 4.9.3
package me.calculator.model.antlr.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MathExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MathExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MathExprParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MathExprParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multTypeOperation}
	 * labeled alternative in {@link MathExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultTypeOperation(MathExprParser.MultTypeOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MathExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(MathExprParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeNumber}
	 * labeled alternative in {@link MathExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeNumber(MathExprParser.NegativeNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusTypeOperation}
	 * labeled alternative in {@link MathExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusTypeOperation(MathExprParser.PlusTypeOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesedExpr}
	 * labeled alternative in {@link MathExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesedExpr(MathExprParser.ParenthesedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link MathExprParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntAtom(MathExprParser.IntAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleAtom}
	 * labeled alternative in {@link MathExprParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleAtom(MathExprParser.DoubleAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathExprParser#multTypeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultTypeOperator(MathExprParser.MultTypeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathExprParser#plusTypeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusTypeOperator(MathExprParser.PlusTypeOperatorContext ctx);
}