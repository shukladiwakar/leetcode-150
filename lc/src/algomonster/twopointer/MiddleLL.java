package algomonster.twopointer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MiddleLL {

    public static int middleOfLinkedList(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    public void moveZeros(List<Integer> nums) {
        int slow = 0, fast = 0;
        while (fast < nums.size()) {
            if (nums.get(fast) == 0) {
                fast++;
            } else {
                int slowNum = nums.get(slow);
                nums.set(slow, nums.get(fast));
                nums.set(fast, slowNum);
                slow++;
                fast++;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                int slowNum = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = slowNum;
                slow++;
                fast++;
            }
        }
    }

    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            if (arr.get(left) + arr.get(right) == target) {
                return List.of(left, right);
            } else if (arr.get(left) + arr.get(right) > target) {
                right--;
            } else {
                left++;
            }
        }
        return List.of(-1, -1);

    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == ' ') {
                i++;
            }
            char temp = Character.toLowerCase(s.charAt(j));
            if (s.charAt(j) == ' ' || temp < 'a' || temp > 'z') {
                j--;
            }
            if (Character.toLowerCase(s.charAt(j)) != Character.toLowerCase(s.charAt(i))) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

    public static int subarraySumFixed(List<Integer> nums, int k) {
        int max = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums.get(i);
        }
        max = windowSum;
        for (int i = k; i < nums.size(); i++) {
            int lastElement = i - k;
            windowSum = windowSum + nums.get(i) - nums.get(lastElement);
            max = Math.max(max, windowSum);
        }
        return max;
    }


    public static List<Integer> findAllAnagrams(String original, String check) {

        int len = check.length();
        List<Integer> list = new ArrayList<>();
        char[] sortedCheck = check.toCharArray();
        Arrays.sort(sortedCheck);

        for (int i = 0; i < original.length(); i++) {
            char[] temp = original.substring(i, i + len).toCharArray();
            Arrays.sort(temp);

            if (Arrays.equals(temp, sortedCheck)) {
                list.add(i);
            }
        }
        return list;
    }

    //nums = [1, 6, 3, 1, 2, 4, 5] and target = 10
    //i=0,j=0
    //arr[i] + arr[j]
    public static int subarraySumLongest(List<Integer> nums, int target) {
        int maxLen = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;

        while (j < nums.size() && i < nums.size()) {
            sum = sum + nums.get(j);

            if (sum > target) {
                sum = sum - nums.get(i);
                ++i;
            } else {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        subarraySumLongest(List.of(1, 6, 3, 1, 2, 4, 5), 10);
    }

}

