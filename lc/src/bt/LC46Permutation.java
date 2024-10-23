package bt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LC46Permutation {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3};
        LC46Permutation lc46Permutation = new LC46Permutation();

        lc46Permutation.permute(arr);
    }

    public static List<String> permutations(String letters) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<String> res = new ArrayList<>();
        dfs1(res, new ArrayList<>(), letters.toCharArray(), new boolean[letters.length()]);
        return res;

    }

    public static void dfs1(List<String> result, List<String> path, char[] nums, boolean[] visisted) {
        if (path.size() == nums.length) {
            result.add(String.join("", path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visisted[i])
                continue;
            visisted[i] = true;
            path.add(nums[i] + "");
            dfs1(result, path, nums, visisted);
            visisted[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] visisted) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visisted[i])
                continue;
            visisted[i] = true;
            path.add(nums[i]);
            dfs(result, path, nums, visisted);
            visisted[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
