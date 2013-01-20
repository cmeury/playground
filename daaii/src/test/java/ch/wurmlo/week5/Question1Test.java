package ch.wurmlo.week5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Question1Test {

    @Test
    public void shouldGenerateSubsets() throws Exception {

        // given
        List<City> cities = new ArrayList<City>();
        City c1 = new City(1, 1);
        cities.add(c1);
        City c2 = new City(2, 2);
        cities.add(c2);
        City c3 = new City(3, 3);
        cities.add(c3);
        City c4 = new City(4, 4);
        cities.add(c4);

        // when
        List<List<City>> lists = Question1.generateSubsets(cities, 2);

        // then
        List<List<City>> expected= new ArrayList<List<City>>();
        expected.add(Arrays.asList(c2, c1));
        expected.add(Arrays.asList(c3, c1));
        expected.add(Arrays.asList(c4, c1));

        assertEquals(expected, lists);
    }

    public static void main(String[] args) {
        List<City> cities = new ArrayList<City>();
        City c1 = new City(1, 1);
        cities.add(c1);
        City c2 = new City(2, 2);
        cities.add(c2);
        City c3 = new City(3, 3);
        cities.add(c3);
        City c4 = new City(4, 4);
        cities.add(c4);

        List<List<City>> lists = Question1.generateSubsets(cities, 3);

        for (List<City> list : lists) {
            System.err.println("Subset number " + lists.indexOf(list));
            for (City city : list) {
                System.err.println(city);
            }
            System.err.println("------------");
        }
    }
}
