package array;

public class LC26RemoveDuplicates {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int dup = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prev == Integer.MIN_VALUE) {
                prev = nums[i];
                nums[dup++] = prev;
            } else if (prev != nums[i]) {
                prev = nums[i];
                nums[dup++] = prev;
            }
        }
        return dup;
    }
}
