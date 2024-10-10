package twopointers;

public class JumpGame2 {
    public int jump(int[] nums) {
        int jump = 0;
        int cur_pos = 0;
        if (nums[0] != 0) {
            jump++;
            cur_pos = 1;
        }

        while (cur_pos <= nums.length) {
            int nexJump = nums[cur_pos];

        }

        return -1;
    }
}
