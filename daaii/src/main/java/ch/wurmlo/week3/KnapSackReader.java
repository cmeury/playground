package ch.wurmlo.week3;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class KnapSackReader {

	private static final Logger log = LoggerFactory.getLogger(KnapSackReader.class);

    public int knapSackSize;
    public int numberOfItems;
    public int[] itemValues;
    public int[] itemWeights;

	public KnapSackReader(String fileName) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> list = IOUtils.readLines(KnapSackReader.class.getResourceAsStream(fileName));

        String firstLine = list.get(0);
        String[] firstLineSplit = StringUtils.split(firstLine, " ");
        knapSackSize = Integer.valueOf(firstLineSplit[0]);
        numberOfItems = Integer.valueOf(firstLineSplit[1]);
        itemValues = new int[numberOfItems];
        itemWeights = new int[numberOfItems];
        int i = 0;
        try {
            for (String s : list.subList(1, list.size())) {
                String[] split = StringUtils.split(s, " ");
                itemValues[i] = Integer.valueOf(split[0]);
                itemWeights[i] = Integer.valueOf(split[1]);
                log.debug("added item with value {} and weight{}", itemValues[i], itemWeights[i]);
                i++;
    		}
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException("items in file do not add up to totals given in first line");
		}
	}

}
