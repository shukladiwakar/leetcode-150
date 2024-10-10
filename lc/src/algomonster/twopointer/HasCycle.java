package algomonster.twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static boolean hasCycle(Node<Integer> nodes) {
        Set<Node<Integer>> set = new HashSet<>();

        while (nodes != null) {
            if (set.contains(nodes))
                return true;
            set.add(nodes);
            nodes = nodes.next;
        }
        return false;
    }
}
