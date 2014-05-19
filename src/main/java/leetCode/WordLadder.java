package leetCode;

import java.util.*;

public class WordLadder {

    public static class Node {
        String word = "";
        List<Node> nexts = new LinkedList<Node>();

        int cost = 0;
        boolean visited = false;

        public Node(String w) {
            this.word = w;
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        Map<String, Node> nodes = new HashMap<String, Node>();
        dict.add(start);
        dict.add(end);
        for (String str : dict) {
            Node n = nodes.get(str);
            if (n == null) {
                Node newN = new Node(str);
                nodes.put(str, newN);
                newN.nexts = getAdjacents(str, dict, nodes);
            } else {
                n.nexts = getAdjacents(str, dict, nodes);
            }
        }

        Node startN = nodes.get(start);

        // find the shortest path from start to end
        Queue<Node> queue = new LinkedList<Node>();
        startN.cost = 1;
        startN.visited = true;
        queue.add(startN);

        int result = 0;
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            if (n.word.equals(end)) {
                result = n.cost;
                return n.cost;
            } else {
                for (Node node : n.nexts) {
                    if (!node.visited) {
                        node.cost = n.cost + 1;
                        node.visited = true;
                        queue.add(node);
                    }
                }
            }
        }
        return result;
    }

    protected List<Node> getAdjacents(String word, Set<String> dict, Map<String, Node> nodes) {
        List<Node> result = new LinkedList<Node>();

        List<String> words = getWordsWithOneCharacterChange(word, dict);
        for (String w : words) {
            Node n = nodes.get(w);
            if (n != null) {
                result.add(n);
            } else {
                Node newNode = new Node(w);
                nodes.put(w, newNode);
                result.add(newNode);
            }
        }

        return result;
    }

    protected List<String> getWordsWithOneCharacterChange(String word, Set<String> dict) {
        List<String> result = new LinkedList<String>();
        int length = word.length();
        for (int i=0; i<length; i++) {
            for(char c='a'; c<='z'; c+=1) {
                StringBuilder newStr = new StringBuilder(word);
                newStr.setCharAt(i, c);
                String str = newStr.toString();
                if (dict.contains(str) && !str.equals(word)) {
                    result.add(str);
                }
            }
        }
        return result;
    }
}
