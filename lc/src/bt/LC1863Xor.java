package bt;

import java.util.ArrayList;
import java.util.List;

public class LC1863Xor {

    public static void main(String[] args) {
        LC1863Xor lc1863Xor = new LC1863Xor();
        lc1863Xor.subsetXORSum(new int[]{5, 1, 6});

    }

    public int finalXor;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return finalXor;
    }

    public void dfs(int nums[], int index, int curXor) {
        finalXor += curXor;

        for (int i = index; i < nums.length; i++) {
            curXor ^= nums[i];
            dfs(nums, i + 1, curXor);
            curXor ^= nums[i];

        }
    }
}
