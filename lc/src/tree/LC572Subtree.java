package tree;

import leetcodeds.TreeNode;

public class LC572Subtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) {
            return true;
        }
        if (root == null || sub == null) {
            return false;
        }
        return root.val == sub.val && dfs(root.left, sub.left) && dfs(root.right, sub.right);
    }

}
