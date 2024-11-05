package math;

import java.util.*;

public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n / 5;
            n = n / 5;
        }
        return sum;
    }

    public double myPow(double x, int n) {
        int temp = n;
        if (n < 0) {
            temp = temp * (-1);
        }
        double res = 1;
        while (temp > 0) {
            if (temp % 2 == 0) {
                x = x * x;
                temp = temp / 2;
            } else {
                res = res * x;
                temp--;
            }
        }
        if (n < 0) {
            return 1 / res;
        } else
            return res;
    }

    public int maxPoints(int[][] points) {
        int max_points = Integer.MIN_VALUE;
        Map<Integer, Integer> slopCount = new HashMap<>();

        for (int i = 0; i < points.length; i++) {

            int m = (points[i + 1][1] - points[i][1]) / (points[i + 1][0] - points[i][0]);
            slopCount.merge(m, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : slopCount.entrySet()) {
            max_points = Math.max(max_points, entry.getValue());
        }

        return max_points + 1;

    }

    public int missingNumber(int[] nums) {
        int size = nums.length + 1;
        int indices[] = new int[size];
        Arrays.fill(indices, -1);

        for (int i = 0; i < nums.length; i++) {
            indices[nums[i]] = nums[i];
        }

        for (int i = 0; i < indices.length; i++) {
            if (indices[i] == -1)
                return i;
        }
        return -1;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.merge(nums1[i], 1, Integer::sum);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.merge(nums2[i], 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (Math.min(entry.getValue(), map2.getOrDefault(entry.getKey(), 0)) > 0) {
                for (int i = 0; i < Math.min(entry.getValue(), map2.getOrDefault(entry.getKey(), 0)); i++) {
                    list.add(entry.getKey());
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
