package LeetCode150.linkedList;

class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if ( left == right ) {
            return head;
        }

        ListNode nextNode = head;

        for ( int i = 1 ; i <= right; i++) {
            nextNode = nextNode.next;
        }


        if ( left != 1) {
            ListNode prevNode = head;

            for (int i = 1; i <= (left - 2); i++) {
                prevNode = prevNode.next;
            }


            prevNode.next = reverseCustomList(prevNode.next, nextNode);

            return head;
        }

        return reverseCustomList(head, nextNode);


    }

    private ListNode reverseCustomList(ListNode head, ListNode nextNode) {


        ListNode prev;
        ListNode next;

        prev = nextNode;

        while ( head != nextNode ) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
//        ListNode currentHead = head;
//        ListNode currentNext = nextNode;
//
//        ListNode nextHead;
//
//        while ( currentHead != nextNode) {
//            nextHead = currentHead.next;
//            currentHead.next = currentNext;
//            currentNext = currentHead;
//            currentHead = nextHead;
//        }
//
//        return currentNext;
    }
}
