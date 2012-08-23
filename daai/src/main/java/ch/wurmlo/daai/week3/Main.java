package ch.wurmlo.daai.week3;

import ch.wurmlo.daai.Vertex;

public class Main {

	public static void main(String[] args) {
		String fileName = "kargerAdj.txt";
		AdjacencyFileReader reader = new AdjacencyFileReader();
		Graph graph = reader.readAdjacencyFile(fileName);


		int minCut = Integer.MAX_VALUE;
		for(int i = 0; i < 50000; i++) {
			int currentMinCut = getMinCut(graph.clone());
			if(currentMinCut < minCut) {
				minCut = currentMinCut;
			}
		}
		System.out.println(minCut);
	}

	private static int getMinCut(Graph graph) {
		while(graph.currentVerticesCount() > 2) {
			Vertex rndVertex = graph.getRandomVertex();
			Vertex rndConnectedVertex = graph.getRandomConnectedVertex(rndVertex);
			graph.fuse(rndVertex, rndConnectedVertex);
		}
		return graph.getConnectedVertices(graph.getRandomVertex()).size();
	}

}
