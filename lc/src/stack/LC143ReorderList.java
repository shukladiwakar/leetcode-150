package stack;

import leetcodeds.ListNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class LC143ReorderList {
    public Queue<ListNode> node = new ArrayDeque<>();

    public void reorderList(ListNode head) {

        int i = 0;
        while (!node.isEmpty()) {
        }
    }

    public void addToDequeue(ListNode head) {
        while (head != null) {
            node.add(head);
            head = head.next;
        }
    }
}
