package ch.wurmlo.week2;

import java.io.IOException;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistancesReader {

	private static final Logger log = LoggerFactory.getLogger(DistancesReader.class);

	private final UndirectedGraph<Point, Distance> g;

	public DistancesReader(String fileName) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> list = IOUtils.readLines(DistancesReader.class.getResourceAsStream(fileName));
		int numberOfVertices = Integer.valueOf(list.get(0));
		g = new SimpleGraph<Point, Distance>(Distance.class);
		for (String s : list.subList(1, list.size())) {
			String[] split = StringUtils.split(s, " ");
			Point nodeA = new Point(Integer.valueOf(split[0]));
			Point nodeB = new Point(Integer.valueOf(split[1]));
			int distance = Integer.valueOf(split[2]);
			g.addVertex(nodeA);
			g.addVertex(nodeB);
			log.debug("adding edge with cost {} between vertex {} and {}", distance, nodeA, nodeB);
			g.addEdge(nodeA, nodeB, new Distance(distance));
		}
		if(g.vertexSet().size() != numberOfVertices) {
			throw new IOException("added vertices does not match number specified in first line");
		}
	}

	public UndirectedGraph<Point, Distance> getGraph() {
		return g;
	}
}
