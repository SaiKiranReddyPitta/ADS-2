/**
 * Class for lazy primitive mst.
 */
public class LazyPrimMST {
    /**
     * double value.
     */
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    /**
     * variable declaration.
     */
    private double weight;
    /**
     * variable declaration.
     */
    private Queue<Edge> mst;
    /**
     * variable declaration.
     */
    private boolean[] marked;
    /**
     * variable declaration.
     */
    private MinPQ<Edge> pq;

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param g the edge-weighted graph
     */
    LazyPrimMST(final EdgeWeightedGraph g) {
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        marked = new boolean[g.vertices()];
        for (int v = 0; v < g.vertices(); v++) {
            if (!marked[v]) {
                prim(g, v);
            }
        }
        // check optimality conditions

    }
    /**
     * {Private Accessor method of prim}.
     * The Time complexity is E log E and space proprotional -> E
     * @param      g     {EdgeWeightedGraph}
     * @param      s     {Vertex}
     */
    private void prim(final EdgeWeightedGraph g, final int s) {
        scan(g, s);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);

            assert marked[v] || marked[w];
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(e);
            weight += e.weight();
            if (!marked[v]) {
                scan(g, v);
            }
            if (!marked[w]) {
                scan(g, w);
            }
        }
    }
    /**
     * {add all edges e incident to v onto pq if the.
     * other endpoint has not yet been scanned}
     * The Time complexity is number of Edges
     * @param      g     {EdgeWeightedGraph}
     * @param      v     {Vertex}
     */
    private void scan(final EdgeWeightedGraph g, final int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }
    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest)
     *  as an iterable of edges
     *  The Time complexity is O(1).
     */
    public Iterable<Edge> edges() {
        return mst;
    }
    /**
     * @return the sum of the edge weights.
     * in a minimum spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }
}
