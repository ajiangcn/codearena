package algorithm;

import org.apache.commons.lang3.Validate;

public class RedBlackBST {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        Key key;
        Value val;
        boolean color;       // color of parent link

        Node left;
        Node right;
    }

    boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    Node rotateLeft(Node h) {
        Validate.isTrue(h.right.color == RED);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    Node rotateRight(Node h) {
        Validate.isTrue(h.left.color == RED);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    void flipColors(Node h) {
        Validate.isTrue(!isRed(h));
        Validate.isTrue(isRed(h.left));
        Validate.isTrue(isRed(h.right));
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}
