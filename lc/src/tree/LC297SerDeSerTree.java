package tree;

import leetcodeds.TreeNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;


public class LC297SerDeSerTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static void dfsSerialise(TreeNode root, StringJoiner op) {
        if (root == null) {
            op.add("x");
            return;
        }
        op.add(Integer.toString(root.val));
        dfsSerialise(root.left, op);
        dfsSerialise(root.right, op);
    }

    public String serialize(TreeNode root) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        dfsSerialise(root, stringJoiner);
        return stringJoiner.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dfsDeserialise(Arrays.stream(data.split(" ")).iterator());
    }

    public static TreeNode dfsDeserialise(Iterator<String> nodes) {
        String val = nodes.next();
        if (val.equalsIgnoreCase("x")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfsDeserialise(nodes);
        node.right = dfsDeserialise(nodes);
        return node;
    }
}
