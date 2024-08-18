package linkedlist;


import algomonster.algods.Node;
import leetcodeds.ListNode;
import leetcodeds.TreeNode;

import java.util.*;

public class LC146LRUCache {
//    public LC146LRUCache(int capacity) {
//
//    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {

    }

    public boolean isPalindrome(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }

        String s = stringBuilder.toString();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

//    public static void main(String[] args) {
//        LC146LRUCache lc146LRUCache = new LC146LRUCache();
//        lc146LRUCache.constructRectangle(37);
//    }

    public boolean isPowerOfTwo(int n) {
//        if (n == 1) {
//            return true;
//        }
//        if (n == 0) {
//            return false;
//        }
//        while (n > 0) {
//            if (n % 2 == 1)
//                return false;
//            if (n == 2) {
//                return true;
//            }
//            n = n / 2;
//        }
//        return true;

        return n > 0 && ((n - 1) & n) == 0;
    }

    public int[] constructRectangle(int area) {
        int i = (int) Math.sqrt(area);

        for (; i > 0; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return new int[]{area, 1};
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (head != null) {

            if (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return temp;
    }

    public static void bfs(Node<Integer> root, List<List<Integer>> res) {

        if (root == null) {
            return;
        }

        Queue<Node<Integer>> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(root);

        while (bfsQueue.size() > 0) {
            int n = bfsQueue.size();
            List<Integer> newLevel = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node<Integer> node = bfsQueue.poll();
                newLevel.add(node.val);

                if (node.left != null) {
                    bfsQueue.add(node.left);
                }

                if (node.right != null) {
                    bfsQueue.add(node.right);
                }
            }
            res.add(newLevel);
        }
    }

    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        List<List<Integer>> levelOrderedList = new ArrayList<>();
        if (root == null) {
            return levelOrderedList;
        }
        Queue<Node<Integer>> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(root);
        while (bfsQueue.size() > 0) {
            int n = bfsQueue.size();
            List<Integer> newLevel = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node<Integer> node = bfsQueue.poll();
                newLevel.add(node.val);
                if (node.left != null) {
                    bfsQueue.add(node.left);
                }
                if (node.right != null) {
                    bfsQueue.add(node.right);
                }
            }
            levelOrderedList.add(newLevel);
        }
        return levelOrderedList;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res.reversed();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        int i = 1;
        while (i < res.size()) {
            if (i % 2 == 1) {
                List<Integer> temp = res.get(i).reversed();
                res.set(i, temp);
            }
            i += 2;
        }
        return res;
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);

        while (nodes.size() > 0) {
            int n = nodes.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode temp = nodes.poll();
                list.add(temp.val);

                if (temp.left != null) {
                    nodes.add(temp.left);
                }

                if (temp.right != null) {
                    nodes.add(temp.right);
                }
            }

            res.add(list);
        }

        List<Integer> orderedList = new ArrayList<>();

        for (List<Integer> list1 : res) {
            orderedList.addAll(list1);
        }
        Collections.sort(orderedList);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < orderedList.size() - 1; i++) {

            if (Math.abs(orderedList.get(i) - orderedList.get(i + 1)) < min) {
                min = Math.abs(orderedList.get(i) - orderedList.get(i + 1));
            }
        }
        return min;
    }

    public static String convertToTitle(int columnNumber) {
        char ch = 'A';
        char cz = 'Z';
        for (int i = ch; i <= cz; i++) {
            System.out.println((char) i);
        }

        return null;
    }

    public static void main(String[] args) {
        myPow(2, -2);
    }

    public static double myPow(double x, int n) {
        double op = x;
        if (n == 0) {
            return 1;
        }
        int temp = n;
        if (n < 0) {
            temp = (-1) * n;
        }
        for (int i = 2; i <= temp; i++) {
            op = op * x;
        }
        if (n < 0) {
            op = 1 / op;
        }
        return op;
    }

}
