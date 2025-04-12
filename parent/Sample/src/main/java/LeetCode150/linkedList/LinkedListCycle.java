package LeetCode150.linkedList;




public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode p1, p2;

        if ( head == null ) {
            return false;
        }
        p1 = head;
        p2 = head.next;

        while ( true ) {
            if ( p1 == p2 ) {
                return true;
            }

            if ( p2 == null || p2.next == null ) {
                break;
            }

            p1 = p1.next;
            p2 = p2.next.next;
        }

        return false;
    }
}