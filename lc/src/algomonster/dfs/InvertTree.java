package algomonster.dfs;

import algomonster.algods.Node;

public class InvertTree {
    public static Node<Integer> invertBinaryTree(Node<Integer> tree) {
        if (tree == null) {
            return null;
        }
        Node node = new Node(tree.val);
        node.left = invertBinaryTree(tree.right);
        node.right = invertBinaryTree(tree.left);

        return node;
    }
}
