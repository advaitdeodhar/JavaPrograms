package LeetCode150.linkedList;

class RemoveDuplicatesForSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        if ( head == null ) {
            return null;
        }

        ListNode ans = null;

        ListNode last = null;


        ListNode current = head;
        ListNode cf = current;
        ListNode cl = cf;
        int val = cf.val;


        while (current != null) {

            if (current.val == val) {
                cl = current;
                current = current.next;
                continue;
            }

            if (cf == cl) {
                if (ans == null) {
                    ans = cf;
                } else {
                    last.next = cf;
                }
                last = cf;
            }

            cf = current;
            cl = cf;
            val = cf.val;

            current = current.next;
        }

        if (cf == cl) {
            if (ans == null) {
                ans = cf;
            } else {
                last.next = cf;
            }
            last = cf;
        }

        if ( last != null ) {
            last.next = null;
        }

        return ans;


    }
}
