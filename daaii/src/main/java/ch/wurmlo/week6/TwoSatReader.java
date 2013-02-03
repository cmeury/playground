package ch.wurmlo.week6;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TwoSatReader {

	private static final Logger log = LoggerFactory.getLogger(TwoSatReader.class);

    List<Clause> clauses;

    @SuppressWarnings("unchecked")
    public TwoSatReader(String fileName) throws IOException {
        InputStream stream = TwoSatReader.class.getResourceAsStream(fileName);
        if(stream == null) {
            throw new FileNotFoundException();
        }
        List<String> list = IOUtils.readLines(stream);
        int numOfClausesAndVars = Integer.valueOf(list.get(0));
        List<Clause> clauses = new ArrayList<>(numOfClausesAndVars);
        for (String s : list.subList(1, list.size())) {
            String[] split = StringUtils.split(s, " ");
            int first = Integer.valueOf(split[0]);
            int second = Integer.valueOf(split[1]);
            clauses.add(new Clause(first, second));
            log.debug("adding clause with first={} and second={}", first, second);
        }
        if(clauses.size() != numOfClausesAndVars) {
            log.error("mismatch: number of clauses specified in header ({}) does not match actual amount ({})", numOfClausesAndVars, clauses.size());
            throw new IOException();
        }
        this.clauses = clauses;
	}

    public List<Clause> getClauses() {
        return clauses;
    }

}
