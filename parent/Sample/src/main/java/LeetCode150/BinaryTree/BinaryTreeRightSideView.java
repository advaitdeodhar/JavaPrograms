package LeetCode150.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> retVal = new ArrayList<>();
        List<TreeNode> currentList = new ArrayList<>();

        if ( root == null ) {
            return retVal;
        }

        currentList.add(root);

        TreeNode lastNode = null;
        while ( !currentList.isEmpty() ) {
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : currentList) {
                lastNode = node;

                if ( node.left != null ) {
                    newList.add(node.left);
                }

                if ( node.right != null ) {
                    newList.add(node.right);
                }
            }
            retVal.add(lastNode.val);
            currentList = newList;
        }

        return retVal;
    }
}
