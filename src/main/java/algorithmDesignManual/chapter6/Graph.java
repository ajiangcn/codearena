package algorithmDesignManual.chapter6;

/**
 * Created by youjiang on 3/22/14.
 */
public class Graph {
    public static int MAXV = 1000;  /* max number of vertices */

    EdgeNode[] edges; /* adjacency info */
    int[] degree; /* outdegree of each vertex */
    int nvertices; /* number of vertices in graph */
    int nedges; /* number of edges in graph */
    int directed; /* is the graph directed */

}
