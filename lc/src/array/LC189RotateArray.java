package array;

public class LC189RotateArray {
    //solution1
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int nums[], int l, int r) {
        int li = l;
        int ri = r;

        while (li < ri) {
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;

            li++;
            ri--;
        }
    }
}
