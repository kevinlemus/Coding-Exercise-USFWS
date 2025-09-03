package com.usfws;

import java.util.ArrayList;

import com.usfws.dag.Edge;
import com.usfws.dag.Vertex;
import com.usfws.paths.LongestPath;

public class DAGApp {
	public static void main(String[] args) {

		// Create some vertices
		Vertex A = new Vertex(1);
		Vertex B = new Vertex(2);
		Vertex C = new Vertex(3);
		Vertex D = new Vertex(4);

		// Create list with edges
		ArrayList<Edge> edges = new ArrayList<>();

		edges.add(new Edge(A, B));
		edges.add(new Edge(B, C));
		edges.add(new Edge(A, D));

		// Find the longest path starting from A
		int longestPath = LongestPath.findLongestPath(A, edges);

		System.out.println("Longest path from A: " + longestPath);
	}
}