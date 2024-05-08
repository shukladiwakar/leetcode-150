package array;

import java.util.Arrays;
import java.util.TreeMap;

public class LC80RemoveDups2 {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        LC80RemoveDups2 lc80RemoveDups2 = new LC80RemoveDups2();
        lc80RemoveDups2.removeDuplicates(arr);
    }


    public int removeDuplicates(int[] nums) {
        int op = 0;
        int prev = Integer.MIN_VALUE;
        int prevCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prev = nums[i];
                nums[op++] = prev;
                prevCount++;
            } else if (prev == nums[i] && prevCount < 2) {
                nums[op++] = prev;
                prevCount++;
            } else if (prev != nums[i]) {
                prevCount = 0;
                prev = nums[i];
                nums[op++] = prev;
                prevCount++;
            }
        }
        return op;
    }
}
