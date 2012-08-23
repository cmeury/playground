package ch.wurmlo.daai.week3;

import java.util.*;
import com.google.common.collect.Lists;
import ch.wurmlo.daai.Vertex;

public class Graph {

	private Map<Vertex, List<Vertex>> graph;
	private Random random = new Random(Calendar.getInstance().getTimeInMillis());

	public Graph() {
		this.graph = new TreeMap<Vertex, List<Vertex>>();
	}

	public void connectVertices(Vertex vertex, List<Vertex> connectedVertices) {
		List<Vertex> vertices = graph.get(vertex);
		if(vertices == null) {
			graph.put(vertex, connectedVertices);
		} else {
			vertices.addAll(connectedVertices);
		}
	}

	public List<Vertex> getConnectedVertices(Vertex vertex) {
		return graph.get(vertex);
	}

	public int currentVerticesCount() {
		return this.graph.keySet().size();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (graph == null) {
			builder.append("Graph: []");
		} else {
			Set<Vertex> integers = this.graph.keySet();
			builder.append("Graph: \n");
			for (Vertex vertex : integers) {
				builder.append("[");
				builder.append(vertex.getId());
				builder.append(":");
				List<Vertex> edges = this.graph.get(vertex);
				boolean first = true;
				for (Vertex edge : edges) {
					if (first == false) {
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
	public Graph clone() {
		Graph clone = new Graph();
		Set<Vertex> integers = this.graph.keySet();
		for (Vertex integer : integers) {
			clone.graph.put(integer, Lists.newArrayList(this.graph.get(integer)));
		}
		return clone;
	}


	public Vertex getRandomVertex() {
		Vertex[] vertices = graph.keySet().toArray(new Vertex[0]);
		int rndVertexIdx = random.nextInt(graph.keySet().size());
		return vertices[rndVertexIdx];
	}

	public Vertex getRandomConnectedVertex(Vertex vertex) {
		List<Vertex> vertices = getConnectedVertices(vertex);
		int rndConnectedIdx = random.nextInt(vertices.size());
		return vertices.get(rndConnectedIdx);
	}

	public void fuse(Vertex vertexA, Vertex vertexB) {
		// all connected vertices of A are now connected vertices of B, except the links to B
		List<Vertex> connectedVerticesA = getConnectedVertices(vertexA);
		if(connectedVerticesA.contains(vertexB) == false) {
			throw new RuntimeException("tried to fuse vertices which do not share an edge?");
		}
		while(connectedVerticesA.remove(vertexB)) {
			// remove all links to B
		}

		// update all references to A to point to B
		for(Vertex vtx : connectedVerticesA) {
			List<Vertex> connectionsOfAConnectedVertex = getConnectedVertices(vtx);
			while(connectionsOfAConnectedVertex.remove(vertexA)) {
				connectionsOfAConnectedVertex.add(vertexB);
			}
		}

		connectVertices(vertexB, connectedVerticesA);

		// ***
		// all connected vertices of A are now connected vertices of B, except the links to B
		// ***

		// remove A from B's connected vertices
		List<Vertex> connectedVerticesB = getConnectedVertices(vertexB);
		while(connectedVerticesB.remove(vertexA)) {
			// remove all A's
		}

		// remove A
		graph.remove(vertexA);
	}
}
