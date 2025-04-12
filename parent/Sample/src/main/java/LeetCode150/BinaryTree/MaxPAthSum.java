package LeetCode150.BinaryTree;

class MaxPAthSum {

    int max = -10000;

    public int maxPathSum(TreeNode root) {
        int val = processNode(root);
        return Math.max(val, max);
    }
    public int processNode(TreeNode root) {

        if ( root == null ) {
            return -10000;
        }

        int retVal;
        int left = processNode(root.left);
        int right = processNode(root.right);

        int leftArm = left + root.val;
        int rightArm = right + root.val;


        retVal = getMax(root.val, leftArm, rightArm);

        int nodeMax = getMax(left, right, left + right + root.val);

        max = Math.max(max, nodeMax);

        return retVal;


    }

    private static int getMax(int n1, int n2, int n3) {
        int max;
        if( n1 > n2) {
            max = n1;
        } else {
            max = n2;
        }

        if ( n3 > max ) {
            max = n3;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPAthSum s = new MaxPAthSum();

        TreeNode node = new TreeNode(-3);

        System.out.println(s.maxPathSum(node));

    }
}
