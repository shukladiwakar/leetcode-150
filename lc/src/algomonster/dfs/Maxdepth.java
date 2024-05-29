package algomonster.dfs;

import algomonster.algods.Node;

public class Maxdepth {

    public static int treeMaxDepth(Node<Integer> root) {
        return root != null ? dfs(root) - 1 : 0;
    }

    public static int dfs(Node<Integer> root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.max(left, right) + 1;
    }
}
