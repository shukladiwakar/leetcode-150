package tree;

import java.util.ArrayList;
import java.util.List;


public class LC516LongestPallindrominSubsequence {


    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void dfs(List<List<String>> ans, ArrayList<String> part, String s, int start) {
        if (start == s.length()) {
            List<String> li = new ArrayList<>(part);
            ans.add(li);
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s.substring(start, end + 1))) {
                part.add(s.substring(start, end + 1));
                dfs(ans, part, s, end + 1);
                part.remove(part.size() - 1);
            }
        }
    }

    public int longestPalindromeSubseq(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), s, 0);
        int max = Integer.MIN_VALUE;
        for (List<String> strings : ans) {
            for (String ss : strings) {
                max = Math.max(ss.length(), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC516LongestPallindrominSubsequence lc516LongestPallindrominSubsequence = new LC516LongestPallindrominSubsequence();
        lc516LongestPallindrominSubsequence.longestPalindromeSubseq("bbbab");

    }
}
