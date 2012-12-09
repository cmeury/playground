package ch.wurmlo.week1.mst;

import java.io.IOException;
import java.util.*;
import org.jgrapht.UndirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Question3 {

	private static final Logger log = LoggerFactory.getLogger(Question3.class);

	public static void main(String[] args) {

		// translating file into list of jobs
		EdgesFileReader reader = null;
		try {
			reader = new EdgesFileReader("edges.txt");
		} catch (IOException e) {
			System.err.println("Could not read file");
			System.exit(1);
		}

		// calculate MST
		UndirectedGraph<Integer,Edge> graph = reader.getGraph();
		Set<Edge> T = new HashSet<Edge>();
		Set<Integer> X = new HashSet<Integer>();
		Set<Integer> V = graph.vertexSet();
		Integer[] verticesArray = V.toArray(new Integer[V.size()]);
		X.add(verticesArray[0]);    // just take the first one
		while (!X.equals(V)) {

			List<Edge> edgesFromVerticesInX = new ArrayList<Edge>();
			// get all edges from vertices in X
			for (Integer vertexInX : X) {
				Set<Edge> edges = graph.edgesOf(vertexInX);
				// add only those that go out of X
				for (Edge edge : edges) {

					// we look at both source and target because the edges are stored sometimes
					// this, sometimes the other way - even though the graph is undirected
					Integer target = getRealTarget(graph, edge, vertexInX);

					if (!X.contains(target)) {
						edgesFromVerticesInX.add(edge);
					}
				}
			}
			Collections.sort(edgesFromVerticesInX, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					if(o1.getEdgeCost() < o2.getEdgeCost()) {
						return -1;
					} else if(o1.getEdgeCost() > o2.getEdgeCost()) {
						return 1;
					} else {
						return 0;
					}
				}
			});

			if(edgesFromVerticesInX.size() == 0) {
				throw new IllegalStateException("did not found any edges");
			}

			// take the one with the smallest cost
			Edge e = edgesFromVerticesInX.get(0);
			T.add(e);

			// we just lazily add both, if it is already added, it does not hurt
			Integer v1 = graph.getEdgeTarget(e);
			Integer v2 = graph.getEdgeSource(e);
			X.add(v1);
			X.add(v2);
		}

		int sum = 0;
		for (Edge edge : T) {
			sum += edge.getEdgeCost();
		}
		log.info("total sum = " + sum);
	}

	private static Integer getRealTarget(UndirectedGraph<Integer,Edge> graph, Edge edge, Integer vertexInX) {
		Integer edgeTarget = graph.getEdgeTarget(edge);
		Integer edgeSource = graph.getEdgeSource(edge);
		if (edgeTarget.equals(vertexInX)) {
			return edgeSource;
		}
		if (edgeSource.equals(vertexInX)) {
			return edgeTarget;
		}
		return null;
	}
}
