package ch.wurmlo.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Question1 {

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(Question1.class);

    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList("g1.txt", "g2.txt", "g3.txt");
//        List<String> fileNames = Arrays.asList("small1.txt", "small2.txt");
        try {
            for (String fileName : fileNames) {
                FloydWarshall fw = new FloydWarshall(GraphFileReader.read(fileName));
                log.info("{} - shortest path={}, negative cycles={}", fileName, fw.getShortestPath(), fw.hasNegativeCycles());
            }
        } catch (GraphFileException e) {
            log.error("Could not read file: {}", e.getMessage());
            System.exit(1);
        }
    }

}
