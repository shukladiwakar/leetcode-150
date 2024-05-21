package array;

public class LC219Containsdublicates {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= i + k; j++) {
                if (i != j && j < nums.length) {

                    if (Math.abs(i - j) <= k && nums[i] == nums[j]) return true;
                }

            }
        }

        return false;
    }

}
