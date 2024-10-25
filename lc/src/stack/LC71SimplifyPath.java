package stack;

import java.util.Arrays;
import java.util.Stack;

public class LC71SimplifyPath {
    public static void main(String[] args) {
        LC71SimplifyPath lc71SimplifyPath = new LC71SimplifyPath();
        lc71SimplifyPath.simplifyPath("/home/user/Documents/../Pictures");
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String token : path.split("/")) {
            if (token.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!Arrays.asList(".", "..", "").contains(token)) {
                stack.push(token);
            }
        }
        return "/" + String.join("/", stack);
    }


}
