package array;

public class LC151ReverseWords {

    public static void main(String[] args) {
        String s1 = "  hello world  ";
        reverseWords(s1);
    }

    public static String reverseWords(String s) {
        String s1[] = s.split(" ");

        String op = "";

        for (int i = s1.length - 1; i >= 0; i--) {
            if (!(s1[i].equalsIgnoreCase(" ") || s1[i].isEmpty())){
                op = op.concat(s1[i]).concat(" ");
            }
        }

        return op.substring(0, op.length() - 1);
    }
}
