package LeetCode150.BinaryTree;

import java.util.HashMap;

class PreorderInorder {
    HashMap<Integer, Integer> weight = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        for ( int i = 0 ; i < inorder.length; i++ ) {
            weight.put(inorder[i], i);
        }

        TreeNode root = null;

        for ( Integer data : preorder) {
            root = addToTree(root, data);
        }

        return root;

    }

    private TreeNode addToTree(TreeNode root, Integer data) {

        if ( root == null ) {
            return new TreeNode(data);
        }

        if ( weight.get(data) > weight.get(root.val) ) {
            root.right = addToTree(root.right, data);
        } else {
            root.left = addToTree(root.left, data);
        }

        return root;

    }

    public static void main(String[] args) {
        PreorderInorder s = new PreorderInorder();
        System.out.println(s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
