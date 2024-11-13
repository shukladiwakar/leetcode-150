package stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class LC3174ClearDigits {

    public String clearDigits(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) && sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ABFCACDB";
        LC3174ClearDigits lc3174ClearDigits = new LC3174ClearDigits();
        lc3174ClearDigits.minLength(s);
    }

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ((stack.peek().toString() + ch + "").equals("AB") || (stack.peek().toString() + ch + "").equals("CD"))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
//        System.out.println(stack);
        return stack.size();
    }

    public String reversePrefix(String word, char ch) {
        Stack<Character> characters = new Stack<>();
        int i = 0;
        boolean found = false;

        for (; i < word.length(); i++) {
            characters.push(word.charAt(i));
            if (word.charAt(i) == ch) {
                found = true;
                break;
            }
        }

        if (!found) {
            return word;
        }

        StringBuilder builder = new StringBuilder();
        while (!characters.isEmpty()) {
            builder.append(characters.pop());
        }
        if (i != word.length()) {
            builder.append(word.substring(i + 1, word.length()));
        }

        return builder.toString();
    }
}
