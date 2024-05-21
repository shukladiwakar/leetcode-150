package twopointers;

public class LC392IsSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        isSubsequence(s, t);
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        while (j < t.length()) {
            if (t.charAt(j) == s.charAt(i) && i < s.length()) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
