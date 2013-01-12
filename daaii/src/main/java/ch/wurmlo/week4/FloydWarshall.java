package ch.wurmlo.week4;

import ch.wurmlo.week1.mst.Edge;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Computes the all-pairs shortest-path and determines whether the given graph has negative cycles.
 */
public class FloydWarshall {

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(FloydWarshall.class);

    private long shortestPath;
    private final long[][][] A;
    private final DefaultDirectedGraph<Integer, Edge> graph;

    public FloydWarshall(DefaultDirectedGraph<Integer, Edge> graph) {

        this.graph = graph;

        Set<Integer> vertices = graph.vertexSet();
        int n = vertices.size();
        this.A = new long[n][n][n];

        // base cases
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    A[i][j][0] = 0;
                } else if(graph.containsEdge(i, j)) {
                    A[i][j][0] = graph.getEdge(i, j).getEdgeCost();
                } else {
                    A[i][j][0] = Long.MAX_VALUE;
                }
            }
        }

        shortestPath = Long.MAX_VALUE;

        // dynamic programming loop
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j][k] = Math.min(A[i][j][k-1], A[i][k][k=1] + A[k][j][k-1]);
                    if(A[i][j][k] < shortestPath) {
                        shortestPath = A[i][j][k];
                    }
                }
            }
        }
    }

    public long getShortestPath() {
        return shortestPath;
    }

    /**
     * Does the graph contain any negative cycles?
     * @return {@code true} if the graph contains any negative cycles
     */
    public boolean hasNegativeCycles() {
        Set<Integer> vertices = graph.vertexSet();
        int n = vertices.size();
        for (int i = 0; i < n; i++) {
            if(A[i][i][n] < 0) {
                return true;
            }
        }
        return false;
    }
}
