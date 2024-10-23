package stack;

import leetcodeds.Node;

import java.util.*;

public class LC589NarryTree {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        nodeDfs(root, result);
        return result;
    }

    public void nodeDfs(Node root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);

        for (Node children : root.children) {
            nodeDfs(children, result);
        }
    }

    public static void main(String[] args) {
        LC589NarryTree lc589NarryTree = new LC589NarryTree();
        lc589NarryTree.decodeString("3[a]2[bc]");
    }

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> count = new Stack<>();
        Stack<Character> repeat = new Stack<>();
        int i = 0;
        boolean pushing = false;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                count.add(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                pushing = true;
            } else if (s.charAt(i) == ']') {
                pushing = false;
                StringBuilder temp = new StringBuilder();
                while (!count.isEmpty()) {
                    temp.append(count.pop());
                }
                int ct = Integer.parseInt(temp.reverse().toString());
                temp = new StringBuilder();
                while (!repeat.isEmpty()) {
                    temp.append(repeat.pop());
                }
                temp.reverse();

                while (ct > 0) {
                    result.append(temp.toString());
                    ct--;
                }


            } else if (pushing) {
                repeat.push(s.charAt(i));
            }
            i++;
        }
        System.out.println(result.toString());

        return result.toString();
    }


}
