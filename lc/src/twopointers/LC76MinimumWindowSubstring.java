package twopointers;

import java.util.Arrays;
import java.util.HashMap;

public class LC76MinimumWindowSubstring {
    //    s = "ADOBECODEBANC", t = "ABC"

    public static String getMinimumWindow(String original, String check) {
        HashMap<Character, Integer> checkCount = new HashMap<>();
        HashMap<Character, Integer> windowCount = new HashMap<>();

        for (int i = 0; i < check.length(); i++) {
            checkCount.compute(check.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        int satisfied = 0;
        int required = checkCount.size();
        int m = original.length();
        int window = -1;
        int length = m + 1;

        int l = 0;

        for (int r = 0; r < m; r++) {
            windowCount.compute(original.charAt(r), (k, v) -> v == null ? 1 : v + 1);

            if (windowCount.get(original.charAt(r)) == checkCount.get(original.charAt(r))) {
                satisfied++;
            }

            while (satisfied == required) {
                if (r - l + 1 < length ||
                        r - l + 1 == length && original.substring(l, r + 1).compareTo(original.substring(window, window + length)) < 0) {
                    window = l;
                    length = r - l + 1;
                }
            }

        }

        return "";
    }
}
