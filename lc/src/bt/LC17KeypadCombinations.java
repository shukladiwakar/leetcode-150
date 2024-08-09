package bt;

import java.util.*;
import java.util.stream.Collectors;

public class LC17KeypadCombinations {


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, res, new ArrayList<>(), 0);
        return res;
    }

    public static void dfs(String digits, List<String> res, List<String> path, int startIndex) {

        if (startIndex == digits.length()) {
            res.add(path.stream().map(e -> e.toString()).collect(Collectors.joining()));
        }
        List<Character> options = characterList(Integer.parseInt(String.valueOf(digits.charAt(startIndex))));
        for (char option : options) {
            path.add(String.valueOf(option));
            dfs(digits, res, path, startIndex + 1);

            path.remove(startIndex);
        }
    }

    public static List<Character> characterList(int value) {
        Map<Integer, List<Character>> listMap = new HashMap<>();
        listMap.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        listMap.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        listMap.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        listMap.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        listMap.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        listMap.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        listMap.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        listMap.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        return listMap.get(value);
    }
}
