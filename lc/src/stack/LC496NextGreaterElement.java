package stack;

import java.util.Stack;

public class LC496NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int indexes[] = new int[10001];

        for (int i = 0; i < nums2.length; i++) {
            indexes[nums2[i]] = i;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = doSomething(indexes[nums1[i]], nums2);
        }
        return nums1;
    }

    private int doSomething(int index, int[] nums2) {
        int ans = -1;
        for (int i = index + 1; i < nums2.length; i++) {
            if (nums2[i] > nums2[index]) {
                return nums2[i];
            }
        }
        return -1;
    }

    public int findLatest(Stack<Integer> stack, int i) {
        int ans = -1;
        while (!stack.isEmpty()) {
            int k = stack.pop();
            if (k > i) {
                ans = k;
            } else if (k == i) {
                stack.clear();
            }
        }
        return ans;
    }


}
