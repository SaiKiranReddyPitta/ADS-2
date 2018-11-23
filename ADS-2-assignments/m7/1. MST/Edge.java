/**
 * Class for edge.
 */
public class Edge implements Comparable<Edge> {
    /**
     * vertex v source.
     */
    private final int v;
    /**
     * vertex w destination.
     */
    private final int w;
    /**
     * weight of edge.
     */
    private final double weight;
    /**
     *constructor.
     * @param      v1  integer
     * @param      w1  integer
     * @param      weight1  The weight
     */
    public Edge(final int v1, final int w1, final double weight1) {
        this.v = v1;
        this.w = w1;
        this.weight = weight1;
    }
    /**
     * Returns the weight of this edge.
     * The Time complexity is 1
     * @return the weight of this edge
     */
    public double weight() {
        return weight;
    }
    /**
     * Returns either endpoint of this edge.
     * The Time complexity is 1
     * @return either endpoint of this edge
     */
    public int either() {
        return v;
    }
    /**
     * The Time complexity is 1
     * Returns the endpoint of this edge that is.
     * different from the given vertex
     * @param  vertex one endpoint of this edge
     * @return the other endpoint of this edge
     * @throws IllegalArgumentException if the vertex is not one of the
     * endpoints of this edge
     */
    public int other(final int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        }  else {
            throw new IllegalArgumentException("Illegal endpoint");
        }


    }
    /**
     * Compares two edges by weight.
     * Time complexity is 1
     * @param  that the other edge
     * @return a negative integer, zero, or positive integer.
     */
    public int compareTo(final Edge that) {
        return Double.compare(this.weight, that.weight);
    }

}
