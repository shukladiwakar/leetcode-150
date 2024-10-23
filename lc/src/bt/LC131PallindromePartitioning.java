package bt;

import java.util.ArrayList;
import java.util.List;

public class LC131PallindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, res, new ArrayList<>(), 0);
        return res;
    }

    void dfs(String s, List<List<String>> res, List<String> path, int curI) {
        if (curI == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = curI; i < s.length(); i++) {
            if (isPallindrome(s.substring(curI, i + 1))) {
                path.add(s.substring(curI, i + 1));
                dfs(s, res, path, curI + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPallindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

}
