package LeetCode150.linkedList;


import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> refMap = new HashMap<>();

        Node oc = head;
        while ( oc != null ) {
            Node current = new Node(oc.val);
            refMap.put(oc, current);
            oc = oc.next;
        }

        refMap.put(null, null);

        oc = head;
        while (oc != null) {
            Node current = refMap.get(oc);

            current.next = refMap.get(oc.next);
            current.random = refMap.get(oc.random);
            oc = oc.next;
        }

        return refMap.get(head);


    }
}
