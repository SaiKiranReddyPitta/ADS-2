/**.
 *Connected component class.
 */
public class ConnectedComponent {
    /**.
     * { var_description }
     */
    private boolean[] marked;
    /**.
     * { var_description }
     */
    private int[] id;
    /**.
     * { var_description }
     */
    private int[] size;
    /**.
     * { var_description }
     */
    private int count;
    /**
     * Computes the connected components of the
     * undirected graph {@code G}.
     *
     * @param g the undirected graph
     */
    public ConnectedComponent(final GraphList g) {
        marked = new boolean[g.vert()];
        id = new int[g.vert()];
        size = new int[g.vert()];
        for (int v = 0; v < g.vert(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    // /**
    //  * Computes the connected components of the
    //   edge-weighted graph {@code G}.
    //  *
    //  * @param G the edge-weighted graph
    //  */
    // public ConnectedComponent(EdgeWeightedGraph G) {
    //     marked = new boolean[G.V()];
    //     id = new int[G.V()];
    //     size = new int[G.V()];
    //     for (int v = 0; v < G.V(); v++) {
    //         if (!marked[v]) {
    //             dfs(G, v);
    //             count++;
    //         }
    //     }
    // }

    /**.
     * time complexity is O(N).
     * method on depth first traversal
     * @param  g the undirected graph
     * @param  v the vertex
     */
    private void dfs(final GraphList g, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }
    // private void dfs(EdgeWeightedGraph G, int v) {
    //     marked[v] = true;
    //     id[v] = count;
    //     size[count]++;
    //     for (Edge e : G.adj(v)) {
    //         int w = e.other(v);
    //         if (!marked[w]) {
    //             dfs(G, w);
    //         }
    //     }
    // }

    /**.
     * time complexity in average case is 1.
     * @param  v the vertex
     * @return the component id of the connected
     * component containing vertex {@code v}
     */

    public int id(final int v) {
        return id[v];
    }

    /**.
     * time complexity in average case is 1.
     * @param  v the vertex
     * @return the number of vertices in the connected
     * component containing vertex {@code v}
     */

    public int size(final int v) {
        return size[id[v]];
    }

    /**
     * time complexity in average case is 1.
     * Returns the number of connected components
     * in the graph {@code G}.
     *
     * @return the number of connected components
     * in the graph {@code G}
     */

    public int count() {
        return count;
    }

    /**
     * time complexity in average case is 1.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return the true or false
     */

    public boolean connected(final int v, final int w) {
        return id(v) == id(w);
    }

    /**
     * time complexity in average case is 1.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return the true or false
     */

    public boolean areConnected(final int v, final int w) {
        return id(v) == id(w);
    }
}
