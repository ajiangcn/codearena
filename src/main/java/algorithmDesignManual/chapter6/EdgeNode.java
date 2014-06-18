package algorithmDesignManual.chapter6;

/**
 * Created by youjiang on 3/22/14.
 */
public class EdgeNode {

    int y;          /* adjacency info */
    int weight;     /* edge weight, if any */
    EdgeNode next;      /* next edge in list */

    EdgeNode(int a, int w, EdgeNode ne) {y=a; weight=w; next=ne;}
}
