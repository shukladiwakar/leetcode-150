package bt;

import java.util.Arrays;

public class LC322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int memo[] = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = dfs(coins, amount, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;

    }

    public int dfs(int coins[], int amount, int sum, int memo[]) {
        if (sum == amount) {
            return 0;
        }
        if (sum > amount) {
            return Integer.MAX_VALUE;
        }

        if (memo[sum] != -1) return memo[sum];

        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = dfs(coins, amount, sum + coin, memo);
            if (result == Integer.MAX_VALUE)
                continue;
            ans = Math.min(ans, result + 1);
        }
        return memo[sum] = ans;
    }
}
