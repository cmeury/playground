package ch.wurmlo.week1.mst;

import java.io.IOException;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgesFileReader {

	private static final Logger log = LoggerFactory.getLogger(EdgesFileReader.class);

	private final UndirectedGraph<Integer, Edge> g;

	public EdgesFileReader(String fileName) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> list = IOUtils.readLines(EdgesFileReader.class.getResourceAsStream(fileName));
		String firstLine = list.get(0);
		String[] firstLineSplit = StringUtils.split(firstLine, " ");
		int numberOfVertices = Integer.valueOf(firstLineSplit[0]);
		int numberOfEdges = Integer.valueOf(firstLineSplit[1]);
		g = new SimpleGraph<Integer, Edge>(Edge.class);
		for (String s : list.subList(1, list.size())) {
			String[] split = StringUtils.split(s, " ");
			int nodeA = Integer.valueOf(split[0]);
			int nodeB = Integer.valueOf(split[1]);
			int edgeCost = Integer.valueOf(split[2]);
			g.addVertex(nodeA);
			g.addVertex(nodeB);
			log.debug("adding edge with cost {} between vertex {} and {}", edgeCost, nodeA, nodeB);
			g.addEdge(nodeA, nodeB, new Edge(edgeCost));
		}
		if(g.edgeSet().size() != numberOfEdges) {
			throw new IOException("added edges does not match number specified in first line");
		}
		if(g.vertexSet().size() != numberOfVertices) {
			throw new IOException("added vertices does not match number specified in first line");
		}
	}

	public UndirectedGraph<Integer, Edge> getGraph() {
		return g;
	}
}
