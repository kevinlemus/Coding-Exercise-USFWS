package com.usfws.paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.usfws.dag.Edge;
import com.usfws.dag.Vertex;

public class LongestPath {

	public static Map<Vertex, ArrayList<Vertex>> buildGraph(ArrayList<Edge> edges) {

	    // Create the graph
	    Map<Vertex, ArrayList<Vertex>> graph = new HashMap<Vertex, ArrayList<Vertex>>();

	    // Go through each edge one by one
	    for (int i = 0; i < edges.size(); i++) {
	        Edge currentEdge = edges.get(i);

	        // Get the from and to points
	        Vertex fromVertex = currentEdge.from;
	        Vertex toVertex = currentEdge.to;

	        // Add vertex if not already present
	        if (graph.get(fromVertex) == null) {
	            graph.put(fromVertex, new ArrayList<Vertex>());
	        }

	        // Add the corresponding toVertex to the fromVertex list
	        graph.get(fromVertex).add(toVertex);

	        // If the toVertex is not already in the map, add it
	        if (graph.get(toVertex) == null) {
	            graph.put(toVertex, new ArrayList<Vertex>());
	        }
	    }

	    return graph;
	}
	
	
    // Using memoization and DFS to find the longest path from a starting vertex
    public static int findLongestPathFrom(Vertex currentVertex, Map<Vertex, ArrayList<Vertex>> graph, Map<Vertex, Integer> savedLengths) {

        // If we've already calculated the longest path from this vertex, return it
        if (savedLengths.containsKey(currentVertex)) {
            return savedLengths.get(currentVertex);
        }

        int longestPath = 0;

        // Look at each connected vertex
        ArrayList<Vertex> neighbors = graph.get(currentVertex);
        for (int i = 0; i < neighbors.size(); i++) {
            Vertex nextVertex = neighbors.get(i);

            // Recursively find the longest path from this neighbor
            int pathLength = findLongestPathFrom(nextVertex, graph, savedLengths);

            // Keep track of the longest one we find
            if (pathLength > longestPath) {
                longestPath = pathLength;
            }
        }

        // Add 1 to include the current vertex itself
        int totalLength = longestPath + 1;
        savedLengths.put(currentVertex, totalLength);

        return totalLength;
    }

    // Build the graph and find the longest path from the starting vertex
    public static int findLongestPath(Vertex startVertex, ArrayList<Edge> edgeList) {
        Map<Vertex, ArrayList<Vertex>> graph = buildGraph(edgeList);
        Map<Vertex, Integer> savedLengths = new HashMap<Vertex, Integer>();

        int fullLength = findLongestPathFrom(startVertex, graph, savedLengths);

        // Subtract 1 because we don't count the starting vertex
        return fullLength - 1;
    }
}