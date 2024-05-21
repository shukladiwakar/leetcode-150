package maps;

import java.util.*;

public class LC49GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = Arrays.toString(chars);
            if (map.containsKey(sorted)) {
                List<String> temp = map.get(sorted);
                temp.add(s);
                map.put(sorted, temp);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }

        List<List<String>> finalOp = new ArrayList<>();

        for (String s1 : map.keySet()) {
            finalOp.add(map.get(s1));
        }

        return finalOp;
    }
}
