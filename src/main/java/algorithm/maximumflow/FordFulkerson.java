package algorithm.maximumflow;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {

    private boolean[] marked; // true if s->w path in residual network
    private FlowEdge[] edgeTo; // last edge on s-w path
    private double value;      // value of flow

    public FordFulkerson(FlowNetwork G, int s, int t) {
        value = 0d;
        while(hasAugmentingPath(G, s, t)) {
            double bottle = Double.POSITIVE_INFINITY;
            for(int v = t; v != s; v=edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }
            for(int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }

            value += bottle;
        }

    }

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        marked[s] = true;
        while(!q.isEmpty()) {
            int v = q.remove();
            for(FlowEdge e : G.adj(v)) {
                int w = e.other(v);
                if(e.residualCapacityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = e;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
        return marked[t];
    }

    public double value() {
        return value;
    }

    /**
     * @param v
     * @return is v reachable from s in residual network
     */
    public boolean inCut(int v) {
        return marked[v];
    }
}
