package algomonster.dfs;

import algomonster.algods.Node;

public class VisibleNode {

    public static int dfs(Node<Integer> root, int maxSoFar) {
        if (root == null)
            return 0;
        int total = 0;
        if (root.val >= maxSoFar) {
            total++;
        }
        total += dfs(root.left, Math.max(maxSoFar, root.val));
        total += dfs(root.right, Math.max(maxSoFar, root.val));

        return total;
    }

    public static int visibleTreeNode(Node<Integer> root) {

        return dfs(root, Integer.MIN_VALUE);
    }
}
