package algs4.dynamicConnectivity;

public class WeightedQuickUnion implements UF {

    protected final DataInfo[] data;
    protected final int count;

    protected static class DataInfo {
        public int v;
        public int size;

        public DataInfo(int v) {
            this.v = v;
        }
    }

    public WeightedQuickUnion(int N) {
        this.data = new DataInfo[N+1];
        for(int i=0; i<=N; i++) {
            data[i] = new DataInfo(i);
        }
        this.count = N;
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        DataInfo pRoot = data[p];
        DataInfo qRoot = data[q];
        if (pRoot.size < qRoot.size) {
            pRoot.v = qRoot.v;
        } else {
            qRoot.v = pRoot.v;
        }
    }

    public boolean find(int p, int q) {
        validate(p);
        validate(q);
        return root(p) == root(q);
    }

    protected int root(int p) {
        while(p != data[p].v) { p = data[p].v; }
        return p;
    }

    private void validate(int p) throws IndexOutOfBoundsException {
        if (p > count || p < 1) { throw new IndexOutOfBoundsException(); }
    }
}
