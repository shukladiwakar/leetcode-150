package algomonster.twopointer;

import java.util.HashMap;
import java.util.Map;

public class NumArray {
    final int nums[];
    Map<Integer, Integer> prefixSummap;

    public NumArray(int[] nums) {
        this.nums = nums;
        prefixSummap = new HashMap<>();
        int cur_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            cur_sum += nums[i];
            prefixSummap.put(i, cur_sum);
        }
    }

    public int sumRange(int left, int right) {
        if (left > right)
            return -1;

        if (left == 0) {
            return prefixSummap.get(right);
        } else {
            return prefixSummap.get(right) - prefixSummap.get(left - 1);
        }
    }
}
