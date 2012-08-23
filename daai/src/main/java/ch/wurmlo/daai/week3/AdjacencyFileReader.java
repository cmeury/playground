/**
 * Copyright 2012, netbreeze GmbH
 */
package ch.wurmlo.daai.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import com.google.common.collect.Lists;
import ch.wurmlo.daai.GraphUtils;
import ch.wurmlo.daai.Vertex;

public class AdjacencyFileReader {

	public Graph readAdjacencyFile(String fileName) {
		InputStream stream = AdjacencyFileReader.class.getResourceAsStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		Graph graph = new Graph();
		try {
			while(reader.ready()) {
				String line = reader.readLine();
				List<Integer> integers = scanIntegers(line);
				if(integers.size() > 0) {
					// remove the first item and use the rest as the value, even though it might be
					// empty
					Integer key = integers.remove(0);
					graph.connectVertices(new Vertex(key), GraphUtils.convertToVertices
							                                                  (integers));
				}
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("Could not read the integer array file.", e);
		}
		return graph;
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
