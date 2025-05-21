package LeetCode150.BinaryTree;

class MinimumAbsoluteDifference {

    int minDiff = 1000000;
    int lastNumber = -1;

    public int getMinimumDifference(TreeNode root) {

        visit(root);
        return minDiff;

    }

    private void visit(TreeNode node) {
        if ( node.left != null ) {
            visit(node.left);
        }

        process(node.val);
        if ( node.right != null ) {
            visit(node.right);
        }
    }

    private void process(int n) {

        if ( lastNumber != -1 ) {
            int currentDiff = n - lastNumber;
            if (currentDiff < minDiff ) {
                minDiff = currentDiff;
            }
        }
        lastNumber = n;
    }
}
