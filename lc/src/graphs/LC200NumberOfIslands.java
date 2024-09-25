package graphs;

import algomonster.bfs.NumberOfIslands;
import leetcodeds.ListNode;

import java.util.*;

public class LC200NumberOfIslands {
    public static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int element = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                priorityQueue.add(matrix[i][j]);
            }
        }
        while (k > 0) {
            element = priorityQueue.poll();
            k--;
        }
        return element;
    }

    public static int kthSmallest(List<List<Integer>> matrix, int k) {
        int element = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                priorityQueue.add(matrix.get(i).get(j));
            }
        }

        while (k > 0) {
            element = priorityQueue.poll();
            k--;
        }
        return element;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp.next != null) {
                queue.add(temp);
                temp = temp.next;
            }
        }
        ListNode listNode = null;

        while (queue.size() > 0) {
            ListNode temp = queue.poll();
            if (listNode == null) {
                listNode = new ListNode(temp.val);
            } else {
                listNode.next = new ListNode(temp.val);
            }
        }
        return listNode;

    }

    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {

        List<Integer> op = new ArrayList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                queue.add(lists.get(i).get(j));
            }
        }
//        System.out.println(queue);
        while (queue.size() > 0) {
            op.add(queue.poll());
        }
        return op;
    }

    public static List<Coordinate> getNeighbours(Coordinate node, int numberOfRows, int numberOfColumns) {
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaColumn[] = {0, 1, 0, -1};

        List<Coordinate> neighbours = new ArrayList<>();

        for (int i = 0; i < deltaRow.length; i++) {
            int newR = node.r + deltaRow[i];
            int newC = node.c + deltaColumn[i];

            if (newR >= 0 && newR < numberOfRows &&
                    newC >= 0 && newC < numberOfColumns) {
                neighbours.add(new Coordinate(newR, newC));
            }
        }
        return neighbours;
    }

    public static void bfs(char[][] grid, Coordinate node, int numRows, int numColumns) {
        Queue<Coordinate> coordinateQueue = new ArrayDeque<>();

        coordinateQueue.add(node);
        grid[node.r][node.c] = 0;
        while (coordinateQueue.size() > 0) {

            Coordinate coordinate = coordinateQueue.poll();
            List<Coordinate> neighbours = getNeighbours(coordinate, numRows, numColumns);

            for (Coordinate coordinate1 : neighbours) {
                if (grid[coordinate1.r][coordinate1.c] == '0') {
                    continue;
                }
                coordinateQueue.add(coordinate1);
                grid[coordinate1.r][coordinate1.c] = '0';
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int numRows = grid.length;
        int numColumns = grid[0].length;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '0') {
                    continue;
                }
                bfs(grid, new Coordinate(i, j), numRows, numColumns);
                count++;
            }
        }
        return count;
    }

    public static double distance(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }

    public static class Node {

    }

    public static List<List<Integer>> kClosestPoints(List<List<Integer>> points, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return distance(o1) - distance(o2);
            }
        };
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < points.size(); i++) {
            queue.add(points.get(i));
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public static int distance(List<Integer> point) {
        return point.get(0) * point.get(0) + point.get(1) * point.get(1);
    }

    public int[][] kClosest(int[][] points, int k) {
        int arr[][] = new int[k][2];

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return distance(o1) - distance(o2);
            }
        };

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, comparator);

        for (int i = 0; i < points.length; i++) {
            priorityQueue.add(points[i]);
        }

        for (int i = 0; i < k; i++) {
            arr[i] = priorityQueue.poll();
        }
        return arr;
    }

    public int distance(int[] point) {
        return -(point[0] * point[0] + point[1] * point[1]);
    }

    public static int findKthLargest(List<Integer> nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < nums.size(); i++) {
            priorityQueue.add(nums.get(i));
        }
        int el = 0;
        while (k > 0) {
            el = priorityQueue.poll();
        }
        return el;
    }

}
