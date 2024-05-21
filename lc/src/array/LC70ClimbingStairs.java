package array;

public class LC70ClimbingStairs {


    public int climbStairs(int n) {
        int op[] = new int[n + 1];

        op[0] = 1;
        op[1] = 1;
        int currI = op[0];
        int nextI = op[1];

        for (int i = 2; i <= n; i++) {
            op[i] = nextI + currI;
            currI = nextI;
            nextI = op[i];
        }

        return op[n];
    }
}
