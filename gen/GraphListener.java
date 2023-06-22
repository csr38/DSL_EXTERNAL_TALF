// Generated from C:/Users/cesar/IdeaProjects/TALF_aplicacion2\Graph.g4 by ANTLR 4.12.0

    package com.example;
  import java.util.Map;
  import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GraphParser}.
 */
public interface GraphListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GraphParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GraphParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GraphParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GraphParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GraphParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphParser#graph}.
	 * @param ctx the parse tree
	 */
	void enterGraph(GraphParser.GraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#graph}.
	 * @param ctx the parse tree
	 */
	void exitGraph(GraphParser.GraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphParser#edge_list}.
	 * @param ctx the parse tree
	 */
	void enterEdge_list(GraphParser.Edge_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#edge_list}.
	 * @param ctx the parse tree
	 */
	void exitEdge_list(GraphParser.Edge_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphParser#edge}.
	 * @param ctx the parse tree
	 */
	void enterEdge(GraphParser.EdgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphParser#edge}.
	 * @param ctx the parse tree
	 */
	void exitEdge(GraphParser.EdgeContext ctx);
}