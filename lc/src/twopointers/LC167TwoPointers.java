package twopointers;

public class LC167TwoPointers {

    public int[] twoSum(int[] numbers, int target) {
        int arr[] = new int[2];

        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                arr[0] = l + 1;
                arr[1] = r + 1;
            }
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
