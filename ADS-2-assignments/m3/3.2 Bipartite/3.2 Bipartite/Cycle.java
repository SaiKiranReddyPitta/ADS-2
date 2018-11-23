/**hasacycle.**/
class DirectedCycle {
    /**
     * variable.
     */
    private boolean[] marked;
    /**
     * variable.
     */
    private int[] edgeTo;
    /**
     * variable.
     */
    private boolean[] onStack;
    /**
     * variable.
     */
    private Stack<Integer> cycle;
    /**
     * variable.
     */
    private boolean bipartite = false;

    /**
     * @param graph value
     */
    DirectedCycle(final DiGraph graph) {
        marked  = new boolean[graph.vertex()];
        onStack = new boolean[graph.vertex()];
        edgeTo  = new int[graph.vertex()];
        for (int v = 0; v < graph.vertex(); v++) {
     if (!marked[v] && cycle == null) {
        dfs(graph, v);
         }
        }
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is E + V
     * @param graph value
     * @param v value
     */
    private void dfs(final DiGraph graph, final int v) {
        bipartite = !bipartite;
        onStack[v] = true;
        marked[v] = true;

        for (int w : graph.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
             return;
        } else if (!marked[w]) { // found new vertex, so recur
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) { // trace back directed cycle
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                //assert check();
            }
        }
        onStack[v] = false;
    }


    /**
     * @return value
     * Time complexity is O(1)
     */
    public boolean isbipartite() {
        return bipartite;
    }

    /**
     * @return value
     * Time complexity is O(1)
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}
