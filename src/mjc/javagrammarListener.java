// Generated from /home/robin/Komp14/javagrammar.g4 by ANTLR 4.x

    package mjc;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link javagrammarParser}.
 */
public interface javagrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link javagrammarParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull javagrammarParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull javagrammarParser.ExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#methoddecl}.
	 * @param ctx the parse tree
	 */
	void enterMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#methoddecl}.
	 * @param ctx the parse tree
	 */
	void exitMethoddecl(@NotNull javagrammarParser.MethoddeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#mainclass}.
	 * @param ctx the parse tree
	 */
	void enterMainclass(@NotNull javagrammarParser.MainclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#mainclass}.
	 * @param ctx the parse tree
	 */
	void exitMainclass(@NotNull javagrammarParser.MainclassContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull javagrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull javagrammarParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull javagrammarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull javagrammarParser.StmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#formalrest}.
	 * @param ctx the parse tree
	 */
	void enterFormalrest(@NotNull javagrammarParser.FormalrestContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#formalrest}.
	 * @param ctx the parse tree
	 */
	void exitFormalrest(@NotNull javagrammarParser.FormalrestContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#formallist}.
	 * @param ctx the parse tree
	 */
	void enterFormallist(@NotNull javagrammarParser.FormallistContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#formallist}.
	 * @param ctx the parse tree
	 */
	void exitFormallist(@NotNull javagrammarParser.FormallistContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull javagrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull javagrammarParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#classdecl}.
	 * @param ctx the parse tree
	 */
	void enterClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#classdecl}.
	 * @param ctx the parse tree
	 */
	void exitClassdecl(@NotNull javagrammarParser.ClassdeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#exprest}.
	 * @param ctx the parse tree
	 */
	void enterExprest(@NotNull javagrammarParser.ExprestContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#exprest}.
	 * @param ctx the parse tree
	 */
	void exitExprest(@NotNull javagrammarParser.ExprestContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(@NotNull javagrammarParser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(@NotNull javagrammarParser.VardeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link javagrammarParser#explist}.
	 * @param ctx the parse tree
	 */
	void enterExplist(@NotNull javagrammarParser.ExplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link javagrammarParser#explist}.
	 * @param ctx the parse tree
	 */
	void exitExplist(@NotNull javagrammarParser.ExplistContext ctx);
}