package algomonster.dfs;

import algomonster.algods.Node;

public class InsertIntoBst {

    public static void dfs(Node<Integer> bst, int val) {

    }

    public static Node<Integer> insertBst(Node<Integer> bst, int val) {

        if (bst == null) {
            //setup a new node
            return new Node<>(val);
        }
        int comparedResult = bst.val.compareTo(val);
        if (comparedResult < 0) {
            bst.right = insertBst(bst.right, val);
        } else if (comparedResult > 0) {
            bst.left = insertBst(bst.left,val);
        }
        return bst;
    }
}
