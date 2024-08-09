package algomonster.bt;

import java.util.ArrayList;
import java.util.List;

public class StringPartitionPallindrome {

    public static List<List<String>> partition(String s) {
        List<List<String>> strings = new ArrayList<>();
        dfs(s, strings, new ArrayList<>(), 0);
        return strings;
    }

    public static void dfs(String s, List<List<String>> res, List<String> path, int startIndex) {
        if (s.length() == startIndex) {
            res.add(path);
        }
        for (char c : s.toCharArray()) {
            path.add(String.valueOf(c));

        }
    }
}
