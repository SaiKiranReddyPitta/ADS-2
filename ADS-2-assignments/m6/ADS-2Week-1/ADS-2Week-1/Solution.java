import java.util.Scanner;

import java.util.*;

class PageRank {

	Digraph dg;

	int inDegree;

	int outDegree;

	HashMap<Integer, ArrayList<Integer>> incomingV;

	PageRank (Digraph digraph, Integer vertex) {

		this.outDegree = digraph.outdegree(vertex);

		this.inDegree = digraph.indegree(vertex);

		this.dg = digraph;

		incomingV = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < digraph.V(); i++) {

			for (Integer j : digraph.adj(i)) {

				if (incomingV.containsKey(j)) {

					ArrayList<Integer> list = incomingV.get(j);

					list.add(j);

					incomingV.put(j, list);

				} else {

					ArrayList<Integer> list = new ArrayList<Integer>();

					list.add(i);

					incomingV.put(j, list);

				}

			}

		}

		for (Integer l : incomingV.keySet()) {

			System.out.println(l +  " - " +incomingV.get(l));

		}

	}

}

public class Solution {

	public static void main(String[] args) {

		// read the first line of the input to get the number of vertices


		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph


		// Create page rank object and pass the graph object to the constructor

		// print the page rank object

		// This part is only for the final test case

		// File path to the web content

		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor


		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

		Scanner s = new Scanner(System.in);

		int vertices = Integer.parseInt(s.nextLine());

		Digraph digraph = new Digraph(vertices);

		int verticesCopy = vertices;

		while (verticesCopy > 0 ) {

			String[] vertex = s.nextLine().split(" ");

			int v = Integer.parseInt(vertex[0]);

			for (int w = 1; w < vertex.length; w++) {

				digraph.addEdge(v, Integer.parseInt(vertex[w]));

			}

			verticesCopy--;

		}

		ArrayList<PageRank> prList = new ArrayList<>();

		System.out.println(digraph.V() + "vertices, " + digraph.E() + "edges ");

		for (int i = 0; i < vertices; i++) {

			System.out.print(i + ": ");

			PageRank pr = new PageRank(digraph, i);

			prList.add(pr);

			for (Integer j : digraph.adj(i)) {

				System.out.print(j + " ");

			}

			System.out.println();

		}

	}

}
