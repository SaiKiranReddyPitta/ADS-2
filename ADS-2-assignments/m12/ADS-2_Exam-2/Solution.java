import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {

        // Self loops are not allowed...

        // Parallel Edges are allowed...

        // Take the Graph input here...

        Scanner s = new Scanner(System.in);

        int vertices = Integer.parseInt(s.nextLine());

        int edges = Integer.parseInt(s.nextLine());

        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(vertices);

        int k = edges;

        while(k > 0) {

            String[] edgeString = s.nextLine().split(" ");

            Edge edge1 = new Edge(Integer.parseInt(edgeString[0]), 

                Integer.parseInt(edgeString[1]), Integer.parseInt(edgeString[2]));

            edgeWeightedGraph.addEdge(edge1);

            k--;

        }


        String caseToGo = s.nextLine();

        switch (caseToGo) {

        case "Graph":

            //Print the Graph Object.

            System.out.println(edgeWeightedGraph);

            break;


        case "DirectedPaths":

            // Handle the case of DirectedPaths, where two integers are given.

            // First is the source and second is the destination.

            // If the path exists print the distance between them.

            // Other wise print "No Path Found."

            String[] directedPaths = s.nextLine().split(" ");

            int ss = Integer.parseInt(directedPaths[0]);

            int dp = Integer.parseInt(directedPaths[1]);

            DijkstraUndirectedSP sp = new DijkstraUndirectedSP(edgeWeightedGraph, ss);

            if (sp.hasPathTo(dp)) {

                System.out.println(sp.distTo(dp));

            } else {

                System.out.println("No Path Found.");

            }

            break;


        case "ViaPaths":

            // Handle the case of ViaPaths, where three integers are given.

            // First is the source and second is the via
            // is the one where path should pass throuh.

            // third is the destination.

            // If the path exists print the distance between them.

            // Other wise print "No Path Found."
            
            System.out.println("No Path Found.");

            break;

        default:

            break;

        }

    }

}
