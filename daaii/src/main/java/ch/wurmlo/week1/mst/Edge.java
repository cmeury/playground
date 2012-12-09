package ch.wurmlo.week1.mst;

import org.jgrapht.graph.DefaultEdge;

public class Edge extends DefaultEdge {

	private int edgeCost;

	public Edge(int edgeCost) {
		this.edgeCost = edgeCost;
	}

	@Override
	public String toString() {
		return "(" + getSource() + " : " + getTarget() + ")[" + getEdgeCost() + "]";
	}

	public int getEdgeCost() {
		return edgeCost;
	}


}
