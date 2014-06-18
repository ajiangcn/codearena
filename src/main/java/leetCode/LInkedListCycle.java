package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youjiang on 3/22/14.
 */
public class LInkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;  next = null; }
        ListNode(int x, ListNode ne) { val = x; next = ne; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode cur = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (cur != null) {
            if(visited.contains(cur)) {
                return true;
            } else {
                visited.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }
}
