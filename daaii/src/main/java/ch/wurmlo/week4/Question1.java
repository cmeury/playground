package ch.wurmlo.week4;

import ch.wurmlo.week1.mst.Edge;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Question1 {

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(Question1.class);

    public static void main(String[] args) {
        DefaultDirectedGraph<Integer,Edge> g1;
        DefaultDirectedGraph<Integer,Edge> g2;
        DefaultDirectedGraph<Integer,Edge> g3;
        try {
            g1 = GraphFileReader.read("g1.txt");
            g2 = GraphFileReader.read("g2.txt");
            g3 = GraphFileReader.read("g3.txt");
        } catch (GraphFileException e) {
            log.error("Could not read file: {}", e.getMessage());
            System.exit(1);
        }


    }

}
