package LeetCode150.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
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
class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retVal = new ArrayList<>();

        if ( root == null ) {
            return retVal;
        }

        List<TreeNode> currentList = new ArrayList<>();

        currentList.add(root);

        List<Integer> ansValue;

        boolean isReverse = false;

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

            if ( isReverse ) {
                Collections.reverse(ansValue);
            }
            retVal.add(ansValue);

            isReverse = ! isReverse;
            currentList = newList;
        }

        return retVal;

    }
}
