// Generated from language/recognition/MathematicalExpr.g4 by ANTLR 4.9.3
package me.calculator.model.antlr;
import me.calculator.model.antlr.MathematicalExprVisitor;
import language.recognition.*;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link MathematicalExprVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class MathematicalExprBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements MathematicalExprVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBinaryOperationExpr(MathematicalExprParser.BinaryOperationExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNumbeExpr(MathematicalExprParser.NumbeExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParenthesedExpr(MathematicalExprParser.ParenthesedExprContext ctx) { return visitChildren(ctx); }
}