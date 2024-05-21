package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC128LongestSequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, 1);
        }

        return -1;
    }
}
