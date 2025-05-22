package LeetCode150.BinaryTree;

class ValidateBST {

    Boolean isValid = true;


    Integer lastNumber = null;


    public boolean isValidBST(TreeNode root) {


        visit(root);
        return isValid;


    }


    private void visit(TreeNode node) {
        if ( !isValid) {
            return;
        }

        if ( node.left != null ) {
            visit(node.left);
        }

        process(node.val);

        if ( node.right != null ) {
            visit(node.right);
        }
    }

    private void process(int n) {

        if ( lastNumber != null ) {
            System.out.println(lastNumber + ":" + n);
            isValid &= n > lastNumber;
        }
        lastNumber = n;
    }

}
