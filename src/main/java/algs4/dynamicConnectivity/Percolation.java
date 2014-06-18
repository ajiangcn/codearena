package algs4.dynamicConnectivity;

public class Percolation {

    private static int CLOSE = 0;
    private static int OPEN = 1;

    /**
     * site value of 0 indicate the site is close
     * site value of 1 indicate the site is open
     */
    private int[][] sites;
    private UF uf;
    private int N;
    private int virtualTopIdx;
    private int virtualButtomIdx;

    /**
     * create N-by-N grid, with all sites blocked
     */
    public Percolation(int N) {
        this.sites = new int[N+1][N+1];
        this.uf = new QuickFind((N+1)*(N+1) + 1);
        this.N = N;
        this.virtualButtomIdx = 0;
        this.virtualButtomIdx = (N+1) * (N+1) + 1;
    }

    /**
     * open site (row i, column j) if it is not already
     */
    public void open(int i, int j) {
        sites[i][j] = OPEN;
        if (isOpen(i, j-1)) { uf.union(getIndex(i,j), getIndex(i, j-1)); }
        if (isOpen(i-1, j)) { uf.union(getIndex(i,j), getIndex(i-1, j)); }
        if (isOpen(i, j+1)) { uf.union(getIndex(i,j), getIndex(i, j+1)); }
        if (isOpen(i+1, j)) { uf.union(getIndex(i,j), getIndex(i+1, j)); }
    }

    /**
     * is site (row i, column j) open?
     */
    public boolean isOpen(int i, int j) {
        if (i>N || i<1 || j> N || j<1) { return false; }
        return sites[i][j] == OPEN;
    }

    /**
     * is site (row i, row j) full?
     */
    public boolean isFull(int i, int j) {
        //TODO
        return false;
    }

    /**
     * does the system percolate?
     */
    public boolean percolates() {
        //TODO
        return false;
    }

    private int getIndex(int i, int j) {
        return i * (N+1) + j + 1;
    }
}
