package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.Map;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws Exception {
        String input = "Graph {\n" +
                " A -> B (10)\n" +
                " B -> C (20)\n" +
                " D -> E (30)\n" +
                " A -> E (12)\n" +
                " B -> D (8)\n" +
                "}";

        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        GraphLexer lexer = new GraphLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        GraphParser parser = new GraphParser(tokenStream);



        ParseTree tree = parser.graph();
        GraphVisitor<Void> visitor = new GraphBaseVisitor<Void>() {
            Map<String, Double> weights = new HashMap<>();

            @Override
            public Void visitEdge(GraphParser.EdgeContext ctx) {
                String source = ctx.ID(0).getText();
                String target = ctx.ID(1).getText();
                double weight = Double.parseDouble(ctx.NUMBER().getText());
                String edge = String.format("%s to %s with weight %.1f", source, target, weight);
                weights.put(edge, weight);
                return null;
            }

            @Override
            public Void visitGraph(GraphParser.GraphContext ctx) {
                for (GraphParser.EdgeContext edgeContext : ctx.edge_list().edge()) {
                    visitEdge(edgeContext);
                }

                System.out.println("A B C D E");
                System.out.println("Edges ...");
                for (Map.Entry<String, Double> entry : weights.entrySet()) {
                    System.out.println(entry.getKey());
                }

                return null;
            }
        };

        visitor.visit(tree);
    }
}