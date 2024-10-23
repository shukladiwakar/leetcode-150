package bt;

import java.util.List;

public class LC139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0, new Boolean[s.length()]);
    }

    private boolean dfs(String s, List<String> wordDict, int startIndex, Boolean[] memo) {
        if (startIndex == s.length()) {
            return true;
        }
        if (memo[startIndex] != null) return memo[startIndex];
        boolean ans = false;

        for (String word : wordDict) {
            if (s.substring(startIndex).startsWith(word)) {
                ans = ans || dfs(s, wordDict, startIndex + word.length(), memo);
            }
        }
        memo[startIndex] = ans;
        return ans;
    }
}
