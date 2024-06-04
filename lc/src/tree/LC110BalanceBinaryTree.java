package tree;


import leetcodeds.TreeNode;

public class LC110BalanceBinaryTree {

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = dfs(root.left);
        int rh = dfs(root.right);

        if (lh == -1 || rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
}
