package ch.wurmlo.week5;

import ch.wurmlo.week2.ClusteringUnionFind;
import ch.wurmlo.week2.Distance;
import ch.wurmlo.week2.DistancesReader;
import ch.wurmlo.week2.Point;
import org.apache.commons.lang3.StringUtils;
import org.jgrapht.UndirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class Question1 {

	@SuppressWarnings("UnusedDeclaration")
	private static Logger log = LoggerFactory.getLogger(Question1.class);

	public static void main(String[] args) {

		TspReader reader = null;
		try {
			reader = new TspReader("tsp.txt");
		} catch (IOException e) {
			System.err.println("Could not read file");
			System.exit(1);
		}

        List<City> cities = reader.getCities();

    }

}
