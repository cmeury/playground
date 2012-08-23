package ch.wurmlo.daai.week4;

import java.util.*;
import org.apache.commons.collections.MultiMap;
import com.google.common.collect.Lists;

public class Main {

	public static void main(String[] args) {
  	runFile("SCC.txt");
//	    runFile("testcase1.txt");
//	    runFile("testcase2.txt");
//	    runFile("minimal.txt");
	}

	private static void runFile(String fileName) {
		AdjacencyFileReader reader = new AdjacencyFileReader();
		System.err.println("reading file " + fileName + " ...");
		DirectedGraph graph = reader.readAdjacencyFile(fileName);
		System.err.println(graph);

		System.err.println("creating scc...");
		SCC scc = new SCC(graph);
		System.err.println("calculating scc...");
		scc.calculate();
		MultiMap leaders = scc.getLeaders();
		System.err.println("there were " + leaders.size() + " SCCs");

		System.err.println("counting leaders...");
		List<Integer> sizes = Lists.newArrayList();
		Set set = leaders.keySet();
		for(Object o : set) {
			Collection c = (Collection) leaders.get(o);
			sizes.add(c.size());
		}
		System.err.println("sorting and reversing leaders...");
		Collections.sort(sizes);
		Collections.reverse(sizes);
//		if(sizes.size() < 5) {
//			throw new RuntimeException("less than 5 SCCs found");
//		}
		System.err.println("printing out the five largest SCCs in decreasing order...");
		System.err.println(sizes.get(0));
		System.err.println(sizes.get(1));
		System.err.println(sizes.get(2));
		System.err.println(sizes.get(3));
		System.err.println(sizes.get(4));
	}

	private static DirectedGraph createExampleGraph() {
		DirectedGraph graph = new DirectedGraph();
		rVertex v1 = new rVertex(1);
		rVertex v2 = new rVertex(2);
		rVertex v3 = new rVertex(3);
		rVertex v4 = new rVertex(4);
		rVertex v5 = new rVertex(5);
		rVertex v6 = new rVertex(6);
		rVertex v7 = new rVertex(7);
		rVertex v8 = new rVertex(8);
		rVertex v9 = new rVertex(9);

		connect(graph, v1, v7);
		connect(graph, v7, v4);
		connect(graph, v4, v1);

		connect(graph, v7, v9);

		connect(graph, v9, v6);
		connect(graph, v6, v3);
		connect(graph, v3, v9);

		connect(graph, v6, v8);

		connect(graph, v8, v2);
		connect(graph, v2, v5);
		connect(graph, v5, v8);

		return graph.getRevertedGraph();
	}

	private static void connect(DirectedGraph graph, rVertex a, rVertex b) {
		graph.connectVertices(a, Lists.newArrayList(b));
	}


}
