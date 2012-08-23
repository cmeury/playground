/**
 * Copyright 2012, netbreeze GmbH
 */
package ch.wurmlo.daai.week4;

import org.junit.Assert;
import org.junit.Test;
import com.google.common.collect.Lists;

public class DirectedGraphTest {

	@Test
	public void shouldReverseGraph() {
		// given
		DirectedGraph graph = new DirectedGraph();
		graph.connectVertices(new rVertex(1), Lists.newArrayList(new rVertex(5),new rVertex(6), new rVertex(7)));
		graph.connectVertices(new rVertex(2), Lists.newArrayList(new rVertex(3),new rVertex(4), new rVertex(5)));

		// when
		DirectedGraph reversedGraph = graph.getRevertedGraph();

		// then
		Assert.assertEquals(2, graph.currentTailsCount());
		Assert.assertEquals(5, reversedGraph.currentTailsCount());
		Assert.assertEquals(Lists.newArrayList(new rVertex(1), new rVertex(2)), reversedGraph.getConnectedVertices(new rVertex(5)));
		Assert.assertEquals(Lists.newArrayList(new rVertex(1)), reversedGraph.getConnectedVertices(new rVertex(6)));
		Assert.assertEquals(Lists.newArrayList(new rVertex(1)), reversedGraph.getConnectedVertices(new rVertex(7)));

		Assert.assertEquals(Lists.newArrayList(new rVertex(2)), reversedGraph.getConnectedVertices(new rVertex(3)));
		Assert.assertEquals(Lists.newArrayList(new rVertex(2)), reversedGraph.getConnectedVertices(new rVertex(4)));

	}

}
