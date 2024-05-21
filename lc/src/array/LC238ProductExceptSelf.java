package array;

public class LC238ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int pd = 1;
        int op[] = new int[nums.length];
        int countOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pd *= nums[i];
            } else {
                op[i] = 0;
                countOfZero++;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && countOfZero > 1) {
                op[i] = 0;
            } else if (nums[i] == 0 && countOfZero <= 1) {
                op[i] = pd;

            } else if (nums[i] != 0 && countOfZero > 0) {
                op[i] = 0;
            } else if (nums[i] != 0) {
                op[i] = pd / nums[i];
            }
        }
        return op;
    }
}
