package tree;

import leetcodeds.ListNode;
import leetcodeds.TreeNode;

import java.util.*;

public class LC112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    List<Integer> list;

    public static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    //    public int findSecondMinimumValue(TreeNode root) {
//
//    }
//    public List<Integer> rightSideView(TreeNode root) {
//
//    }

    //LC6 ZigZag Conversion
    public static String convert(String s, int numRows) {
        int arr[][] = new int[numRows][13];

        for (int row[] : arr) {
            Arrays.fill(row, 0);
        }

        System.out.println(Arrays.deepToString(arr));
        return "";
    }

    public static void main(String[] args) {
        convert("diwakar", 3);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list3 = new ArrayList<>();
        while (list1 != null) {
            list3.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            list3.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(list3);
        if (list3.size() == 0) {
            return new ListNode();
        }
        System.out.println(list3.size());
        ListNode op = new ListNode(list3.get(0), null);

        for (int i = 1; i < list3.size(); i++) {
            ListNode temp = new ListNode(list3.get(i), null);
            op.next = temp;
        }

        return op;
    }
}
