package twopointers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc2260 {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min_len = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                min_len = Math.min(min_len, i - map.get(cards[i]) + 1);

                map.put(cards[i], i);
            } else {
                map.put(cards[i], i);
            }
        }
        return min_len == Integer.MAX_VALUE ? -1 : min_len;
    }

    public int minimumCardPickup2(int[] cards) {
        HashMap<Integer, Integer> window = new HashMap<Integer, Integer>();
        int left = 0;
        int shortest = cards.length + 1;
        for (int right = 0; right < cards.length; ++right) {
            window.put(cards[right], window.getOrDefault(cards[right], 0) + 1);
            while (window.get(cards[right]) == 2) {
                shortest = Math.min(shortest, right - left + 1);
                window.put(cards[left], window.get(cards[left]) - 1);
                ++left;
            }
        }
        return shortest != cards.length + 1 ? shortest : -1;
    }


    public static int leastConsecutiveCardsToMatch(List<Integer> cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min_len = Integer.MAX_VALUE;
        for (int i = 0; i < cards.size(); i++) {
            if (map.containsKey(cards.get(i))) {
                min_len = Math.min(min_len, i - map.get(cards.get(i)) + 1);

                map.put(cards.get(i), i);
            } else {
                map.put(cards.get(i), i);
            }
        }
        return min_len == Integer.MAX_VALUE ? -1 : min_len;
    }
}
