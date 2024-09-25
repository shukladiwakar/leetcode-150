package algomonster.bfs;

import algomonster.algods.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
    public static List<Integer> binaryTreeRightSideView(Node<Integer> root) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> bfs = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
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

    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                level.add((Integer) node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        int i = 1;
        while (i < res.size()) {
            if (i % 2 == 1) {
                List<Integer> temp = res.get(i).reversed();
                res.set(i, temp);
            }
            i += 2;
        }
        return res;
    }
}
