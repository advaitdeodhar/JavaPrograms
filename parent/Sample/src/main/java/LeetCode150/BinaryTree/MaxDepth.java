package LeetCode150.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class MaxDepth {
    public int maxDepth(TreeNode root) {

        List<TreeNode> currentNodes = new ArrayList<>();
        if ( root != null ) {
            currentNodes.add(root);
        }
        int level = 0;
        while ( !currentNodes.isEmpty() ) {
            level++;
            List<TreeNode> nextNodes = new ArrayList<>();
            for ( TreeNode node : currentNodes ) {
                if ( node.left != null ) {
                    nextNodes.add(node.left);
                }

                if ( node.right != null ) {
                    nextNodes.add(node.right);
                }
            }
            currentNodes = nextNodes;

        }
        return level;
    }
}
