import java.util.Scanner;

public final class Solution {

    private Solution() {
        //unused
    }
    /**.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = Integer.parseInt(sc.nextLine());
        int edge = Integer.parseInt(sc.nextLine());
        Digraph digraph = new Digraph(vertex);
        for(int i=0;i<edge;i++) {
            String[] tokens = sc.nextLine().split(" ");
            digraph.addEdge(Integer.parseInt(tokens[0]),
                         Integer.parseInt(tokens[1]));
        }
        DirectedCycle directed = new DirectedCycle(digraph);
        if (directed.hasCycle()) {
            System.out.println("Cycle exists.");
        }
        else {
            System.out.println("Cycle doesn't exists.");

        }

    }
}
