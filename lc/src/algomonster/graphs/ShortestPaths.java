package algomonster.graphs;

import java.util.*;

public class ShortestPaths {

    public static int bfs(List<List<Integer>> graph, int root, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(root);
        int level = 0;
        while (queue.size() > 0) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                int node = queue.poll();
                if (node == target)
                    return level;
                for (int neighbours : graph.get(node)) {
                    if (visited.contains(neighbours)) {
                        continue;
                    }
                    queue.add(neighbours);
                    visited.add(neighbours);
                }
            }
            level++;
        }
        return level;
    }

    public static int shortestPath(List<List<Integer>> graph, int a, int b) {
        return bfs(graph, a, b);
    }


    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (n > 1) {
            if (map.containsKey(n)) {
                return false;
            }
            map.put(n, 1);
            n = getSum(n);
        }
        return true;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        int count = 1;
        int maxi = 1;

        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            } else if (nums[i + 1] - nums[i] == 1) {
                count++;
            } else {
                maxi = Math.max(count, maxi);
                count = 1;
            }
        }
        maxi = Math.max(maxi, count);

        return maxi;
    }

    public boolean wordPattern(String pattern, String s) {
        char[] pa = pattern.toCharArray();
        String s1[] = s.split(" ");

        if (pa.length != s1.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pa.length; i++) {
            if (map.containsKey(pa[i])) {
                if (!s1[i].equals(map.get(pa[i]))) {
                    return false;
                }
            }
            if (map2.containsKey(s1[i])) {
                if (pa[i] != map2.get(s1[i])) {
                    return false;
                }
            }
            map.put(pa[i], s1[i]);
            map2.put(s1[i], pa[i]);
        }
        return true;
    }
}
