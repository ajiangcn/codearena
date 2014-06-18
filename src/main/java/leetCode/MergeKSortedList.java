package leetCode;

import java.util.ArrayList;

/**
 * Created by youjiang on 3/17/14.
 */
public class MergeKSortedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x; next = null;}
        ListNode(int x, ListNode ne) {val = x; next = ne;}
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0) {
            return null;
        } else if(lists.size() == 1) {
           return lists.get(0);
        } else if (lists.size() == 2) {
           return merge2List(lists.get(0), lists.get(1));
        } else {
           ArrayList<ListNode> ls = new ArrayList<ListNode>();
           for(int i=0; i<lists.size();) {
               if(i+1 <= lists.size()-1) {
                   ls.add(merge2List(lists.get(i), lists.get(i+1)));
                   i += 2;
               } else {
                   ls.add(lists.get(i));
                   i += 1;
               }
           }
           return mergeKLists(ls);
        }
    }

    public ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l1h = l1;
        ListNode l2h = l2;
        ListNode result = null;
        ListNode resultCur = null;
        while(l1h != null && l2h != null) {
            if(l1h.val > l2h.val) {
                if(result == null) {
                    result = l2h;
                    resultCur = l2h;
                } else {
                    resultCur.next = l2h;
                    resultCur = l2h;
                }
                l2h = l2h.next;
            } else {
                if(result == null) {
                    result = l1h;
                    resultCur = l1h;
                } else {
                    resultCur.next = l1h;
                    resultCur = l1h;
                }
                l1h = l1h.next;
            }
        }

        while(l1h != null) {
            resultCur.next = l1h;
            resultCur = l1h;
            l1h = l1h.next;
        }
        while(l2h != null) {
            resultCur.next = l2h;
            resultCur = l2h;
            l2h = l2h.next;

        }
        return result;
    }
}
