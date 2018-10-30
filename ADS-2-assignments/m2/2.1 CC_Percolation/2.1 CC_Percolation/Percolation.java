class Percolation {
    private boolean[][] grid;
    private int size;
    private int count = 0;
    private GraphList ghl;
    Percolation(final int sze) {
        this.size = sze;
        ghl = new GraphList((sze * sze) + 2);
        grid = new boolean[size][size];
    }
    public int getIndex(final int i, final int j) {
        return (i * size) + j;
    }
    public void open(final int r, final int c) {

            grid[r][c] = true;
            count += 1;
        if (r == 0) {
            ghl.addEdge(size * size, getIndex(r, c));
        }
        if (r == size - 1) {
            ghl.addEdge((size * size) + 1, getIndex(r, c));
        }
        if (c < size - 1 && grid[r][c + 1]) { //bottom
            ghl.addEdge(getIndex(r, c), getIndex(r, c + 1));
        }
        if (c > 0 && grid[r][c - 1]) { // left
            ghl.addEdge(getIndex(r, c), getIndex(r, c - 1));
        }
        if (r < size - 1 && grid[r + 1][c]) { //right
            ghl.addEdge(getIndex(r, c), getIndex(r + 1, c));
        }
        if (r > 0 && grid[r - 1][c]) { // top
            ghl.addEdge(getIndex(r, c), getIndex(r - 1, c));
        }
    }
    public boolean percolates() {
        ConnectedComponent concom = new ConnectedComponent(ghl);
        return concom.connected(size * size, (size * size) + 1);
    }
}