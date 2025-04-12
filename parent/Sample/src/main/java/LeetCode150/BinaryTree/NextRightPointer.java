package LeetCode150.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class NextRightPointer {
    public Node connect(Node root) {

        if ( root == null ) {
            return null;
        }

        List<Node> currentList = new ArrayList<>();
        currentList.add(root);
        root.next = null;

        while ( !currentList.isEmpty() ) {

            List<Node> nextList = new ArrayList<>();
            Node prev = null;
            for ( Node n : currentList ) {

                if ( n.left != null ) {
                    nextList.add(n.left);
                }

                if ( n.right != null ) {
                    nextList.add(n.right);
                }

                if ( prev != null ) {
                    prev.next = n;
                }

                prev = n;
            }

            currentList = nextList;

        }
        return root;
    }
}
