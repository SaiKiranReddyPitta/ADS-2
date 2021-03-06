/**.
 *graph Interface.
 */
interface Graph {
    /**.
     * Method
     *
     * @return     { description_of_the_return_value }
     */

    int vert();
    /**.
     * Method
     *
     * @return     { description_of_the_return_value }
     */

    int edge();
    /**.
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */

    void addEdge(int v, int w);
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    Iterable<Integer> adj(int v);
    /**.
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */

    boolean hasEdge(int v, int w);
}
/**.
 * List of graphs.
 */
/**graph implementation.**/
class GraphList implements Graph {
    /**.
     * { var_description }
     */

    private int ver;
    /**.
     * { var_description }
     */

    private int edg;
    /**.
     * { var_description }
     */

    private Bag<Integer>[] adj;
    /**.
     * { var_description }
     */

    private String[] vertexes;
    /**.
     * { var_description }
     */

    private int size = 0;
    /**
     * Initializes an empty graph with V vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  vt number of vertices
     */

    GraphList(final int vt) {
        this.ver = vt;
        this.edg = 0;
        vertexes = new String[ver];
        size = 0;
        adj = (Bag<Integer>[]) new Bag[ver];
        for (int v = 0; v < ver; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * The Time complexity is O(1)
     * Returns the number of vertices in this graph.
     * @return the number of vertices in this graph
     */

    public int vert() {
        return ver;
    }

    /**
     * The Time complexity is O(1)
     * Returns the number of edges in this graph.
     * @return the number of edges in this graph
     */

    public int edge() {
        return edg;
    }

    /**.
     * The Time complexity is O(1)
     * Adds a vertex.
     * @param      v     { parameter_description }
     */

    public void addVertex(final String v) {
        vertexes[size] = v;
        size++;
    }

    /**.
     * The Time complexity is O(1)
     * Determines if it has edge.
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */

    public boolean hasEdge(final int v, final int w) {
        for (int i : adj[w]) {
            if (i == w) {
                return true;
            }
        }
        return false;
    }

    /**
     * The Time complexity is O(1)
     * Adds the undirected edge v-w to this graph.
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     */

    public void addEdge(final int v, final int w) {
        if (v == w) {
            System.out.println(ver + " vertices, " + edg + " edges");
            System.out.println("No edges");
            return;
        }
        if (!hasEdge(v, w)) {
            edg++;
        }
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     * The Time complexity is 1
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}.
     */

    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */

    public int degree(final int v) {
        return adj[v].size();
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * The Time complexity is O(N ^ 2)
     * @return value
     */
    public String toString() {
        String s = "";
        s += ver + " vertices, " + edg + " edges" + '\n';
        for (int v = 0; v < ver; v++) {
            s += vertexes[v] + ": ";
            for (int w : adj[v]) {
                s += vertexes[w] + " ";
            }
            s += '\n';
        }
        return s;
    }
}
