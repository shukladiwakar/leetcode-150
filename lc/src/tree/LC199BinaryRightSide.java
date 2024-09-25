package tree;


import leetcodeds.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC199BinaryRightSide {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> bfs = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        queue.add(root);

        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add((Integer) node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            bfs.add(level);
        }

        for (List<Integer> list : bfs) {
            res.add(list.get(list.size() - 1));
        }

        return res;
    }
}
