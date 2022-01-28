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
	 * Visit a parse tree produced by the {@code multTypeOperation}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultTypeOperation(MathematicalExprParser.MultTypeOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(MathematicalExprParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeNumber}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeNumber(MathematicalExprParser.NegativeNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusTypeOperation}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusTypeOperation(MathematicalExprParser.PlusTypeOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesedExpr}
	 * labeled alternative in {@link MathematicalExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesedExpr(MathematicalExprParser.ParenthesedExprContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link MathematicalExprParser#multTypeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultTypeOperator(MathematicalExprParser.MultTypeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalExprParser#plusTypeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusTypeOperator(MathematicalExprParser.PlusTypeOperatorContext ctx);
}