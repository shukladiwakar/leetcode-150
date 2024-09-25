package tree;

import leetcodeds.TreeNode;

import java.util.*;

public class LC111MinimumDepthTree {

    public int minDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);  // at least one element in the queue to kick start bfs
        int depth = 0;  // we start from -1 because popping root will add 1 depth
        if (root == null) {
            return 0;
        }
        while (queue.size() > 0) {  // as long as there is element in the queue
            depth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.pop();
                if (node.left == null && node.right == null) {
                    // found leaf node, early return
                    return depth;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxQueue.add(stone);
        }
        while (maxQueue.size() > 1) {
            int y = maxQueue.poll();
            int x = maxQueue.poll();

            if (x != y) {
                maxQueue.add(y - x);
            }
        }
        return maxQueue.size() > 0 ? maxQueue.poll() : 0;
    }
//
//    public int[] kWeakestRows(int[][] mat, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        for (int i = 0; i < mat.length; i++) {
//            int cnt =
//        }
//    }

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
