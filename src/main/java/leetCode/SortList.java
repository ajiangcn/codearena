package leetCode;

/**
 * Created by youjiang on 3/25/14.
 */
public class SortList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x; next = null;}
        ListNode(int x, ListNode ne) {val = x; next = ne;}
    }

    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode lh = null;
        ListNode lc = null;
        ListNode mh = head;
        ListNode mc = head;
        ListNode rh = null;
        ListNode rc = null;
        ListNode p = head.next;
        head.next = null;
        while(p != null) {
            ListNode tmp = p.next;
            p.next = null;
            if(p.val > head.val) {
                if(rh == null) {
                    rh = p;
                    rc = p;
                } else {
                    rc.next = p;
                    rc = rc.next;
                }
            } else if(p.val < head.val) {
                if(lh == null) {
                    lh = p;
                    lc = p;
                } else {
                    lc.next = p;
                    lc = lc.next;
                }
            } else {
                // p.val == head.val
                if(mh == null) {
                    mh = p;
                    mc = p;
                } else {
                    mc.next = p;
                    mc = mc.next;
                }
            }
            p = tmp;
        }
        ListNode leftSort = sortList(lh);
        ListNode rightSort = sortList(rh);
        if(leftSort != null) {
            p = leftSort;
            while(p.next != null) {
                p = p.next;
            }
            p.next = head;
            mc.next = rightSort;
            return leftSort;
        } else {
            mc.next = rightSort;
            return head;
        }
    }
}
