package stack;

import leetcodeds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC114Flatten {
    public Queue<TreeNode> queue = new LinkedList<>();

    public void flatten(TreeNode root) {

        addToQueue(root);

        while (queue != null) {
            TreeNode temp = queue.poll();
            temp.right = queue.peek();
            temp.left = null;
        }

    }

    public void addToQueue(TreeNode root) {

        if (root == null) {
            return;
        }
        queue.add(root);
        addToQueue(root.left);
        addToQueue(root.right);
    }


}
