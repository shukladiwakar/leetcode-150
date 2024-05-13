package algos;

public class KadanesAlgo {
    public static void main(String[] args) {
        int arr[] = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(tempSolution(arr));
    }

    public static int tempSolution(int nums[]) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            max = Math.max(sum, max);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
