package LeetCode150.linkedList;

class RemoveNThNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode current = head;

        int count = 0;

        while ( current != null ) {
            count++;
            current = current.next;
        }

        int k = count + 1 - n;

        if ( k ==  1) {
            return head.next;
        }

        current = head;
        for ( int i = 1; i <= ( k - 2) ; i++ ) {
            current = current.next;
        }

        current.next = current.next.next;
        return head;

    }
}
