package linkedlist;

import leetcodeds.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC876MiddleNode {


    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        while (n > 0) {
            if (n % 3 != 0) {
                return false;
            }
            if (n % 3 == 0 && n / 3 == 1) {
                return true;
            }
            n = n / 3;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Most Frequent IP!");

        getMostFrequentIp(new String[]{
                "10.0.0.1 - GET 2020-08-24",
                "10.0.0.1 - GET 2020-08-24",
                "10.0.0.2 - GET 2020-08-20",
                "10.0.0.3 - GET 2020-08-24",
                "10.0.0.3 - GET 2020-08-24",
                "10.0.0.3 - GET 2020-08-24",
                "10.0.0.4 - GET 2020-08-24"});
    }

    public static void getMostFrequentIp(String[] logs) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String log : logs) {
            String[] arr = log.split(" ");
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
        }

        List<String> mostFrequent = new ArrayList<>();
        int freq = 0;

        for (String ip : map.keySet()) {
            freq = Math.max(freq, map.get(ip));
        }

        for (String ip : map.keySet()) {
            if (map.get(ip) == freq) mostFrequent.add(ip);
        }

        System.out.println(mostFrequent);
    }

    public ListNode middleNode(ListNode head) {
        int size = 0;

        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int i = size / 2 + 1;
        temp = head;
        while (i > 1) {
            temp = temp.next;
            i--;
        }
        return temp;
    }
}
