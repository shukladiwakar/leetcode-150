package algomonster.bt;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombination {


    public static void dfs(List<String> res, int n, List<String> path, int startIndex) {
        if (startIndex == n) {
            res.add(path.stream().map(e -> e.toString()).collect(Collectors.joining()));
            return;
        }
        char[] temp = new char[]{'a', 'b'};
        for (char ch : temp) {
            path.add(String.valueOf(ch));
            dfs(res, n, path, startIndex + 1);

            path.remove(startIndex);
        }

    }

    public static List<String> letterCombination(Integer n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, new ArrayList<>(), 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombination(2));
    }


    public static void dfsForPhoneNumbers(String digits, int n, List<String> res, int startIndex, List<String> path) {

        if (startIndex == n) {
            res.add(path.stream().map(e -> e.toString()).collect(Collectors.joining()));
            return;
        }
        char nexDigit = digits.charAt(startIndex);
        for (String option : listMap(Integer.parseInt(String.valueOf(nexDigit)))) {
            path.add(option);
            dfsForPhoneNumbers(digits, n, res, startIndex + 1, path);
            path.remove(startIndex);
        }
    }

    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        int n = digits.length();
        List<String> characters = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            characters.addAll(listMap(Integer.parseInt(String.valueOf(digits.charAt(i)))));
        }

        dfsForPhoneNumbers(digits, n, res, 0, new ArrayList<>());
        return res;
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
