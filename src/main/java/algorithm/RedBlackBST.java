package algorithm;

public class RedBlackBST {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        Key key;
        Value val;
        boolean color;       // color of parent link
    }

    boolean isRead(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }
}
