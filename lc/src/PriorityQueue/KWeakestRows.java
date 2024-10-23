package PriorityQueue;

import java.util.*;

public class KWeakestRows {


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

        for (int i = k - 1; i >= 0; i--) {
            arr[i] = priorityQueue.poll().index;
        }
        return arr;
    }


    public static void main(String[] args) {
        int nums[] = new int[]{2, 1, 3, 3};
        KWeakestRows kWeakestRows = new KWeakestRows();
        kWeakestRows.maxSubsequence(nums, 2);
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

        for (int n : priorityQueue) {
            indexMap.merge(n, 1, Integer::sum);
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
