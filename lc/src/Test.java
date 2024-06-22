import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

    }

    public boolean hasSameDigits(int digit1, int digit2) {
        // 43321312 -"433213125"
        // 23131234 -"23131234"

        String s1 = String.valueOf(digit1);
        String s2 = String.valueOf(digit2);
        int[] digit1arr = new int[10];
        int[] digit2arr = new int[10];
        Arrays.fill(digit1arr, 0);
        Arrays.fill(digit2arr, 0);
//O(n)
        // n - maxdig(d1,d2)
        for (int i = 0; i < s1.length(); i++) {
            int d1 = Integer.parseInt(s1.charAt(i) + "");
            digit1arr[d1] = 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            int d2 = Integer.parseInt(s2.charAt(i) + "");
            digit2arr[d2] = 1;
        }
        for (int i = 0; i < 10; i++) {
            if (digit1arr[i] + digit2arr[i] == 1) {
                return false;
            }
        }

        return true;
    }
}
