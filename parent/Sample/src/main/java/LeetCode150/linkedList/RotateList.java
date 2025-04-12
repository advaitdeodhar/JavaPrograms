package LeetCode150.linkedList;

class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if ( head == null ) {
            return null;
        }

        ListNode c = head;
        int count = 1;
        while ( c.next != null ) {

            c = c.next;
            count++;

        }
        c.next = head;

        c = head;

        k = k%count;

        for ( int i = 1; i < ( count -k ); i++ ) {
            c = c.next;
        }

        head = c.next;
        c.next = null;

        return head;

    }
}
