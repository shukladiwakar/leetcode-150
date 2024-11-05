package bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC39CombinationSum {
    public static void main(String[] args) {
        LC39CombinationSum lc39CombinationSum = new LC39CombinationSum();
        System.out.println(lc39CombinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
//        dfs(candidates, result, seq, target, 0, 0);
        return result;

    }

    public static List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
        Collections.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        dfs(candidates, result, seq, target, 0, 0);
        return result;
    }

    public static void dfs(List<Integer> candidates, List<List<Integer>> res, List<Integer> seq, int target, int sum, int start) {

        if (sum == target) {
            res.add(new ArrayList<>(seq));
            return;
        }
        if (sum < target) {
            for (int i = start; i < candidates.size(); i++) {
                sum += candidates.get(i);
                if (sum > target)
                    break;
                seq.add(candidates.get(i));
                dfs(candidates, res, seq, target, sum, i);
                seq.remove(seq.size() - 1);
                sum -= candidates.get(i);
            }
        }
    }
}