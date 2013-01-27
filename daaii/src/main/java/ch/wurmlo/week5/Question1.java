package ch.wurmlo.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Question1 {

	@SuppressWarnings("UnusedDeclaration")
	private static Logger log = LoggerFactory.getLogger(Question1.class);

	@SuppressWarnings("unchecked")
    public static void main(String[] args) {

        String fileName = "tsp.txt";
        TspReader reader = null;
        try {
            reader = new TspReader(fileName);
		} catch (IOException e) {
			log.error("Could not read file {}", fileName, e);
			System.exit(1);
		}

        long startTime = System.currentTimeMillis();
        int min = TspCalculator.calculateTsp(reader.getCities());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        log.info("minium cost for file '{}' = {} (took {} seconds)", fileName, min, duration / 1000);
    }

}
