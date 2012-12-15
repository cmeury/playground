package ch.wurmlo.week2;

import java.io.IOException;
import java.util.*;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.util.UnionFind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.wurmlo.week1.mst.Edge;

public class Question1 {

	private static Logger log = LoggerFactory.getLogger(Question1.class);

	public static void main(String[] args) {
		// translating file into list of jobs
		EdgesFileReader reader = null;
		try {
			reader = new EdgesFileReader("clustering1_small.txt");
		} catch (IOException e) {
			System.err.println("Could not read file");
			System.exit(1);
		}

		UndirectedGraph<Integer,Edge> graph = reader.getGraph();

		// sort edges in increasing cost
		Set<Edge> edges = graph.edgeSet();
		List<Edge> edgeList = new ArrayList<Edge>(edges);
		Collections.sort(edgeList, new Comparator<Edge>() {
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

		Set<Edge> T = new HashSet<Edge>();
		UnionFind<Integer> unionFind = new UnionFind<Integer>(graph.vertexSet());

		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			Integer source = graph.getEdgeSource(edge);
			Integer target = graph.getEdgeTarget(edge);
			if(false == unionFind.find(source).equals(unionFind.find(target))) {
				T.add(edge);
				unionFind.union(source, target);
			}
		}
		for (Edge edge : T) {
			System.out.println(edge);
		}

	}

}
