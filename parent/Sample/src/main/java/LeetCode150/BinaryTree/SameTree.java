package LeetCode150.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> pcNodes = new ArrayList<>();
        List<TreeNode> qcNodes = new ArrayList<>();

        if ( p == null && q == null ) {
            return true;
        }

        if ( p == null || q == null ) {
            return false;
        }


        pcNodes.add(p);
        qcNodes.add(q);

        while ( true ) {

            if ( pcNodes.isEmpty() && qcNodes.isEmpty() ) {
                return true;
            }

            if ( pcNodes.size() != qcNodes.size() ) {
                return false;
            }

            List<TreeNode> pnNodes = new ArrayList<>();
            List<TreeNode> qnNodes = new ArrayList<>();

            for ( int i = 0 ; i < pcNodes.size(); i++ ) {

                TreeNode pNode = pcNodes.get(i);
                TreeNode qNode = qcNodes.get(i);

                if ( pNode.val != qNode.val ) {
                    return false;
                }

                if ( pNode.right != null || qNode.right != null ) {

                    if ( pNode.right == null || qNode.right == null) {
                        return false;
                    }
                    pnNodes.add(pNode.right);
                    qnNodes.add(qNode.right);

                }

                if ( pNode.left != null || qNode.left != null ) {

                    if ( pNode.left == null || qNode.left == null ) {
                        return false;
                    }
                    pnNodes.add(pNode.left);
                    qnNodes.add(qNode.left);

                }



            }
            pcNodes = pnNodes;
            qcNodes = qnNodes;

        }
    }
}