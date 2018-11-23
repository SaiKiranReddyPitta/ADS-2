/** has Cycle **/
public class DirectedCycle {
    /**
     * variable.
     */
    private boolean[] marked;  
    /**
     * variable.
     */
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    /**
     * variable.
     */
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    /**
     * variable.
     */
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)
    /**
     * variable.
     */
    /**
     * @param graph value
     */
    public DirectedCycle(Digraph g) {
        marked  = new boolean[g.vert()];
        onStack = new boolean[g.vert()];
        edgeTo  = new int[g.vert()];
        for (int v = 0; v < g.vert(); v++)
            if (!marked[v] && cycle == null) dfs(g, v);
    }

    // check that algorithm computes
    //either the topological order or finds a directed cycle
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is E + V
     * @param graph value
     * @param v value
     */
    private void dfs(Digraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) return;

            // found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                // assert check();
            }
        }
        onStack[v] = false;
    }
    /**
     * @return value
     * The Time complexity is O(1)
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * @return value
     * Time complexity is O(1)
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }

}