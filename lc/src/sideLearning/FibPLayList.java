package sideLearning;

import java.util.Arrays;

public class FibPLayList {
    static int[] dp;

    public static void main(String[] args) {
        dp = new int[41];
        Arrays.fill(dp, -1);
        System.out.println(fib2(4));

    }

    static int fib(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fib(n - 1) + fib(n - 2);
    }

    static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}


