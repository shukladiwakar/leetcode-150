package tree;

import leetcodeds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    List<Integer> list;

    public static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    //    public int findSecondMinimumValue(TreeNode root) {
//
//    }
    public List<Integer> rightSideView(TreeNode root) {

    }
}
