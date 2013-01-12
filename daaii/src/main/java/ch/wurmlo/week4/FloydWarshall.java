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
    private final long[][] A;
    private final DefaultDirectedGraph<Integer, Edge> graph;

    private static final long MAX = 999999999;

    public FloydWarshall(DefaultDirectedGraph<Integer, Edge> graph) {

        this.graph = graph;

        Set<Integer> vertices = graph.vertexSet();
        int n = vertices.size();
        this.A = new long[n][n];

        // base cases
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    A[i][j] = 0;
                } else if(graph.containsEdge(i+1, j+1)) {
                    A[i][j] = graph.getEdge(i+1, j+1).getEdgeCost();
                } else {
                    A[i][j] = MAX;
                }
            }
        }

        // dynamic programming loop
        shortestPath = MAX;
        for(int k = 1; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long case1 = A[i][j];
                    long case2 = A[i][k] + A[k][j];
                    long newVal = Math.min(case1, case2);
                    A[i][j] = newVal;
                    if(newVal < shortestPath) {
                        shortestPath = newVal;
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
            if(A[i][i] < 0) {
                return true;
            }
        }
        return false;
    }
}
