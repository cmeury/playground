package ch.wurmlo.week5;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Question1 {

	@SuppressWarnings("UnusedDeclaration")
	private static Logger log = LoggerFactory.getLogger(Question1.class);

	@SuppressWarnings("unchecked")
    public static void main(String[] args) {

        //  tsp_firstfive.txt =>  8387
        //  tsp_firstsix.txt => 8607
        //  tsp_simple.txt => 6

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

        log.info("generating subsets for {} cities", cities.size());
        List<City>[] allSubsets = generateSubsets(cities);
        log.info("{} subsets generated", allSubsets.length);
        double A[][] = new double[allSubsets.length][allSubsets.length];

        for (int i = 0; i < allSubsets.length; i++) {
            A[i][0] = i == 0 ? 0 : Double.MAX_VALUE;
        }

        for (int m = 2; m < n+1; m++) {
            log.info("collection minimums for problem size m={}", m);
            List<Integer> indicesOfSubsets = getIndicesOfSubsets(allSubsets, m);
            for (Integer sIndex : indicesOfSubsets) {
                List<City> subset = allSubsets[sIndex]; // subset <=> S
                for (City jCity : subset) {     // city <=>j
                    if (jCity.getCardinal() == 1) {
                        continue;
                    }

                    int j = jCity.getCardinal() - 1;
                    List<City> jRemoved = (List<City>) CollectionUtils.select(subset, PredicateUtils.notPredicate(PredicateUtils.equalPredicate(jCity)));
                    int tmpIndex = ArrayUtils.indexOf(allSubsets, jRemoved);

                    List<Double> values = new ArrayList<Double>();
                    for (City kCity : subset) {
                        if (kCity.equals(jCity)) {
                            continue;
                        }
                        int k = kCity.getCardinal() - 1;
                        values.add(A[tmpIndex][k] + jCity.distance(kCity));
                    }
                    Double min = Collections.min(values);
                    A[sIndex][j] = min;
                }
            }

        }

        log.info("brute force search");
        // brute force search over all paths
        List<Double> values = new ArrayList<Double>();
        for (int j = 1; j < cities.size(); j++) {
            values.add(A[allSubsets.length-1][j] + cities.get(j).distance(cities.get(0)));
        }

        double minimumCost = Collections.min(values);
        // print solution
        log.info("minium cost for file '{}' = {}", fileName, ((Double) (Math.floor(minimumCost))).intValue());
    }

    private static List<Integer> getIndicesOfSubsets(List<City>[] subsets, int size) {
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < subsets.length; i++) {
            if(subsets[i].size() == size) {
                indices.add(i);
            }
        }
        return indices;
    }

    /**
     * Taken from <a href="http://rosettacode.org/wiki/Power_Set#Java">Rosetta Code</a> library.
     * @param list original set
     * @param <T> type of items in the original set
     * @return list of all combinatoric, unique subsets
     */
    public static <T> List<List<T>> powerset(Collection<T> list) {
        List<List<T>> ps = new ArrayList<List<T>>();
        ps.add(new ArrayList<T>());   // add the empty set

        // for every item in the original list
        for (T item : list) {
            List<List<T>> newPs = new ArrayList<List<T>>();

            for (List<T> subset : ps) {
                // copy all of the current powerset's subsets
                newPs.add(subset);

                // plus the subsets appended with the current item
                List<T> newSubset = new ArrayList<T>(subset);
                newSubset.add(item);
                newPs.add(newSubset);
            }

            // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
            ps = newPs;
        }
        return ps;
    }

    @SuppressWarnings("unchecked")
    static List<City>[] generateSubsets(List<City> cities) {
        List<List<City>> powerset = powerset(cities.subList(1, cities.size()));
        for (List<City> cityList : powerset) {
            cityList.add(cities.get(0));
            Collections.sort(cityList);
        }
        return powerset.toArray(new List[powerset.size()]);
    }

}
