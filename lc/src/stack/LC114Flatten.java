package stack;

import leetcodeds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC114Flatten {
    Queue<Integer> stack = new LinkedList<>();

    public void flatten(TreeNode root) {

        addtoStack(root);

    }

    public void addtoStack(TreeNode root) {
        if (root == null)
            return;
        stack.add(root.val);
        addtoStack(root.left);
        addtoStack(root.right);
    }

}
