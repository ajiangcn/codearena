package algorithm.maximumflow;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import java.util.Collection;

public class FlowNetwork {

    private final int V;
    private Bag<FlowEdge>[] adj;

    /**
     * Create an empty flow network with V vertices
     * @param V
     */
    public FlowNetwork(int V) {
        this.V = V;
        adj = (Bag<FlowEdge>[])new Bag[V];
        for(int v=0; v<V; v++) {
            adj[v] = new HashBag<FlowEdge>();
        }
    }

    /**
     * add flow edge to this flow network
     * @param e
     */
    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }

    /**
     * forward and backward edge incident to v;
     * @param v
     * @return
     */
    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    /**
     * all edges in this flow network
     * @return
     */
    public Iterable<FlowEdge> edges() {
        Bag<FlowEdge> result = new HashBag<FlowEdge>();
        for(int v=0; v<V; v++) {
            result.addAll(adj[v]);
        }
        return result;
    }

    /**
     * @return number of vertices
     */
    public int V() {
        return V;
    }

    /**
     * @return number of edges
     */
    public int E() {
        return ((Collection<FlowEdge>)edges()).size();
    }

    /**
     * @return string representation of the flow network
     */
    public String toString() {
        throw new UnsupportedOperationException("flow network tostring");
    }
}
