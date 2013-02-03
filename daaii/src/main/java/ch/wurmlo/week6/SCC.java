package ch.wurmlo.week6;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.reverse;

public class SCC {

	DirectedGraph graph;
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
		dfs1(reverted);
		graph.setAllVerticesToExploredFalse();
		dfs2(graph);
	}

	private void dfs1(DirectedGraph graph) {
		Iterator<rVertex> iterator = graph.getTailsIterator();
		while(iterator.hasNext()) {
			rVertex vertex = iterator.next();
			if(vertex.isExplored() == false) {
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
					dfs1(graph, j);
				}
			}
		}
		runningTimes.add(i);
	}

	private void dfs2(DirectedGraph graph) {
		s = null;
		// decreasing order on second pass
		for (rVertex vertex : reverse(runningTimes)) {
			if (vertex.isExplored() == false) {
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
					dfs2(graph, j);
				}
			}
		}
	}

	public MultiMap getLeaders() {
		return leaders;
	}

}
