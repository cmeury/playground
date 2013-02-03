package ch.wurmlo.week6;

import java.util.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class DirectedGraph {

	private Map<rVertex, List<rVertex>> graph;

	public DirectedGraph() {
		this.graph = new TreeMap<>();
	}

	public void connectVertices(rVertex vertex, List<rVertex> connectedVertices) {
		List<rVertex> vertices = graph.get(vertex);
		if(vertices == null) {
			graph.put(vertex, connectedVertices);
		} else {
			vertices.addAll(connectedVertices);
		}
	}

    public void connectVertex(rVertex vertex, rVertex connectedVertex) {
		List<rVertex> vertices = graph.get(vertex);
		if(vertices == null) {
            graph.put(vertex, Lists.newArrayList(connectedVertex));
        } else {
			vertices.add(connectedVertex);
		}
	}

	public List<rVertex> getConnectedVertices(rVertex vertex) {
		return graph.get(vertex);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (graph == null) {
			builder.append("Graph: []");
		} else {
			Set<rVertex> integers = this.graph.keySet();
			builder.append("Graph: \n");
			for (rVertex vertex : integers) {
				builder.append("[");
				builder.append(vertex.getId());
				builder.append(":");
				List<rVertex> edges = this.graph.get(vertex);
				boolean first = true;
				for (rVertex edge : edges) {
					if (!first) {
						builder.append(",");
					}
					first = false;
					builder.append(edge.getId());
				}
				builder.append("]\n");
			}
		}
		return builder.toString();
	}

	@Override
	public DirectedGraph clone() {
		DirectedGraph clone = new DirectedGraph();
		Set<rVertex> integers = this.graph.keySet();
		for (rVertex integer : integers) {
			clone.graph.put(integer.clone(), Lists.newArrayList(this.graph.get(integer)));
		}
		return clone;
	}

	public DirectedGraph getRevertedGraph() {
		DirectedGraph newGraph = new DirectedGraph();
		for(rVertex tail : graph.keySet()) {
			List<rVertex> heads = graph.get(tail);
			for(rVertex head : heads) {
				newGraph.connectVertices(head, Lists.newArrayList(tail));
			}
		}
		return newGraph;
	}

	public Iterator<rVertex> getTailsIterator() {
		return this.graph.keySet().iterator();
	}

	public void setAllVerticesToExploredFalse() {
		Set<rVertex> allVertices = Sets.newHashSet();
		for (rVertex rV : graph.keySet()) {
			allVertices.add(rV);
			allVertices.addAll(graph.get(rV));
		}
		for(rVertex rV : allVertices) {
			rV.setExplored(false);
		}
	}

}
