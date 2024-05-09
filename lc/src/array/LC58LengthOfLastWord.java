package array;

public class LC58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }
}
