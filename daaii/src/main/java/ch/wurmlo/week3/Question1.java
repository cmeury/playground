package ch.wurmlo.week3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Question1 {

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(Question1.class);

    public static void main(String[] args) {
        KnapSackReader reader = null;
        try {
            reader = new KnapSackReader("knapsack1.txt");
        } catch (IOException e) {
            System.err.println("Could not read file");
            System.exit(1);
        }
        int knapSackSize = reader.knapSackSize;
        int numberOfItems = reader.numberOfItems;
        int[] itemValues = reader.itemValues;
        int[] itemWeights = reader.itemWeights;

        int[][] dynamic = new int[numberOfItems][knapSackSize];
        // initialize A[0,x] = 0 for all x = 0,1,2,..,w
        for (int x = 0; x < knapSackSize; x++) {
            dynamic[0][x] = 0;
        }
        for (int i = 1; i < numberOfItems; i++) {
            for (int x = 0; x < knapSackSize; x++) {
                int value1 = dynamic[i-1][x];
                int value2 = itemWeights[i] > x ? 0 : dynamic[i-1][x-itemWeights[i]] + itemValues[i];
                dynamic[i][x] = Math.max(value1, value2);
            }
        }
        log.info("optimal solution: {}", dynamic[numberOfItems-1][knapSackSize-1]);
    }
}
