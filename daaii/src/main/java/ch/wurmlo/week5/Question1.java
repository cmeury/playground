package ch.wurmlo.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question1 {

	@SuppressWarnings("UnusedDeclaration")
	private static Logger log = LoggerFactory.getLogger(Question1.class);

	public static void main(String[] args) {

        String fileName = "tsp.txt";
        TspReader reader = null;
        try {
            reader = new TspReader(fileName);
		} catch (IOException e) {
			System.err.println("Could not read file");
			System.exit(1);
		}

        List<City> cities = reader.getCities();
        int n = cities.size();
        // tsp calculation

        double A[][] = new double[n][n];

        List<List<City>> allSubsets = generateSubsets(cities, cities.size());

        for (List<City> subset : allSubsets) {
            A[allSubsets.indexOf(subset)][1] = allSubsets.indexOf(subset) == 0 ? 0 : Double.MAX_VALUE;
        }

        for (int m = 1; m < n; m++) {
            List<List<City>> subsets = generateSubsets(cities, m);
            for (List<City> subset : subsets) {
                for (City city : subset) {
                    if(cities.indexOf(city) == 0) {
                        continue;
                    }
                    List<Double> values = new ArrayList<Double>();
                    for (City kCity : subset) {
                        if(kCity.equals(city)) {
                            continue;
                        }
                        int k = subset.indexOf(kCity);
                        int a = allSubsets.indexOf(subset) - cities.indexOf(city); // S - {j} how do we look up this?!
                        System.err.println("k = " + k + ", a = " + a);
                        values.add(A[a][k]+city.distance(kCity));
                    }
                    A[allSubsets.indexOf(subset)][cities.indexOf(city)] = Collections.min(values);
                }
            }

            
        }

        // brute force search over all paths
        List<Double> values = new ArrayList<Double>();
        for (int j = 1; j < cities.size(); j++) {
            values.add(A[allSubsets.indexOf(allSubsets.get(allSubsets.size()-1))][j] + cities.get(j).distance(cities.get(0)));
        }

        double minimumCost = Collections.min(values);
        // print solution
        log.info("minium cost for file '{}' = {}", fileName, ((Double) (Math.floor(minimumCost))).intValue());
    }

    static List<List<City>> generateSubsets(List<City> cities, int m) {
        int n = cities.size();
        List<List<City>> subsets = new ArrayList<List<City>>();
        // starting at 1 <=> do not take first city into account
        for (int i = 1; i < n; i++) {
            List<City> curCities = new ArrayList<City>();
            curCities.add(cities.get(i));
            for (int j = 1; j < n; j++) {
                if (curCities.size() >= m-1) {
                    break;
                }
                if (j == i) {
                    continue;
                }

                curCities.add(cities.get(j));
            }

            if(subsets.contains(curCities) == false) {
                subsets.add(curCities);
            }
        }

        // add first city that needs to be in every subset
        for (List<City> subset : subsets) {
            subset.add(cities.get(0));
        }
        return subsets;
    }

}
