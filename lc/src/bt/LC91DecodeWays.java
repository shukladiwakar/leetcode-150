package bt;

import java.util.Arrays;

public class LC91DecodeWays {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
    }

    public int dfs(String s, int startIndex, int[] memo) {
        if (startIndex == s.length())
            return 1;
        int ways = 0;
        if (memo[startIndex] != -1) return memo[startIndex];

        if (s.charAt(startIndex) == '0')
            return ways;

        ways += dfs(s, startIndex + 1, memo);
        if (startIndex + 2 <= s.length() && Integer.parseInt(s.substring(startIndex, startIndex + 2)) <= 26) {
            ways += dfs(s, startIndex + 2, memo);
        }
        memo[startIndex] = ways;
        return ways;
    }


}
