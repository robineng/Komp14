// Generated from /home/robin/Komp14/javagrammar.g4 by ANTLR 4.x

    package mjc;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link javagrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface javagrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link javagrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull javagrammarParser.ExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#methoddecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#mainclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainclass(@NotNull javagrammarParser.MainclassContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull javagrammarParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull javagrammarParser.StmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#formalrest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalrest(@NotNull javagrammarParser.FormalrestContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#formallist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormallist(@NotNull javagrammarParser.FormallistContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull javagrammarParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#classdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#exprest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprest(@NotNull javagrammarParser.ExprestContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#vardecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(@NotNull javagrammarParser.VardeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link javagrammarParser#explist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplist(@NotNull javagrammarParser.ExplistContext ctx);
}