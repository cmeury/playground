package ch.wurmlo.week6;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static ch.wurmlo.week6.TwoSatSccChecker.isSatisfiable;

public class Question1 {

	@SuppressWarnings("UnusedDeclaration")
	private static Logger log = LoggerFactory.getLogger(Question1.class);

	@SuppressWarnings("unchecked")
    public static void main(String[] args) {

        List<String> fileNames = Lists.newArrayList("2sat1.txt", "2sat2.txt", "2sat3.txt", "2sat4.txt", "2sat5.txt", "2sat6.txt");

        for (String fileName : fileNames) {

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

}
