package stack;

import java.util.*;

public class LC316RemoveDups {
    public String removeDuplicateLetters(String s) {
        StringBuilder op = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        for (Character ch : set) {
            op.append(ch);
        }
        return op.toString();
    }


    public static int containerWithMostWater(List<Integer> arr) {
        int area = Integer.MIN_VALUE;
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {

            area = Math.max(area, Math.min(arr.get(left), arr.get(right)) * (right - left));

            if (arr.get(left) < arr.get(right)) {
                left++;
            } else
                right--;
        }
        return area;
    }
}
