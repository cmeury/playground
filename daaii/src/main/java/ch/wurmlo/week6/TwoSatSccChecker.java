/**
 * Copyright 2013, netbreeze GmbH
 */
package ch.wurmlo.week6;

import com.google.common.collect.Maps;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Checks the satisfiability of a 2-SAT instance using Kasaraju's algorithm for finding strongly connected components.
 */
public class TwoSatSccChecker {

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(TwoSatSccChecker.class);

    @SuppressWarnings("ConstantConditions")
    public static boolean isSatisfiable(List<Clause> clauses) {

        Map<Integer, rVertex> addedVertices = Maps.newHashMap();
        DirectedGraph graph = new DirectedGraph();

        for (Clause clause : clauses) {
            int first = clause.getFirst();
            int second = clause.getSecond();

            if(first > 0 && second > 0) { // A OR B

                rVertex vertexA = getOrCreateRevVertex(addedVertices, first);
                rVertex vertexAneg = getOrCreateRevVertex(addedVertices, -first);
                rVertex vertexB = getOrCreateRevVertex(addedVertices, second);
                rVertex vertexBneg = getOrCreateRevVertex(addedVertices, -second);

                // B'A  <=> A'B
                graph.connectVertex(vertexBneg, vertexA);
                graph.connectVertex(vertexAneg, vertexB);

            } else if(first > 0 && second < 0) { // A OR !B

                rVertex vertexA = getOrCreateRevVertex(addedVertices, first);
                rVertex vertexAneg = getOrCreateRevVertex(addedVertices, -first);
                rVertex vertexB = getOrCreateRevVertex(addedVertices, -second);
                rVertex vertexBneg = getOrCreateRevVertex(addedVertices, second);

                // BA   <=> A'B'
                graph.connectVertex(vertexB, vertexA);
                graph.connectVertex(vertexAneg, vertexBneg);

            } else if(first < 0 && second > 0) { // !A OR B

                rVertex vertexA = getOrCreateRevVertex(addedVertices, -first);
                rVertex vertexAneg = getOrCreateRevVertex(addedVertices, first);
                rVertex vertexB = getOrCreateRevVertex(addedVertices, second);
                rVertex vertexBneg = getOrCreateRevVertex(addedVertices, -second);

                // AB   <=> B'A'
                graph.connectVertex(vertexA, vertexB);
                graph.connectVertex(vertexBneg, vertexAneg);

            } else { // !A OR !B

                rVertex vertexA = getOrCreateRevVertex(addedVertices, -first);
                rVertex vertexAneg = getOrCreateRevVertex(addedVertices, first);
                rVertex vertexB = getOrCreateRevVertex(addedVertices, -second);
                rVertex vertexBneg = getOrCreateRevVertex(addedVertices, second);

                // AB'  <=> BA'
                graph.connectVertex(vertexA, vertexBneg);
                graph.connectVertex(vertexB, vertexAneg);

            }
        }

        SCC scc = new SCC(graph);
        scc.calculate();
        MultiMap leaders = scc.getLeaders();

        for (Object o : leaders.keySet()){
            rVertex rV = (rVertex) o;
            List<rVertex> vertices = (List<rVertex>) leaders.get(rV);
            for (rVertex vertice : vertices) {
                for (rVertex rVertex : vertices) {
                    if(vertice.getId() == rVertex.getId()) {
                        continue;
                    }
                    if(vertice.getId() == -rVertex.getId()) {
                        // if variable plus its negation are in the same SCC, the instance is unsatisfiable
                        return false;
                    }
                }
            }
        }
        // no unsatisfiability condition found
        return true;
    }

    private static rVertex getOrCreateRevVertex(Map<Integer, rVertex> addedVertices, Integer key) {
        rVertex rVertex = addedVertices.get(key);
        if(rVertex == null) {
            rVertex newRVertex = new rVertex(key);
            addedVertices.put(key, newRVertex);
            return newRVertex;
        } else {
            return rVertex;
        }
    }

}
