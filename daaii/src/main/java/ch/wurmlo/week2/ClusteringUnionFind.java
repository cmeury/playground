package ch.wurmlo.week2;

import java.util.*;
import org.jgrapht.alg.util.UnionFind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClusteringUnionFind<T> extends UnionFind<T> {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(ClusteringUnionFind.class);

	/**
	 * Creates a UnionFind instance with all of the elements of elements in seperate sets.
	 */
	public ClusteringUnionFind(Set elements) {
		super(elements);
	}

	public int numberOfClusters() {
		return getClusters().size();

	}

	/**
	 * Get the leader points for all existing clusters.
	 * @return set of unique leaders that represent the current clusters
	 */
	public Set<T> getClusters() {
		Set<T> elements = super.getParentMap().keySet();
		Set<T> parents = new HashSet<T>();
		for (T element : elements) {
			parents.add(find(element));
		}
		return parents;
	}

	/**
	 * Get all nodes that belong to the given cluster.
	 * @param t cluster to use as key
	 * @return list of (possibly duplicate and more) nodes that belong to the given leader node
	 */
	public List<T> getNodesForCluster(T t) {
		Map<T, T> parentMap = super.getParentMap();
		List<T> nodes = new ArrayList<T>();
		for (T key : parentMap.keySet()) {
			T value = parentMap.get(key);
			if(value.equals(t)) {
				nodes.add(key);
			}
		}
		return nodes;
	}
}
