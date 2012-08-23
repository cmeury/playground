package ch.wurmlo.daai.week5;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections.MultiMap;
import com.google.common.collect.Lists;
import ch.wurmlo.daai.week4.AdjacencyFileReader;
import ch.wurmlo.daai.week4.DirectedGraph;
import ch.wurmlo.daai.week4.SCC;
import ch.wurmlo.daai.week4.rVertex;

public class Main {

	public static void main(String[] args) {
		IntegerFileReader reader = new IntegerFileReader();
		List<Integer> integers = reader.readIntegerFile("HashInt.txt");
		System.out.println(integers.size());

		HashTableBasedLookup lookup = new HashTableBasedLookup(integers);
		List<Integer> targetSums = Lists.newArrayList(231552, 234756, 596873, 648219, 726312,
				                                             981237, 988331, 1277361, 1283379);

		for(Integer sum : targetSums) {
			System.err.println("sum: " + sum);
			System.err.println("summands in map: " + lookup.summandsInMap(sum));
		}
	}

}
