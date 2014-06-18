package algs4.dynamicConnectivity;

public class WeightedQuickUnionWithPathComp extends WeightedQuickUnion {

    public WeightedQuickUnionWithPathComp(int N) {
        super(N);
    }

    @Override
    protected int root(int p) {
        while(p != data[p].v) {
            data[p].v = data[data[p].v].v;
            p = data[p].v;
        }
        return p;
    }

}
