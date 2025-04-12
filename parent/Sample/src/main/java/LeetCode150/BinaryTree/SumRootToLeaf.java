package LeetCode150.BinaryTree;

class SumRootToLeaf {
    int ans = 0 ;

    public int sumNumbers(TreeNode root) {

        processTree(root, 0);
        return ans;
        
    }

    private void processTree(TreeNode root, int base) {
        if ( root == null ) {
            return;
        }

        int newBase = base * 10 + root.val;

        if ( root.left == null && root.right == null ) {
            ans += newBase;
        } else {
            processTree(root.left, newBase);
            processTree(root.right, newBase);
        }

    }
}
