package ch.wurmlo.week6;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import com.google.common.collect.Lists;

import static com.google.common.collect.Lists.*;

public class SCC {

	private static Logger log = Logger.getLogger(SCC.class.getSimpleName());

	DirectedGraph graph;
	private int t;
	private List<rVertex> runningTimes;
	private rVertex s;
	private MultiMap leaders;

	public SCC(DirectedGraph graph) {
		this.graph = graph;
		leaders = new MultiValueMap();
		runningTimes = newArrayList();
	}

	public void calculate() {
		DirectedGraph reverted = graph.getRevertedGraph();
		System.err.println("reverted graph: " + reverted);
		System.err.println("running dfs1...");
		dfs1(reverted);
		System.err.println("number of finishing times: " + runningTimes.size());
		System.err.println("settings all vertices to explored == false...");
		graph.setAllVerticesToExploredFalse();
		System.err.println("running dfs2...");
		dfs2(graph);
	}

	private void dfs1(DirectedGraph graph) {
		t = 0;
		Iterator<rVertex> iterator = graph.getTailsIterator();
		while(iterator.hasNext()) {
			rVertex vertex = iterator.next();
			System.err.println("dfs1 main loop, vertex " + vertex.getId());
			if(vertex.isExplored() == false) {
				System.err.println("dfs1 vertex " + vertex.getId() + " is not yet explored");
				dfs1(graph, vertex);
			}
		}
	}

	private void dfs1(DirectedGraph graph, rVertex i) {
		i.setExplored(true);
		List<rVertex> vertices = graph.getConnectedVertices(i);
		if(vertices != null) {
			for(int c = vertices.size() - 1; c >= 0; c--) {
				rVertex j = vertices.get(c);
				if(j.isExplored() == false) {
					System.err.println("dfs1 II vertex " + j.getId() + " is not yet explored");
					dfs1(graph, j);
				}
			}
		}
		runningTimes.add(i);
	}

	private void dfs2(DirectedGraph graph) {
		s = null;
		Iterator<rVertex> iterator = graph.getTailsIterator();
		// decreasing order on second pass
		for (rVertex vertex : reverse(runningTimes)) {
			System.err.println("dfs2 main loop, vertex " + vertex.getId());
			if (vertex.isExplored() == false) {
				System.err.println("dfs2 vertex " + vertex.getId() + " is not yet explored");
				s = vertex;
				dfs2(graph, vertex);
			}
		}
	}

	private void dfs2(DirectedGraph graph, rVertex i) {
		i.setExplored(true);
		leaders.put(s, i);
		List<rVertex> vertices = graph.getConnectedVertices(i);
		if(vertices != null) {
			for(rVertex j : vertices) {
				if(j.isExplored() == false) {
					System.err.println("dfs2 II vertex " + j.getId() + " is not yet explored");
					dfs2(graph, j);
				}
			}
		}
	}

	public MultiMap getLeaders() {
		return leaders;
	}

	public DirectedGraph getGraph() {
		return graph;
	}

	public void setGraph(DirectedGraph graph) {
		this.graph = graph;
	}

}
