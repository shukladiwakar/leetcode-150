package dp;

public class LC403FrogJump {
    public boolean canCross(int[] stones) {

        int firstJump = stones[1] - stones[0];
        if (firstJump > 1)
            return false;
        for (int i = 2; i < stones.length - 1; i++) {
            int nextJump = stones[i] - stones[i - 1];
            if (firstJump - 1 <= nextJump && firstJump + 1 >= nextJump) {
                nextJump = firstJump;
            } else {
                return false;
            }
        }

        return true;
    }
}
