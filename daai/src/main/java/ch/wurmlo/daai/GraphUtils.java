package ch.wurmlo.daai;

import java.util.List;
import com.google.common.collect.Lists;
import ch.wurmlo.daai.week4.rVertex;

public class GraphUtils {

	public static List<Vertex> convertToVertices(List<Integer> integers) {
		List<Vertex> vertices = Lists.newArrayList();
		for (Integer integer : integers) {
			vertices.add(new Vertex(integer));
		}
		return vertices;
	}


	public static List<rVertex> convertToRevertedSortingVertices(List<Integer> integers) {
		List<rVertex> vertices = Lists.newArrayList();
		for (Integer integer : integers) {
			vertices.add(new rVertex(integer));
		}
		return vertices;
	}
}
