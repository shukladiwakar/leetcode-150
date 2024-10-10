package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = new int[]{10, 3, 8, 9, 4};
        RelativeRanks relativeRanks = new RelativeRanks();

        relativeRanks.findRelativeRanks(score);
    }

    /*
    Input: score = [5,4,3,2,1]
    Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
    Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
     */
    class Athelete {
        int score;
        int index;

        public Athelete(int score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public String toString() {
            return "score " + this.score + " index " + this.index + "\n";
        }
    }


    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Athelete> priorityQueue = new PriorityQueue<>(new Comparator<Athelete>() {
            @Override
            public int compare(Athelete o1, Athelete o2) {
                return o2.score - o1.score;
            }
        });

        String op[] = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            Athelete athelete = new Athelete(score[i], i);
            priorityQueue.add(athelete);
        }

        Athelete athelete = priorityQueue.poll();
        if (athelete != null)
            op[athelete.index] = "Gold Medal";


        Athelete athelete2 = priorityQueue.poll();
        if (athelete2 != null)
            op[athelete2.index] = "Silver Medal";


        Athelete athelete3 = priorityQueue.poll();
        if (athelete3 != null)
            op[athelete3.index] = "Bronze Medal";

        int counter = 3;
        while (priorityQueue.size() > 0) {
            Athelete athelete1 = priorityQueue.poll();
            op[athelete1.index] = counter++ + "";
        }
        return op;
    }
}
