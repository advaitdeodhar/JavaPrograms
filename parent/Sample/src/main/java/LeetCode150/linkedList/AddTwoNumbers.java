package LeetCode150.linkedList;

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1, p2;
        p1 = l1;
        p2 = l2;


        int n1, n2;
        n1 = l1.val;
        n2 = l2.val;
        int ans = n1 + n2;

        int newVal = ans % 10;
        int carry = ans / 10;

        ListNode ret = new ListNode(newVal, null);
        ListNode current = ret;

        p1 = p1.next;
        p2 = p2.next;
        while ( !(p1 == null && p2 == null )) {
            if ( p1 == null ) {
                n1 = 0;
            } else {
                n1 = p1.val;
                p1 = p1.next;
            }

            if ( p2 == null ) {
                n2 = 0;
            } else {
                n2 = p2.val;
                p2 = p2.next;
            }

            ans = n1 + n2 + carry;

            newVal = ans % 10;
            carry = ans / 10;

            ListNode next = new ListNode(newVal, null);
            current.next = next;

            current = next;

        }

        if ( carry != 0 ) {
            ListNode next = new ListNode(carry, null);
            current.next = next;
        }

        return ret;
    }
}
