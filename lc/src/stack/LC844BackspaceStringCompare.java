package stack;

import algomonster.algods.Node;

import java.util.*;

public class LC844BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "Mr John Smith      ";


        LC844BackspaceStringCompare lc844BackspaceStringCompare = new LC844BackspaceStringCompare();
        lc844BackspaceStringCompare.replaceSpaces(s.toCharArray(), 13);
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && !stack.isEmpty()) {
                stack.pop();
            } else if (t.charAt(i) != '#') {
                stack.add(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#' && !stack2.isEmpty()) {
                stack2.pop();
            } else if (t.charAt(i) != '#') {
                stack2.add(t.charAt(i));
            }
        }
        if (stack2.size() != stack.size()) {
            return false;
        } else {
            while (!stack.isEmpty()) {
                if (stack.pop() != stack2.pop()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void replaceSpaces(char[] str, int trueLength) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < trueLength; i++) {
//            stringBuilder.append(str[i]);
//        }
//        String temp = stringBuilder.toString().replace(" ", "%20").toString();
//        System.out.println(temp);
        int changedLength = str.length - trueLength - 1;
    }

    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            int level = queue.size();

            List<Integer> level1 = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                Node<Integer> node = queue.poll();
                level1.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level1);
        }
        return res;
    }
}
