package ch.wurmlo.week2;

import org.jgrapht.graph.DefaultEdge;

/**
 * We use the reference-based built-in hashCode() and equals() because distances are not unique.
 */
public class Distance extends DefaultEdge {

	private int distance;

	public Distance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "(" + getSource() + " : " + getTarget() + ")[" + getDistance() + "]";
	}

	public int getDistance() {
		return distance;
	}


}
