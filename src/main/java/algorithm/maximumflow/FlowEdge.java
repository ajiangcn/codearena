package algorithm.maximumflow;

public class FlowEdge {

    private final int v;  // from
    private final int w;  // to
    private final double capacity; //capacity
    private double flow; // flow

    /**
     * Create a flow edge v->w
     * @param v
     * @param w
     * @param capacity
     */
    public FlowEdge(int v, int w, double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    /**
     * @return vertex this edge points from
     */
    public int from() {
        return v;
    }

    /**
     * @return vertex this edge points to
     */
    public int to() {
        return w;
    }

    /**
     * @param vertex
     * @return other endpoint
     */
    public int other(int vertex) {
        if(vertex == v) {
            return w;
        } else if(vertex ==w){
            return v;
        } else {
            throw new RuntimeException("Illegal endpoint.");
        }
    }

    /**
     * @return capacity of this edge
     */
    public double capacity() {
        return capacity;
    }

    /**
     * @return flow in this edge
     */
    public double flow() {
        return flow;
    }

    /**
     * @param vertex
     * @return residual capacity toward v
     */
    public double residualCapacityTo(int vertex) {
        if(vertex == v) {
            return flow;
        } else if (vertex == w) {
            return capacity - flow;
        } else {
            throw new RuntimeException("Illegal endpoint.");
        }
    }

    /**
     * add delta flow toward v
     * @param vertex
     * @param delta
     */
    public void addResidualFlowTo(int vertex, double delta) {
        if(vertex == v) {
            flow -= delta;
        } else if(vertex == w) {
            flow += delta;
        } else {
            throw new RuntimeException("Illegal endpoint.");
        }
    }

    /**
     * @return string representation of the edge
     */
    public String toString() {
        return String.format("FlowEdge %i to %i, capacity: %d, flow: %d", v, w, capacity, flow);
    }
}
