package tree;

import leetcodeds.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.equals(p) || root.equals(q)) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;

        if (left != null) return left;
        if (right != null) return right;

        return null;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int fixed = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (fixed + nums[left] + nums[right] == 0 && i != left && i != right) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (fixed + nums[left] + nums[right] > 0) {
                    right--;
                } else if (fixed + nums[left] + nums[right] < 0) {
                    left++;
                }
            }
        }
        return res;
    }


    public static int containerWithMostWater(List<Integer> arr) {
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i; j < arr.size(); j++) {
                area = Math.max(Math.min(arr.get(i), arr.get(j)) * (j - i), area);
            }
        }
        return area;
    }
}
