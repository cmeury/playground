package ch.wurmlo.week5;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Calculates minimum cost for the travelling salesman problem by dynamic programming.
 */
public class TspCalculator {

    private static Logger log = LoggerFactory.getLogger(TspCalculator.class);

    @SuppressWarnings("unchecked")
    public static double calculateTsp(List<City> cities) {

        log.info("generating subsets for {} cities", cities.size());
        List<Integer> cityIndices = new ArrayList<Integer>();
        for (City city : cities) {
            cityIndices.add(cities.indexOf(city));
        }
        List<Integer>[] allSubsets = generateSubsets(cityIndices);
        log.info("{} subsets generated", allSubsets.length);

        double A[][] = new double[allSubsets.length][allSubsets.length];

        // base cases
        for (int i = 0; i < allSubsets.length; i++) {
            A[i][0] = i == 0 ? 0 : Double.MAX_VALUE;
        }

        // main dynamic programming loop
        for (int m = 2; m < cities.size() +1; m++) {
            log.info("collection minimums for problem size m={}", m);
            List<Integer> indicesOfSubsets = getIndicesOfSubsets(allSubsets, m);
            for (Integer sIndex : indicesOfSubsets) {
                List<Integer> subset = allSubsets[sIndex]; // subset <=> S
                for (int j : subset) {
                    if (j == 0) {
                        continue;
                    }

                    // {S} - j
                    List<City> jRemoved = (List<City>) CollectionUtils.select(subset, PredicateUtils.notPredicate(PredicateUtils.equalPredicate(j)));
                    int tmpIndex = ArrayUtils.indexOf(allSubsets, jRemoved);

                    List<Double> values = new ArrayList<Double>();
                    for (int k : subset) {
                        if (k == j) {
                            continue;
                        }
                        values.add(A[tmpIndex][k] + cities.get(j).distance(cities.get(k)));
                    }
                    Double min = Collections.min(values);
                    A[sIndex][j] = min;
                }
            }

        }

        // get the right answer
        log.info("brute force search");
        List<Double> values = new ArrayList<Double>();
        for (int j = 1; j < cities.size(); j++) {
            values.add(A[allSubsets.length-1][j] + cities.get(j).distance(cities.get(0)));
        }
        double minimumCost = Collections.min(values);

        return ((Double) (Math.floor(minimumCost))).intValue();
    }

    private static List<Integer> getIndicesOfSubsets(List<Integer>[] subsets, int size) {
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
    private static <T> List<List<T>> powerset(Collection<T> list) {
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
    private static List<Integer>[] generateSubsets(List<Integer> cities) {
        List<List<Integer>> powerset = powerset(cities.subList(1, cities.size()));
        for (List<Integer> cityList : powerset) {
            cityList.add(0);
            Collections.sort(cityList);
        }
        return powerset.toArray(new List[powerset.size()]);
    }
}
