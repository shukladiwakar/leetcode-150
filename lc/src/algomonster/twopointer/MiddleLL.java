package algomonster.twopointer;


import java.math.BigInteger;
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

    public static void main(String[] args) {
        System.out.println(subarraySumLongest(Arrays.asList(1, 6, 3, 1, 2, 4, 5), 10));
    }

    //nums = [1, 6, 3, 1, 2, 4, 5] and target = 10
    public static int subarraySumLongest(List<Integer> nums, int target) {
        int windowSum = 0;
        int length = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); right++) {

            System.out.println("left " + left + " right " + right);
            windowSum += nums.get(right);
            while (windowSum > target) {
                windowSum -= nums.get(left);
                left++;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int[] count = new int[256];
        Arrays.fill(count, 0);
        int max_Len = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count[ch]++;
            while (count[ch] > 1) {
                count[s.charAt(left)]--;
                left++;
            }

            max_Len = Math.max(max_Len, right - left + 1);
        }
        return max_Len;
    }

    public static int subarraySumShortest(List<Integer> nums, int target) {

        int left = 0;
        int max_len = Integer.MIN_VALUE;
        int window_sum = 0;
        for (int right = 0; right < nums.size(); right++) {
            window_sum += nums.get(right);

            while (window_sum >= target) {
                max_len = Integer.min(max_len, right - left + 1);
                window_sum = window_sum - nums.get(left);
                left++;
            }
        }
        return max_len;
    }

    public static String multiply(String num1, String num2) {
        BigInteger mul = new BigInteger(String.valueOf(0));
        for (int i = num1.length() - 1; i >= 0; i--) {
            double tempMul = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                tempMul += ((Integer.parseInt(String.valueOf(num1.charAt(i))) * Math.pow(10, num1.length() - 1 - i)) *
                        (Integer.parseInt(String.valueOf(num2.charAt(j))) * Math.pow(10, num2.length() - 1 - j)));
            }
            mul = mul.add(new BigInteger(String.valueOf(tempMul)));
        }
        return String.valueOf(mul);
    }


    public boolean isPallindrome(String string) {
        int i = 0;
        int j = string.length() - 1;

        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}

