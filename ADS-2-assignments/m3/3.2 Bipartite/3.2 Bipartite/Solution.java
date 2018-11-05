/**
 * { item_description }
 */
import java.util.Scanner;
/**
 * { item_description }
 */
final class Solution{
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertex = Integer.parseInt(sc.nextLine());
		Graph graph = new Graph(vertex);
		int edge = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < edge; i++) {
			String[] tokens = sc.nextLine().split(" ");
			int v = Integer.parseInt(tokens[0]);
			int w = Integer.parseInt(tokens[1]);
			graph.addEdge(v, w);
		}
		Bipartite bipartite = new Bipartite(graph);
		if (bipartite.isBipartite()) {
			System.out.println("Graph is bipartite");
		} else {
			System.out.println("Graph is not a bipartite");
		}
	}
}
