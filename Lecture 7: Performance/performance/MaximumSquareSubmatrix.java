public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a){
        int count = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    count = Math.max(count, 1);
                    for (int k = 1; k < n - Math.max(i, j); k++) {
                        if (a[i+k][j+k] == 1) {
                            int[][] b = new int[k+1][k+1];
                            for (int c = 0; c < k+1; c++) {
                                for (int d = 0; d < k+1; d++) {
                                    b[c][d] = a[i+c][j+d];
                                }
                            }
                            if (check(b)) count = Math.max(count, k+1);
                            else break;
                        }
                    }
                }
            }
        }
        return count;
    }

    private static boolean check(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 1) return false;
            }
        }
        return true;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.print(size(a));
    }
}
