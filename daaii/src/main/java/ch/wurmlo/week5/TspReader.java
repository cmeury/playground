package ch.wurmlo.week5;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TspReader {

	private static final Logger log = LoggerFactory.getLogger(TspReader.class);

    List<City> cities;

    @SuppressWarnings("unchecked")
    public TspReader(String fileName) throws IOException {
        List<String> list = IOUtils.readLines(TspReader.class.getResourceAsStream(fileName));
        int numberOfCities = Integer.valueOf(list.get(0));
        List<City> cities = new ArrayList<City>(numberOfCities);
        for (String s : list.subList(1, list.size())) {
            String[] split = StringUtils.split(s, " ");
            double x = Double.valueOf(split[0]);
            double y = Double.valueOf(split[1]);
            cities.add(new City(x, y));
            log.debug("adding city with x={} and y={}", x, y);
        }
        if(cities.size() != numberOfCities) {
            log.error("mismatch: number of cities specifeid in header ({}) does not match actual amount ({})", numberOfCities, cities.size());
            throw new IOException();
        }
        this.cities = cities;
	}

    public List<City> getCities() {
        return cities;
    }
}
