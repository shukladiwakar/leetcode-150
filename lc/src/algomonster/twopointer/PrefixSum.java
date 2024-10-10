package algomonster.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrefixSum {
    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        List<Integer> op = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            int cur_sum = 0;
            for (int j = i; j < arr.size(); j++) {
                cur_sum += arr.get(j);

                if (cur_sum == target) {
                    return List.of(i, j);
                }
            }
        }
        return op;
    }

    public static List<Integer> subarraySum2(List<Integer> arr, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 0);
        int curSum = 0;
        System.out.println(arr);
        for (int i = 0; i < arr.size(); i++) {
            curSum += arr.get(i);
            int complement = curSum - target;
            System.out.println("i: " + i + "\tcurr_Sum: " + curSum + "\tcomplement: " + complement + "\tmap: " + prefixSums);
            if (prefixSums.containsKey(complement)) {
                return List.of(prefixSums.get(complement), i + 1);
            }
            prefixSums.put(curSum, i + 1);
        }
        return null;
    }

    public static int subarraySumTotal(List<Integer> arr, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 0);
        int curSum = 0;
        int counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            curSum += arr.get(i);
            int complement = curSum - target;
            if (prefixSums.containsKey(complement)) {
                counter++;
            }
            prefixSums.put(curSum, i + 1);
        }
        return counter;
    }

    public static void main(String[] args) {
        subarraySum2(List.of(1, 3, -3, 8, 5, 7), 5);
    }


}
