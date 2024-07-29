package algomonster.dfs;

import algomonster.algods.Node;

public class LcaOnBst {
    public static void main(String[] args) {

    }

    public static int lcaOnBst(Node<Integer> bst, int p, int q) {

        if (p > bst.val && q > bst.val) {
            return lcaOnBst(bst.left, p, q);
        }
        if (p < bst.val && q < bst.val) {
            return lcaOnBst(bst.right, p, q);
        }
        return bst.val;
    }
}
