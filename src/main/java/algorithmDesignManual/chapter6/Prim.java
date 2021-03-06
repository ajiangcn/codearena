package algorithmDesignManual.chapter6;

import static algorithmDesignManual.chapter6.Graph.MAXV;

/**
 * Created by youjiang on 3/23/14.
 */
public class Prim {

    public void prim(Graph g, int start) {
        int i; /* counter */
        EdgeNode p; /* temporary reference */
        boolean[] inTree = new boolean[MAXV+1]; /* is the vertex in the tree yet */
        int[] distance = new int[MAXV+1]; /* cost of adding to the tree */
        int[] parent = new int[MAXV+1]; /* parent node */
        int v; /* current vertex to process */
        int w; /* candidate next vertex */
        int weight; /* edge weight */
        int dist; /* best current distance from start */

        for(i=1; i<=g.nvertices; i++) {
            inTree[i] = false;
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        distance[start] = 0;
        v = start;

        while(inTree[v] == false) {
            int orig = v;
            inTree[v] = true;
            p = g.edges[v];
            while(p != null) {
                w = p.y;
                weight = p.weight;
                if (distance[w] > weight && inTree[w] == false) {
                    distance[w] = weight;
                    parent[w] = v;
                }
                p = p.next;
            }
            v = 1;
            dist = Integer.MAX_VALUE;
            for (i=1; i<=g.nvertices; i++) {
                if(inTree[i] == false && dist > distance[i]) {
                    dist = distance[i];
                    v = i;
                }
            }
        }
    }

}
