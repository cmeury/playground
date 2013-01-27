package ch.wurmlo.week5;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.BitSet;
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
        List<Integer> cityIndices = new ArrayList<>();
        for (City city : cities) {
            cityIndices.add(cities.indexOf(city));
        }
        BitSet[] allSubsets = generateSubsets(cityIndices);
        log.info("{} subsets generated", allSubsets.length);

        double A[][] = new double[allSubsets.length][allSubsets.length];

        // base cases
        for (int i = 0; i < allSubsets.length; i++) {
            A[i][0] = i == 0 ? 0 : Double.MAX_VALUE;
        }

        // main dynamic programming loop
        for (int m = 2; m < cities.size() +1; m++) {
            log.info("collection minimums for problem size m={}", m);
            List<BitSet> subproblems = getBitSetsOfSize(allSubsets, m);
            for (BitSet subProblem : subproblems) {
                int subProblemIndex = ArrayUtils.indexOf(allSubsets, subProblem);

                for (int j = subProblem.nextSetBit(0); j >= 0; j = subProblem.nextSetBit(j+1)) {
                    if (j == 0) {
                        continue;
                    }

                    BitSet sMinusJ = (BitSet) subProblem.clone();
                    sMinusJ.clear(j);
                    int tmpIndex = ArrayUtils.indexOf(allSubsets, sMinusJ);

                    List<Double> values = new ArrayList<>();
                    for (int k = subProblem.nextSetBit(0); k >= 0; k = subProblem.nextSetBit(k+1)) {
                        if (k == j) {
                            continue;
                        }
                        values.add(A[tmpIndex][k] + cities.get(j).distance(cities.get(k)));
                    }
                    A[subProblemIndex][j] = Collections.min(values);
                }
            }

        }

        // get the right answer
        log.info("brute force search");
        List<Double> values = new ArrayList<>();
        for (int j = 1; j < cities.size(); j++) {
            values.add(A[allSubsets.length-1][j] + cities.get(j).distance(cities.get(0)));
        }
        double minimumCost = Collections.min(values);

        return ((Double) (Math.floor(minimumCost))).intValue();
    }

    private static List<BitSet> getBitSetsOfSize(BitSet[] allSubsets, int m) {
        List<BitSet> bitSets = new ArrayList<>();
        for (BitSet bitSet : allSubsets) {
            if(countSetBits(bitSet) == m) {
                bitSets.add(bitSet);
            }
        }
        return bitSets;
    }

    private static int countSetBits(BitSet bitSet) {
        int count = 0;
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i+1)) {
            count++;
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    private static BitSet[] generateSubsets(List<Integer> cities) {
        List<BitSet> powerset = powerset(cities.subList(1, cities.size()));
        for (BitSet cityList : powerset) {
            cityList.set(0);
        }
        return powerset.toArray(new BitSet[powerset.size()]);
    }

    /**
     * Taken from <a href="http://rosettacode.org/wiki/Power_Set#Java">Rosetta Code</a> library, but optimized
     * by using {@code BitSet} after an anoymous hint in the Coursera discussion forum.
     * @param list original set
     * @return list of all combinatoric, unique subsets
     */
    public static List<BitSet> powerset(List<Integer> list) {
        List<BitSet> ps = new ArrayList<>();
        ps.add(new BitSet());   // add the empty set

        // for every item in the original list
        for (Integer item : list) {
            List<BitSet> newPs = new ArrayList<>();

            for (BitSet p : ps) {
                // copy all of the current powerset's subsets
                newPs.add(p);

                // plus the subsets appended with the current item
                BitSet newSubset = (BitSet) p.clone();
                newSubset.set(item);
                newPs.add(newSubset);
            }

            // powerset is now powerset of " list.subList(0, list.indexOf(item)+1) "
            ps = newPs;
        }
        return ps;
    }

}
