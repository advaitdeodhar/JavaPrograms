package LeetCode150.BinaryTree;

class FlattenBinaryTree {
    public void flatten(TreeNode root) {


        convertToLL(root);


    }

    private TreeNode convertToLL(TreeNode root) {
        if ( root == null ) {
            return null;
        }

        TreeNode leftTree = convertToLL(root.left);
        TreeNode rightTree = convertToLL(root.right);

        if ( leftTree != null ) {
            TreeNode c = leftTree;
            while (c.right != null) {
                c = c.right;
            }
            c.right = rightTree;
            root.right = leftTree;
            root.left = null;
        } else {
            root.right = rightTree;
            root.left = null;
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        two.left = three;
        two.right = four;
        five.right = six;
        one.left = two;
        one.right = five;

        FlattenBinaryTree s = new FlattenBinaryTree();

        s.flatten(one);

    }

}
