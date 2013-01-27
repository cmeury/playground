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
			System.err.println("Could not read file");
			System.exit(1);
		}

        double min = TspCalculator.calculateTsp(reader.getCities());

        log.info("minium cost for file '{}' = {}", fileName, min);
    }

}
