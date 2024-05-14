package array;

import java.util.PriorityQueue;

public class LC274HIndex {

    public static void main(String[] args) {
        int arr[] = new int[]{3, 0, 6, 1, 5};
        hIndex(arr);
    }

    public static int hIndex(int[] citations) {
        int hIndex = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int i : citations) {
            priorityQueue.offer(i);
        }

        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty() && priorityQueue.peek() > hIndex) {
//            System.out.println(priorityQueue.peek());
            priorityQueue.poll();
            hIndex++;
        }
        return hIndex;
    }
}
