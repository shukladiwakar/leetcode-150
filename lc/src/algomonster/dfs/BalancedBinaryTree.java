package algomonster.dfs;

import algomonster.algods.Node;

public class BalancedBinaryTree {
    public static boolean isBalanced(Node<Integer> tree) {
        // WRITE YOUR BRILLIANT CODE HERE
        return dfs(tree) != -1;
    }

    static int dfs(Node<Integer> tree) {
        if (tree == null)
            return 0;
        int lh = dfs(tree.left);
        int rh = dfs(tree.right);

        if (lh == -1 || rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return Math.max(lh, rh) + 1;
    }

}
