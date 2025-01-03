import leetcodeds.ListNode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void moveZeroes(int[] nums) {

    }
}