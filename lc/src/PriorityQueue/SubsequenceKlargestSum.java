package PriorityQueue;

import java.util.PriorityQueue;

public class SubsequenceKlargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int op[] = new int[k];
        for (int i = 0; i < k; i++) {
            op[i] = priorityQueue.poll();
        }

        return op;
    }
}
