package company.wayfair;

public class ShortestPathInBinaryMatric {

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int tempMul = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                tempMul = tempMul * nums[j];
                max = Math.max(tempMul, max);
            }
            max = Math.max(max, tempMul);
        }
        return max;
    }

    public static void main(String[] args) {
        maxProduct(new int[]{0, 2});
    }
}
