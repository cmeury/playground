package ch.wurmlo.week4;

import ch.wurmlo.week1.mst.Edge;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class GraphFileReader {

	private static final Logger log = LoggerFactory.getLogger(GraphFileReader.class);

	@SuppressWarnings("unchecked")
    public static DefaultDirectedGraph<Integer, Edge> read(String fileName) throws GraphFileException {

        List<String> list;

        try {
            list = IOUtils.readLines(GraphFileReader.class.getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new GraphFileException(e.getMessage(), fileName);
        }

        String firstLine = list.get(0);
        String[] firstLineSplit = StringUtils.split(firstLine, " ");
        int numberOfVertices = Integer.valueOf(firstLineSplit[0]);
        int numberOfEdges = Integer.valueOf(firstLineSplit[1]);

        DefaultDirectedGraph<Integer, Edge> g = new DefaultDirectedGraph<Integer, Edge>(Edge.class);
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
            log.error("mismatch: edges specified in header ({}) and actual amount ({})", numberOfEdges, g.edgeSet().size());
            throw new GraphFileException("added edges does not match number specified in first line", fileName);
        }
        if(g.vertexSet().size() != numberOfVertices) {
            log.error("mismatch: vertices specified in header ({}) and actual amount ({})", numberOfVertices, g.vertexSet().size());
            throw new GraphFileException("added vertices does not match number specified in first line", fileName);
        }

		return g;
	}
}
