package bt;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, 0, 0, new StringBuilder());
        return result;
    }

    void dfs(List<String> res, int n, int openCount, int closeCount, StringBuilder path) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }

        if (openCount < n) {
            path.append("(");
            dfs(res, n, openCount + 1, closeCount, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (closeCount < openCount) {
            path.append(")");
            dfs(res, n, openCount, closeCount + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
