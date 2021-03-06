package ch.wurmlo.week5;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TspReader {

	private static final Logger log = LoggerFactory.getLogger(TspReader.class);

    List<City> cities;

    @SuppressWarnings("unchecked")
    public TspReader(String fileName) throws IOException {
        InputStream stream = TspReader.class.getResourceAsStream(fileName);
        if(stream == null) {
            throw new FileNotFoundException();
        }
        List<String> list = IOUtils.readLines(stream);
        int numberOfCities = Integer.valueOf(list.get(0));
        List<City> cities = new ArrayList<>(numberOfCities);
        int cardinal = 1;
        for (String s : list.subList(1, list.size())) {
            String[] split = StringUtils.split(s, " ");
            float x = Float.valueOf(split[0]);
            float y = Float.valueOf(split[1]);
            cities.add(new City(x, y, cardinal++));
            log.debug("adding city with x={} and y={}", x, y);
        }
        if(cities.size() != numberOfCities) {
            log.error("mismatch: number of cities specified in header ({}) does not match actual amount ({})", numberOfCities, cities.size());
            throw new IOException();
        }
        this.cities = cities;
	}

    public List<City> getCities() {
        return cities;
    }
}
