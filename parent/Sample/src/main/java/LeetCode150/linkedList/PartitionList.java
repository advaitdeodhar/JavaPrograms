package LeetCode150.linkedList;

class PartitionList {
    public ListNode partition(ListNode head, int x) {

        ListNode ff = null, fl = null;
        ListNode sf = null, sl = null;


        ListNode c = head;

        while ( c != null ) {

            if ( c.val < x ) {

                if ( ff == null ) {
                    ff = c;
                } else {
                    fl.next = c;
                }
                fl = c;

            } else {

                if ( sf == null ) {
                    sf = c;
                } else {
                    sl.next = c;
                }
                sl = c;

            }

            c = c.next;

        }

        if ( fl != null ) {
            fl.next = sf;
        } else {
            ff = sf;
        }

        if ( sl != null ) {
            sl.next = null;
        }

        return ff;

    }
}
