package array;

import java.util.Arrays;

public class LC27RemoveElements {


    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        removeElement(nums, val);

    }
}
