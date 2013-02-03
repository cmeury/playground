/**
 * Copyright 2012, netbreeze GmbH
 */
package ch.wurmlo.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class AdjacencyFileReader {

	private Map<Integer, rVertex> addedVertices = Maps.newHashMap();

	public DirectedGraph readAdjacencyFile(String fileName) {
		InputStream stream = AdjacencyFileReader.class.getResourceAsStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		DirectedGraph graph = new DirectedGraph();
		try {
			while(reader.ready()) {
				String line = reader.readLine();
				List<Integer> integers = scanIntegers(line);
				if(integers.size() > 0) {
					// remove the first item and use the rest as the value, even though it might be
					// empty
					Integer key = integers.remove(0);

					rVertex keyVertex = getOrCreateRevVertex(key);

					List<rVertex> vertices = Lists.newArrayList();
					for (Integer integer : integers) {
						vertices.add(getOrCreateRevVertex(integer));
					}

					graph.connectVertices(keyVertex, vertices);
				}
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("Could not read the integer array file.", e);
		}
		return graph;
	}

	private rVertex getOrCreateRevVertex(Integer key) {
		rVertex rVertex = addedVertices.get(key);
		if(rVertex == null) {
			rVertex newRVertex = new rVertex(key);
			addedVertices.put(key, newRVertex);
			return newRVertex;
		} else {
			return rVertex;
		}
	}

	private List<Integer> scanIntegers(String line) {
		List<Integer> butFirstList = Lists.newArrayList();
		Scanner scanner = new Scanner(line);
		while(scanner.hasNextInt()) {
			butFirstList.add(scanner.nextInt());
		}
		return butFirstList;
	}
}
