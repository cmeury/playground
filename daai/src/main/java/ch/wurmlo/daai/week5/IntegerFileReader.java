/**
 * Copyright 2012, netbreeze GmbH
 */
package ch.wurmlo.daai.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import ch.wurmlo.daai.week4.DirectedGraph;
import ch.wurmlo.daai.week4.rVertex;

public class IntegerFileReader {

	public List<Integer> readIntegerFile(String fileName) {
		InputStream stream = IntegerFileReader.class.getResourceAsStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		DirectedGraph graph = new DirectedGraph();
		List<Integer> integers = Lists.newArrayList();
		try {
			while(reader.ready()) {
				String line = reader.readLine();
				Integer integer = Integer.valueOf(line);
				if(integer != null) {
					integers.add(integer);
				}
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("Could not read the integer array file.", e);
		}
		return integers;
	}
}
