package LeetCode150.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> retVal = new ArrayList<>();

        if ( root == null ) {
            return retVal;
        }

        List<TreeNode> currentList = new ArrayList<>();

        currentList.add(root);

        List<Integer> ansValue;

        while ( !currentList.isEmpty() ) {
            ansValue = new ArrayList<>();
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : currentList) {
                ansValue.add(node.val);
                if ( node.left != null ) {
                    newList.add(node.left);
                }

                if ( node.right != null ) {
                    newList.add(node.right);
                }
            }

            retVal.add(ansValue);
            currentList = newList;
        }

        return retVal;


    }
}