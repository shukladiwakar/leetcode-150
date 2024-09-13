package algomonster.bfs;

import algomonster.algods.Node;

import java.util.*;

public class ShortestPath {
    public static int bfs(List<List<Integer>> graph, int root, int target) {
        int level = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(root);
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int node = queue.poll();
                if (node == target) {
                    return level;
                }
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
}
