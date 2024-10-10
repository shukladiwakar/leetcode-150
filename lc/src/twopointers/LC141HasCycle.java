package twopointers;


import leetcodeds.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC141HasCycle {

    
    
     public static ListNode nextNode(ListNode node) {
        if (node.next == null) {
            return node;
        }
        return node.next;
    }

    public static boolean hasCycle(ListNode nodes) {
        ListNode tortoise = nextNode(nodes);
        ListNode hare = nextNode(nextNode(nodes));
        while (tortoise != hare && hare.next != null) {
            tortoise = nextNode(tortoise);
            hare = nextNode(nextNode(hare));
        }
        return hare.next != null;
    }
}
