package stack;

import java.util.Stack;

public class LC682Baseball {
    public int calPoints(String[] operations) {
        Stack<Integer> operationStack = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("+")) {
                int a2 = operationStack.pop();
                int a1 = operationStack.pop();
                operationStack.add(a1);
                operationStack.add(a2);
                operationStack.add(a2 + a1);

            } else if (operation.equals("D")) {
                operationStack.add(operationStack.peek() * 2);
            } else if (operation.equals("C")) {
                operationStack.pop();
            } else {
                operationStack.add(Integer.parseInt(operation));
            }
        }
        int ans = 0;
        while (!operationStack.isEmpty()) {
            ans += operationStack.pop();
        }
        return ans;
    }
}
