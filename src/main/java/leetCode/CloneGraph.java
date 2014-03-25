package leetCode;

import java.util.*;

/**
 * Created by youjiang on 3/20/14.
 */
public class CloneGraph {

    public static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {label = x; neighbors = new ArrayList<UndirectedGraphNode>();}
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        // set all the node to be undiscovered
        Set<UndirectedGraphNode> discoveredNode = new HashSet<UndirectedGraphNode>();
        discoveredNode.add(node);

        // create an empty queue and
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);

        // data structure related to the cloning
        Map<Integer, UndirectedGraphNode> copiedNode = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode rootCopy = new UndirectedGraphNode(node.label);
        copiedNode.put(rootCopy.label, rootCopy);

        while (queue.size() > 0) {
            // visit the node
            UndirectedGraphNode visitingNode = queue.remove();

            // copy the node itself
            UndirectedGraphNode copy = copiedNode.get(visitingNode.label);
            if (copy == null) {
                copy = new UndirectedGraphNode(visitingNode.label);
                copiedNode.put(copy.label, copy);
            }
            //copy the neighbor
            for (UndirectedGraphNode neighbor : visitingNode.neighbors) {
                if(!copiedNode.containsKey(neighbor.label)) {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    copiedNode.put(neighborCopy.label, neighborCopy);
                    copy.neighbors.add(neighborCopy);
                } else {
                    copy.neighbors.add(copiedNode.get(neighbor.label));
                }
            }

            for (UndirectedGraphNode neighbor : visitingNode.neighbors) {
                // node is discovered but not yet been visited yet
                if(!discoveredNode.contains(neighbor)) {
                    queue.add(neighbor);
                    discoveredNode.add(neighbor);
                }
            }
        }

        return rootCopy;
    }
}
