package tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LC590NarryTree {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public void dfs(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i), list);
            }
        }
        list.add(root.val);
    }

    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int differenceOfSums(int n, int m) {
        int div = 0;
        int nonDiv = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                div = div + i;
            } else {
                nonDiv = nonDiv + i;
            }
        }
        return nonDiv - div;
    }

    public int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if ((i - 1 >= 0) && (i + 1 < nums.length) && (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return 0;
    }
}
