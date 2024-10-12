package PriorityQueue;

import java.util.*;

public class KthLargest {

    int k;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() > k) {
                queue.poll();
            }
            queue.add(nums[i]);
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);

    }
}
