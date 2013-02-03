package ch.wurmlo.week6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static ch.wurmlo.week6.TwoSatSccChecker.isSatisfiable;

public class Question1 {

	@SuppressWarnings("UnusedDeclaration")
	private static Logger log = LoggerFactory.getLogger(Question1.class);

	@SuppressWarnings("unchecked")
    public static void main(String[] args) {

        String fileName = "2sat1.txt";
        TwoSatReader reader = null;
        try {
            reader = new TwoSatReader(fileName);
		} catch (IOException e) {
			log.error("Could not read file {}", fileName, e);
			System.exit(1);
		}

        long startTime = System.currentTimeMillis();
        boolean satisfiable = isSatisfiable(reader.getClauses());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        log.info("instance in file '{}' is satisfiable? {} (took {} seconds)", fileName, satisfiable, duration / 1000);
    }

}
