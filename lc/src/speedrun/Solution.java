package speedrun;

import leetcodeds.ListNode;

import java.util.*;

public class Solution {

    public int[] twoSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int res[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(k - arr[i])) {
                res[0] = map.get(k - arr[i]);
                res[1] = i;
            }
            map.put(arr[i], i);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int max_sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max_sum = Math.max(max_sum, max_sum + nums[i]);
            max_so_far = Math.max(max_sum, max_so_far);
        }
        return max_so_far;
    }

    public int[] productExceptSelf(int[] nums) {
        int op[] = new int[nums.length];
        int pd = 1;
        int countOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pd *= nums[i];
            } else {
                op[i] = 0;
                countOfZero++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && countOfZero <= 1) {
                op[i] = pd;
            }
            if (countOfZero > 1) {
                op[i] = 0;
            }
            if (nums[i] != 0 && countOfZero == 0) {
                op[i] = pd / nums[i];
            }

        }
        return op;
    }


    public static int[] topKFrequent(int arr[], int k) {
        int op[] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int key : map.keySet()) {
            priorityQueue.add(key);
        }

        System.out.println(priorityQueue);
        return op;
    }

    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[256];
        int[] tCount = new int[256];

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }

        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != tCount[i])
                return false;
        }

        return true;
    }

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();

        for (int k : map.keySet()) {
            if (map.get(k) == 2)
                list.add(k);
        }
        return list;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 2, 2, 3}, 2);
    }
}
