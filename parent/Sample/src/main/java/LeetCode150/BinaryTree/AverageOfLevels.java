package LeetCode150.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> retVal = new ArrayList<>();
        List<TreeNode> currentList = new ArrayList<>();

        if ( root == null ) {
            return retVal;
        }

        currentList.add(root);

        TreeNode lastNode = null;
        while ( !currentList.isEmpty() ) {
            List<TreeNode> newList = new ArrayList<>();
            int count = 0;
            long sum = 0;
            for (TreeNode node : currentList) {
                count++;
                sum += node.val;
                if ( node.left != null ) {
                    newList.add(node.left);
                }

                if ( node.right != null ) {
                    newList.add(node.right);
                }
            }
            retVal.add(((double)sum)/count);
            currentList = newList;
        }

        return retVal;
    }
}
