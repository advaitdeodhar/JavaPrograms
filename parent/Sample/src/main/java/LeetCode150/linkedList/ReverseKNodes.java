package LeetCode150.linkedList;

class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode last, prev;
        last = getLast(current, k);

        ListNode ans;
        if (last != null) {
            ans = reverseCustomList(null, head, last.next);
        } else {
            return head;
        }

        prev = head;
        current = prev.next;
        last = getLast(current, k);

        while (last != null) {

            reverseCustomList(prev, current, last.next);
            prev = current;
            current = prev.next;
            last = getLast(current, k);


        }
        return ans;
    }

    private ListNode getLast(ListNode first, int k) {

        ListNode current = first;
        for (int i = 1; i < k; i++) {
            if (current != null) {
                current = current.next;
            } else {
                return null;
            }
        }
        return current;
    }

    private ListNode reverseCustomList(ListNode earlier, ListNode head, ListNode nextNode) {


        ListNode prev;
        ListNode next;

        prev = nextNode;

        while (head != nextNode) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        if (earlier != null) {
            earlier.next = prev;
        }

        return prev;
    }
}
