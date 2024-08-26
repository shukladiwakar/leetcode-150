package algomonster.twopointer;

import java.util.List;

public class RemoveDuplicates {
    public static int removeDuplicates(List<Integer> arr) {
        int left = 0;

        for (int right = 0; right < arr.size(); right++) {
            if (arr.get(left) != right) {
                left++;
                arr.set(left, arr.get(right));
            }
        }

        return left + 1;
    }
}
