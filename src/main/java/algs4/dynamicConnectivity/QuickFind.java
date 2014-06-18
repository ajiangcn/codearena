package algs4.dynamicConnectivity;

public class QuickFind implements UF {

    private final int[] data;
    private final int count;

    public QuickFind(int N) {
        this.data = new int[N+1];
        this.count = N;
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pId = data[p];
        for (int i=1; i<=count; i++) {
            if (data[i] == pId) { data[i] = data[q]; }
        }
        //TODO
    }

    public boolean find(int p, int q) {
        validate(p);
        validate(q);
        return data[p] == data[q];
    }

    private void validate(int p) throws IndexOutOfBoundsException {
        if (p > count || p < 1) { throw new IndexOutOfBoundsException(); }
    }
}
