package LeetCode150.linkedList;

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        if ( list1 == null ) {
            return list2;
        }

        if ( list2 == null ) {
            return list1;
        }

        ListNode ret, c, c1, c2;
        c1 = list1;
        c2 = list2;

        if ( c1.val > c2.val ) {
            ret = c2;
            c2 = c2.next;
        } else {
            ret = c1;
            c1 = c1.next;
        }

        c = ret;

        while ( true ) {

            if ( c1 == null ) {
                c.next = c2;
                break;
            }

            if ( c2 == null ) {
                c.next = c1;
                break;
            }

            if ( c1.val > c2.val ) {
                c.next = c2;
                c2 = c2.next;
            } else {
                c.next = c1;
                c1 = c1.next;
            }
            c = c.next;
        }

        return ret;

    }
}
