package tree;

import leetcodeds.ListNode;
import leetcodeds.TreeNode;

import java.util.List;
import java.util.Stack;

public class MergetwoTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode sumroot = new TreeNode(root1.val + root2.val);


        sumroot.left = mergeTrees(root1.left, root2.left);
        sumroot.right = mergeTrees(root1.right, root2.right);

        return sumroot;
    }


    public ListNode reverseList(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        head = null;
        if (stack.size() > 0) {
            ListNode listNode = new ListNode(stack.pop());
            head = listNode;


            while (!stack.isEmpty()) {
                ListNode node = new ListNode(stack.pop());
                head.next = listNode;
                head = head.next;
            }
        }
        return head;
    }
}
