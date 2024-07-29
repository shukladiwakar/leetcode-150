package algomonster.dfs;

import algomonster.algods.Node;

import java.util.ArrayList;
import java.util.List;

public class ValidBst {

    static List<Integer> list;

    public static boolean validBst(Node<Integer> root) {
        list = new ArrayList<>();
        dfs(root);
        if (list.isEmpty() || list.size() == 1)
            return true;
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(Node<Integer> root) {
        if (root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);

    }

}
