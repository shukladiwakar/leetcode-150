package tree;

import com.sun.source.tree.Tree;
import leetcodeds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC99recoverBst {

    static TreeNode prev = null;
    static TreeNode first = null;
    static TreeNode seconds = null;
    static List<TreeNode> nodes;

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        nodes.add(root);
        dfs(root.right);
    }

    public void recoverTree(TreeNode root) {
        nodes = new ArrayList<>();
        int val1 = -1;
        int val2 = -1;
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).val > nodes.get(i + 1).val) {
//            if(val1)
            }
        }
    }

    static boolean op = false;

    public static void dfs1(TreeNode root, int target, int currentSum) {
        if (root == null) {
            if (currentSum == target) {
                op = true;
            }
            return;
        }
        currentSum += root.val;

        dfs1(root.left, target, currentSum);
        dfs1(root.right, target, currentSum);

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs1(root, targetSum, 0);
        return op;
    }
}
