package leetCode;

import java.util.*;

public class WordLadder {

    public static class Node {
        String word;
        List<Node> nexts = new LinkedList<Node>();

        int cost = 0;
        int visited = -1; // -1 undiscovered, 0 discovered, 1 processed
        ArrayList<ArrayList<String>> path = new ArrayList<ArrayList<String>>();

        public Node(String w) {
            this.word = w;
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }
    }

    protected Node buildGraph(String start, String end, Set<String> dict) {
        Map<String, Node> nodes = new HashMap<String, Node>();
        dict.add(start);
        dict.add(end);

        List<String> dictArray = new ArrayList<String>();
        dictArray.addAll(dict);

        for (int i=0; i<dictArray.size(); i++) {
            String w1 = dictArray.get(i);
            Node n1 = nodes.get(w1);
            if (n1 == null) {
                n1 = new Node(w1);
                nodes.put(w1 ,n1);
            }
            for (int j=0; j<w1.length(); j++) {
                StringBuilder sb = new StringBuilder(w1);
                for (char c = 'a'; c<='z'; c+=1) {
                    sb.setCharAt(j, c);
                    String ns = sb.toString();
                    if (dict.contains(ns) && isOneCharacterDiff(w1, ns)) {
                        Node n2 = nodes.get(ns);
                        if (n2 == null) {
                            n2 = new Node(ns);
                            nodes.put(ns, n2);
                        }
                        n1.nexts.add(n2);
                    }
                }
            }
            /*
            for (int j=i+1; j<dictArray.size(); j++) {
                String w2 = dictArray.get(j);
                if (isOneCharacterDiff(w1, w2)) {
                    Node n2 = nodes.get(w2);
                    if (n2 == null) {
                        n2 = new Node(w2);
                        nodes.put(w2, n2);
                    }
                    n1.nexts.add(n2);
                    n2.nexts.add(n1);
                }
            }*/
        }
        /*
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
        */

        Node startN = nodes.get(start);
        return startN;
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        Node startN = buildGraph(start, end, dict);
        // find the shortest path from start to end
        Queue<Node> queue = new LinkedList<Node>();
        startN.cost = 1;
        startN.visited = 0;
        ArrayList<ArrayList<String>> path = new ArrayList<ArrayList<String>>();
        ArrayList<String> p1 = new ArrayList<String>();
        p1.add(startN.word);
        path.add(p1);
        startN.path = path;
        queue.add(startN);

        int minLengh = 0;
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            if (n.word.equals(end)) {
                if (minLengh == 0 || n.cost == minLengh) {
                    minLengh = n.cost;
                    for (ArrayList<String> p : n.path) {
                        result.add(p);
                    }
                }
                return result;
            } else {
                for (Node node : n.nexts) {
                    if (node.visited == -1 || (node.visited == 0 && node.cost == n.cost +1)) {
                        node.cost = n.cost + 1;
                        for (ArrayList<String> prePath : n.path) {
                            ArrayList<String> p = new ArrayList(prePath);
                            p.add(node.word);
                            node.path.add(p);
                        }
                        if (node.visited == -1) {
                            queue.add(node);
                        }
                        node.visited = 0;
                    }
                }
            }
            n.visited = 1;
        }

        return result;
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        Node startN = buildGraph(start, end, dict);
        // find the shortest path from start to end
        Queue<Node> queue = new LinkedList<Node>();
        startN.cost = 1;
        startN.visited = 0;
        queue.add(startN);

        int result = 0;
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            if (n.word.equals(end)) {
                result = n.cost;
                return n.cost;
            } else {
                for (Node node : n.nexts) {
                    if (node.visited != 0) {
                        node.cost = n.cost + 1;
                        node.visited = 0;
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
        for (String str : dict) {
            if (!word.equals(str) && isOneCharacterDiff(word, str)) {
                result.add(str);
            }
        }
        return result;
    }

    protected boolean isOneCharacterDiff(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        int count = 0;
        for (int i=0; i< w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                count++;
                if (count > 1) {
                    break;
                }
            }
        }
        return count == 1;
    }
}
