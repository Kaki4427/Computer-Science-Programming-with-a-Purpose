public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {

        long[][] coe = new long[n+1][2*n+1];
        // When n is 0
        coe[0][0] = 1;

        for (int i = 1; i < n+1; i++) {
            coe[i][0] = 1;
            coe[i][1] = coe[i-1][0] + coe[i-1][1];
        }

        if (n > 0) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 2; j < 2 * n + 1; j++) {
                    coe[i][j] = coe[i-1][j-2] + coe[i-1][j-1] + coe[i-1][j];
                }
            }
        }

        if (k < -n || k > n) return 0;
        else return coe[n][n+k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
