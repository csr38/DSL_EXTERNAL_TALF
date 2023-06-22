// Generated from C:/Users/cesar/IdeaProjects/TALF_aplicacion2\Graph.g4 by ANTLR 4.12.0

  package org.example;

  import java.util.Map;
  import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GraphParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GraphVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GraphParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GraphParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GraphParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphParser#graph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraph(GraphParser.GraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphParser#edge_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdge_list(GraphParser.Edge_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphParser#edge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdge(GraphParser.EdgeContext ctx);
}