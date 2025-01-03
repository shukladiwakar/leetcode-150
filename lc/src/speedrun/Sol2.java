package speedrun;

import java.util.Arrays;

public class Sol2 {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1, 3, 4, 6, 8, 9, 2, 2, 3, 4, 6, 7, 8, 9, 9, 3, 4, 6};

        int[] l = longestIncreasingSubarray(arr);

        System.out.println(Arrays.toString(l));
    }

    private static int[] longestIncreasingSubarray(int[] arr) {

        int left = 0;
        int right = 1;
        int max_len = Integer.MIN_VALUE;
        int a = left;
        int b = right;
        for (int i = left; i < arr.length; i++) {
            int prev = arr[i];

            while (right < arr.length) {
                if (prev < arr[right]) {
                    prev = arr[right];
                } else {
                    break;
                }
                right++;
            }
            if (max_len < right - left - 1) {
                max_len = Math.max(max_len, right - left);
                a = left;
                b = right;
            }
            left = right;
            right = left + 1;
        }

        int op[] = new int[b - a];

        for (int i = a; i < b; i++) {
            op[i] = arr[i];
        }
        return op;
    }

}
