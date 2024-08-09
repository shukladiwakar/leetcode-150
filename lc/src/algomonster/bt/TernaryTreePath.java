package algomonster.bt;

import java.util.ArrayList;
import java.util.List;

public class TernaryTreePath {

    public static void dfs(Node<Integer> root, List<String> res, List<String> path) {

        if (root.children.size() == 0) {
            path.add(Integer.toString(root.val));
            res.add(String.join("->", path));
            return;
        }

        for (Node<Integer> child : root.children) {
            if (child != null) {
                List<String> tempPath = new ArrayList<>(path);
                tempPath.add(Integer.toString(child.val));
                dfs(root, res, tempPath);
            }
        }
    }

    public static List<String> ternaryTreePaths(Node<Integer> root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            dfs(root, res, new ArrayList<String>());
        }
        return res;
    }
}
