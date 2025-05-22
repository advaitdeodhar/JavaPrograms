package LeetCode150.BinaryTree;

class KthSmallest {


    int kthMin = 0;
    int k;

    public int kthSmallest(TreeNode root, int k) {

        this.k = k;
        visit(root);
        return kthMin;

    }

    private void visit(TreeNode node) {

        if ( node.left != null && kthMin == 0) {
            visit(node.left);
        }

        k--;
        process(node.val, k);


        if ( node.right != null && kthMin == 0) {
            visit(node.right);
        }

    }

    private void process(int val, int k) {

        System.out.println(val + ":" + k);
        if ( k == 0 ) {
            kthMin = val;
        }

    }

}
