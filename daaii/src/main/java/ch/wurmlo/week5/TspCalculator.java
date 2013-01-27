package ch.wurmlo.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Calculates minimum cost for the travelling salesman problem by dynamic programming.
 */
public class TspCalculator {

    private static Logger log = LoggerFactory.getLogger(TspCalculator.class);

    @SuppressWarnings("unchecked")
    public static int calculateTsp(List<City> cities) {

        log.info("generating subsets for {} cities", cities.size());
        List<Integer> cityIndices = new ArrayList<>();
        for (City city : cities) {
            cityIndices.add(cities.indexOf(city));
        }
        BitSet[] allSubsets = generateSubsets(cityIndices);
        Arrays.sort(allSubsets, new Comparator<BitSet>() {
            @Override
            public int compare(BitSet o1, BitSet o2) {
                return o1.cardinality() - o2.cardinality();
            }
        });
        log.info("{} subsets generated", allSubsets.length);

        Map<BitSet, Float[]> map = new HashMap<>();

        BitSet firstCity = new BitSet();
        firstCity.set(0);

        for (BitSet allSubset : allSubsets) {

            // we only calculate base-cases for m=0 and m=1
            if (allSubset.cardinality() > 2) {
                break;
            }

            Float[] floats = new Float[cities.size()];
            if (allSubset.equals(firstCity)) {
                floats[0] = 0f;
            } else {
                floats[0] = Float.MAX_VALUE;
            }
            map.put(allSubset, floats);
        }


        log.info("entering main dynamic programming loop");
        long startTime = System.currentTimeMillis();
        for (int m = 2; m < cities.size() +1; m++) {
            long mStartTime = System.currentTimeMillis();
            List<BitSet> subproblems = getBitSetsOfSize(allSubsets, m);

            // remove all bitsets from the dp map that are no longer needed
            if(m > 2) {
                List<BitSet> setsToDelete = getBitSetsOfSize(allSubsets, m-2);
                for (BitSet bitSet : setsToDelete) {
                    map.remove(bitSet);
                }
            }

            // allocate space for new subproblems
            for (BitSet subproblem : subproblems) {
                Float[] floats = new Float[cities.size()];
                if (subproblem.equals(firstCity)) {
                    floats[0] = 0f;
                } else {
                    floats[0] = Float.MAX_VALUE;
                }
                map.put(subproblem, floats);
            }

            for (BitSet subProblem : subproblems) {
                for (int j = subProblem.nextSetBit(0); j >= 0; j = subProblem.nextSetBit(j+1)) {   // here
                    if (j == 0) {
                        continue;
                    }

                    BitSet sMinusJ = (BitSet) subProblem.clone();
                    sMinusJ.clear(j);

                    List<Float> values = new ArrayList<>();
                    for (int k = subProblem.nextSetBit(0); k >= 0; k = subProblem.nextSetBit(k+1)) {
                        if (k == j) {
                            continue;
                        }
                        float val = map.get(sMinusJ)[k];
                        values.add(val + cities.get(j).distance(cities.get(k)));
                    }
                    map.get(subProblem)[j] = Collections.min(values);

                }
            }

            long curTime = System.currentTimeMillis();
            long mDuration = curTime - mStartTime;
            long tDuration = curTime - startTime;
            log.info("m = {} took {} seconds (total {})", m, mDuration / 1000, tDuration / 1000);

        }

        // get the right answer
        log.info("brute force search");
        List<Float> values = new ArrayList<>();
        BitSet allCities = new BitSet();
        allCities.set(0, cities.size());
        for (int j = 1; j < cities.size(); j++) {
            values.add(map.get(allCities)[j] + cities.get(j).distance(cities.get(0)));
        }
        double minimumCost = Collections.min(values);

        return ((Double) (Math.floor(minimumCost))).intValue();
    }

    private static List<BitSet> getBitSetsOfSize(BitSet[] allSubsets, int m) {
        List<BitSet> bitSets = new ArrayList<>();
        for (BitSet bitSet : allSubsets) {
            if(bitSet.cardinality() == m) {
                bitSets.add(bitSet);
            }
        }
        return bitSets;
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
