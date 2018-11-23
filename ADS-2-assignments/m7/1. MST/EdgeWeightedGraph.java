/**
 * Class for edge weighted graph.
 */
public class EdgeWeightedGraph {
    /**
     * variable vertex.
     */
    private int vert;
    /**
     * variable edge.
     */
    private int edges;
    /**
     * bag of adjacent vertices list.
     */
    private Bag<Edge>[] adj;
    /**
     * Constructs the object.
     *
     * @param  v1 integer vertex.
     */
    public EdgeWeightedGraph(final int v1) {
        this.vert = v1;
        this.edges = 0;
        adj = (Bag<Edge>[]) new Bag[v1];
        for (int i = 0; i < v1; i++) {
            adj[i] = new Bag<Edge>();
        }
    }
    /**
     * Returns the number of vertices in this edge-weighted graph.
     * The Time complexity is 1
     * @return the number of vertices in this edge-weighted graph
     */
    public int vertices() {
        return this.vert;
    }
    /**
     * Returns the number of edges in this edge-weighted graph.
     * The Time complexity is 1
     * @return the number of edges in this edge-weighted graph
     */
    public int edges() {
        return this.edges;
    }
    /**
     * Adds the undirected edge {@code e} to this edge-weighted graph.
     * The Time complexity is 1
     * @param  e the edge
     */
    public void addEdge(final Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        edges++;
    }
    /**
     * Returns the edges incident on vertex {@code v}.
     * The Time complexity is 1
     * @param  v the vertex
     * @return the edges incident on vertex {@code v}
     */
    public Iterable<Edge> adj(final int v) {

        return adj[v];
    }
    /**
     * Returns the degree of vertex {@code v}.
     * The Time complexity is 1
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     */
    public int degree(final int v) {

        return adj[v].size();
    }
    /**
     * Returns all edges in this edge-weighted graph.
     * The Time complexity is 1
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edge() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < vert; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                } else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                     list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }

}
