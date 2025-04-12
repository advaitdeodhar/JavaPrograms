package LeetCode150.BinaryTree;

class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if ( root == null ) {
            return false;
        }

        if ( hasPathSum(root.left, targetSum - root.val) ) {
            return true;
        }

        if ( hasPathSum(root.right, targetSum - root.val) ) {
            return true;
        }

        return root.left == null && root.right == null && root.val == targetSum;
    }
}
