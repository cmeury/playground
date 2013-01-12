package ch.wurmlo.week4;

import ch.wurmlo.week1.mst.Edge;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Question1 {

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(Question1.class);

    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList("g1.txt", "g2.txt", "g3.txt");
        try {
            for (String fileName : fileNames) {
                DefaultDirectedGraph<Integer, Edge> graph = GraphFileReader.read(fileName);
                FloydWarshall fw = new FloydWarshall(graph);
                log.info("{} - shortest path={}, negative cycles={}", fileName, fw.getShortestPath(), fw.hasNegativeCycles());
            }
        } catch (GraphFileException e) {
            log.error("Could not read file: {}", e.getMessage());
            System.exit(1);
        }
    }

}
