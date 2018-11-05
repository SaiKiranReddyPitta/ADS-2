import java.util.Scanner;
interface Graph {
    int getV();
    int getE();
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
    boolean hasEdge(int v, int w);
}
class Matrix implements Graph {
    private int vertices;
    private int edges;
    private int[][] matrix;
    Matrix(final int v, final int e) {
        this.vertices = v;
        this.edges = 0;
        matrix = new int[v][v];
    }
    public int getV() {
        return vertices;
    }
    public int getE() {
        return edges;
    }
    public int[][] getMatrix() {
        return matrix;
    }
    public void addEdge(final int v, final int w) {
        if (v != w && !hasEdge(v, w)) {
            matrix[v][w] = 1;
            matrix[w][v] = 1;
            edges++;
        }
    }
    public Iterable<Integer> adj(final int v) {
        return null;
    }
    public boolean hasEdge(final int v, final int w) {
        return matrix[v][w] == 1;
    }
}
class List implements Graph {
    private int vertices;
    private int edges;
    private SeparateChainingHashST<Integer, Bag> table;
    List(final int v, final int e) {
        this.vertices = v;
        this.edges = 0;
        table = new SeparateChainingHashST<>();
    }
    public int getV() {
        return vertices;
    }
    public int getE() {
        return edges;
    }
    public SeparateChainingHashST<Integer, Bag> getTable() {
        return table;
    }
    public void addEdge(final int v, final int w) {
        edges++;
        if (v == w || hasEdge(v, w)) {
            edges--;
        }
        if (table.contains(v)) {
            table.get(v).add(w);

        } else {
            table.put(v, new Bag<Integer>());
            table.get(v).add(w);
            //System.out.println(table.get(v));
        }
        if (table.contains(w)) {
            table.get(w).add(v);
        } else {
            table.put(w, new Bag<Integer>());
            table.get(w).add(v);
            // System.out.println(table.get(v));
        }

    }
    public Iterable<Integer> adj(final int v) {
        return table.keys();
    }
    public boolean hasEdge(final int v, final int w) {
        if (!table.contains(v)) {
            return false;
        }
        Bag<Integer> b = table.get(v);
        for (Integer each : b) {
            if (each == w) {
                return true;
            }
        }
        return false;
    }
}
public final class Solution {
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String adjacency = scan.nextLine();
        int vertices = Integer.parseInt(scan.nextLine());
        int edges = Integer.parseInt(scan.nextLine());
        switch (adjacency) {
        case "List" :
            List list = new List(vertices, edges);
            String[] elems = scan.nextLine().split(",");
            while (scan.hasNext()) {
                String[] edg = scan.nextLine().split(" ");
                list.addEdge(Integer.parseInt(edg[0]),
                             Integer.parseInt(edg[1]));
            }
            System.out.println(list.getV() + " vertices, "
                               + list.getE() + " edges");
            if (list.getV() <= 1 || list.getE() <= 1) {
                System.out.println("No edges");
                return;
            }
            for (int ele = 0; ele < vertices; ele++) {
                System.out.print(elems[ele] + ": ");
                Bag<Integer> b = list.getTable().get(ele);
                for (Integer each : b) {
                    //if (each == w) return true;
                    System.out.print(elems[each] + " ");
                }
                System.out.println();
            }

            break;
        case "Matrix" :
            Matrix matrix = new Matrix(vertices, edges);
            String[] elements = scan.nextLine().split(",");
            while (scan.hasNext()) {
                String[] edge = scan.nextLine().split(" ");
                matrix.addEdge(Integer.parseInt(edge[0]),
                               Integer.parseInt(edge[1]));
            }
            System.out.println(matrix.getV() + " vertices, "
                               + matrix.getE() + " edges");
            if (matrix.getV() <= 1 || matrix.getE() <= 1) {
                System.out.println("No edges");
                return;
            }
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    //int elem = matrix.matrix[i][j] ? 1 : 0;
                    System.out.print(matrix.getMatrix()[i][j]
                                     + " ");
                }
                System.out.println();
            }
            break;
        default:
        }
    }
}
