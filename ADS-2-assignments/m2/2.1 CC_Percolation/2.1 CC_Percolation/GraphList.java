interface Graph {
    int vert();
    int edge();
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
    boolean hasEdge(int v, int w);
}
class GraphList implements Graph {
    private int ver;
    private int edg;
    private Bag<Integer>[] adj;
    private String[] vertexes;
    private int size = 0;
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
    public int vert() {
        return ver;
    }

    public int edge() {
        return edg;
    }
    public void addVertex(final String v) {
        vertexes[size] = v;
        size++;
    }
    public boolean hasEdge(final int v, final int w) {
        for (int i : adj[w]) {
            if (i == w) {
                return true;
            }
        }
        return false;
    }
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
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }

    public int degree(final int v) {
        return adj[v].size();
    }

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