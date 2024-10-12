package PriorityQueue;

import java.util.*;

public class KWeakestRows {

    public static void main(String[] args) {
        int mat[][] = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        KWeakestRows kWeakestRows = new KWeakestRows();
        kWeakestRows.kWeakestRows(mat, 3);
    }

    class Row {
        int index;
        int count;

        public Row(int i, int c) {
            this.index = i;
            this.count = c;
        }

        @Override
        public String toString() {
            return "Row{" + "index=" + index + ", count=" + count + '}';
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> priorityQueue = new PriorityQueue<>(new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                if (o2.count > o1.count) {
                    return Integer.compare(o2.count, o1.count);
                }
                if (o2.count == o1.count) {
                    return Integer.compare(o2.index, o1.index);
                } else {
                    return -1;
                }
            }
        });


        int[] arr = new int[k];

        for (int i = 0; i < mat.length; i++) {
            int counter = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    counter++;
                }
            }
            Row row = new Row(i, counter);
            priorityQueue.add(row);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());

        for (int i = k - 1; i >= 0; i--) {
            arr[i] = priorityQueue.poll().index;
        }
        return arr;
    }


    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int op[] = new int[k];
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < priorityQueue.size(); i++) {
            indexMap.merge(priorityQueue.poll(), 1, Integer::sum);
        }
        int seq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.merge(nums[i], -1, Integer::sum) >= 0) {
                op[seq] = nums[i];
                seq++;
            }
        }

        return op;
    }

}
