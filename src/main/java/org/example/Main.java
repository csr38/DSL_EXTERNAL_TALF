package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSinkDOT;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "graph {\n" +
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

                generateGraphVisualization(weights);

                return null;
            }

            private void generateGraphVisualization(Map<String, Double> weights) {
                Graph graph = new DefaultGraph("Graph");

                // Agregar aristas al grafo
                for (String edge : weights.keySet()) {

                    String[] nodes = edge.split(" to ");

                    String source = nodes[0];
                    String target = nodes[1].split(" ")[0];

                    double weight = weights.get(edge);

                    // Verificar si el nodo ya existe antes de agregarlo
                    Node sourceNode = graph.getNode(source);
                    if (sourceNode == null) {
                        sourceNode = graph.addNode(source);
                    }

                    Node targetNode = graph.getNode(target);
                    if (targetNode == null) {
                        targetNode = graph.addNode(target);
                    }

                    graph.addEdge(edge, sourceNode, targetNode, true).setAttribute("weight", weight);
                }

                // Guardar el grafo en un archivo DOT
                try {
                    FileSinkDOT fileSinkDOT = new FileSinkDOT();
                    FileWriter fileWriter = new FileWriter("graph.dot");
                    fileSinkDOT.writeAll(graph, fileWriter);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Convertir el archivo DOT a una imagen utilizando Graphviz
                try {
                    String dotPath = "dot"; // Ruta al ejecutable de Graphviz en tu sistema
                    String outputFormat = "png"; // Formato de imagen de salida
                    String dotFile = "graph.dot"; // Archivo DOT generado anteriormente
                    String outputFile = "graph." + outputFormat; // Archivo de salida de la imagen

                    String command = dotPath + " -T" + outputFormat + " " + dotFile + " -o " + outputFile;
                    Process process = Runtime.getRuntime().exec(command);
                    process.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        visitor.visit(tree);
    }
}