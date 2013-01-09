package ch.wurmlo.week1.mst;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return new EqualsBuilder().append(edgeCost, edge.edgeCost).
                                   append(getSource(), edge.getSource()).
                                   append(getTarget(), edge.getTarget()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(91,113).append(edgeCost).append(getSource()).append(getTarget()).toHashCode();
    }
}
