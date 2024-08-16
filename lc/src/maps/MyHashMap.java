package maps;

import java.util.Arrays;

class MyHashMap {

    int[] data;

    public MyHashMap() {
        data = new int[100001];
        Arrays.fill(data, -1);
    }

    /*
    This code defines a method put that
    stores a value in an array data at
    a specific key index.
     */
    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }

    public void rotate(int[] nums, int k) {
        k = nums.length % k;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    static void reverse(int arr[], int li, int hi) {
        while (li < hi) {
            int temp = arr[li];
            arr[hi] = arr[li];
            arr[li] = temp;
            li++;
            hi--;
        }
    }
}