package bt;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {

    public static void main(String[] args) {
        LC78Subsets lc78Subsets = new LC78Subsets();
        System.out.println(lc78Subsets.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int nums[], List<List<Integer>> res, List<Integer> path, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        dfs(nums, res, path, i + 1);
        path.remove(path.size() - 1);
        dfs(nums, res, path, i + 1);
    }

    public static List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs2(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public static void dfs2(List<Integer> nums, List<List<Integer>> res, List<Integer> path, int i) {
        if (i == nums.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums.get(i));
        dfs2(nums, res, path, i + 1);
        path.remove(path.size() - 1);
        dfs2(nums, res, path, i + 1);
    }
}
