package algs4.dynamicConnectivity;

public class QuickUnion implements UF {

    private final int[] data;
    private final int count;

    public QuickUnion(int N) {
        this.data = new int[N+1];
        for (int i=0; i<=N; i++) {
            data[i] = i;
        }
        this.count = N;
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        data[p] = root(q);
    }

    public boolean find(int p, int q) {
        validate(p);
        validate(q);
        return root(p) == root(q);
    }

    private int root(int p) {
        while(p != data[p]) { p = data[p]; }
        return p;
    }

    private void validate(int p) throws IndexOutOfBoundsException {
        if (p > count || p < 1) { throw new IndexOutOfBoundsException(); }
    }
}
