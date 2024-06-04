package algomonster.dfs;

import algomonster.algods.Node;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class SerialiseAndDeserialise {
    public static String serialize(Node root) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        dfsSerialiser(root, stringJoiner);
        return stringJoiner.toString();
    }

    public static void dfsSerialiser(Node root, StringJoiner stringJoiner) {

        if (root == null) {
            stringJoiner.add("x");
            return;
        }
        stringJoiner.add(Integer.toString((Integer) root.val));
        dfsSerialiser(root.left, stringJoiner);
        dfsSerialiser(root.right, stringJoiner);
    }

    public static Node deserialize(String root) {
        return dfsDeserialiser(Arrays.stream(root.split(" ")).iterator());
    }

    public static Node dfsDeserialiser(Iterator<String> nodes) {
        String val = nodes.next();
        if (val.equalsIgnoreCase("x")) {
            return null;
        }
        Node cur = new Node(Integer.parseInt(val));
        cur.left = dfsDeserialiser(nodes);
        cur.right = dfsDeserialiser(nodes);
        return cur;
    }
}
