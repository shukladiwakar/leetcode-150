package bt;

import java.util.*;
import java.util.stream.Collectors;

public class LC401BinaryWatch {

    public static void main(String[] args) {
        LC401BinaryWatch lc401BinaryWatch = new LC401BinaryWatch();
        System.out.println(letterCombination(2));
    }

    private static void dfs(Integer n, List<String> res, int startIndex, List<Character> path) {

        if (startIndex == n) {
            res.add(path.stream().map(e -> e.toString()).collect(Collectors.joining()));
            return;
        }
        for (char ch : new char[]{'a', 'b'}) {
            path.add(ch);
            System.out.println("path before:-> " + path);
            dfs(n, res, startIndex + 1, path);
            System.out.println("path after dfs:->" + path);
            path.remove(startIndex);
            System.out.println("path after removing:->" + path);
        }
    }

    public static List<String> letterCombination(Integer n) {
        List<String> res = new ArrayList<>();
        dfs(n, res, 0, new ArrayList<>());
        return res;
    }


    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        List<String> result = new ArrayList<>();

        List<String> chars = new ArrayList<>();
        for (char ch : digits.toCharArray()) {
            chars.addAll(listMap(Integer.parseInt(ch + "")));
        }
        dfsForCombination(chars, result, digits.length(), 0, new ArrayList<>());
        return result;
    }

    private static void dfsForCombination(List<String> chars, List<String> result, int length, int curI, ArrayList<String> objects) {
        if (curI == length) {
            result.add(String.join("", objects));
        }

        for (String ch : chars) {
            objects.add(ch);
            dfsForCombination(chars, result, length, curI + 1, objects);
            objects.remove(curI);
        }
    }

    public static List<String> listMap(Integer val) {
        Map<Integer, List<String>> listMap = new HashMap<>();
        listMap.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        listMap.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        listMap.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        listMap.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        listMap.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        listMap.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        listMap.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        listMap.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        return listMap.get(val);
    }
}
