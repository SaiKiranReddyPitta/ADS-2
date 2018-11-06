/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
class Solution {
    /**
     * { item_description }
     */
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);
        int vert = Integer.parseInt(in.nextLine());
        int testcases = Integer.parseInt(in.nextLine());
        EdgeWeightedGraph wtEdge = new EdgeWeightedGraph(vert);
        for (int i = 0; i < testcases; i++) {
            String[] inp = in.nextLine().split(" ");
            wtEdge.addEdge(new Edge(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Double.valueOf(inp[2])));
        }
        PrimMST p =  new PrimMST(wtEdge);
        // System.out.println(p.edges());
        System.out.format("%.5f",p.weight());
    }
}
