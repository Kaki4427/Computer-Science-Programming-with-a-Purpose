public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) inversions++;
            }
        }
        return inversions;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] permutation = new int[n];

        int locate = n-1;
        while (k > 0) {
            if (locate <= k) {
                permutation[n - 1 - locate] = locate;
                k = k - locate;
            }
            else {
                permutation[n - 1 - (int) k] = locate;
                k = k - k;
            }
            locate--;
        }

        for (int i = n-1; i >= 0; i--) {
            if (!(permutation[i] > 0)) {
                permutation[i] = locate;
                locate--;
            }
        }

        return permutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] permutation = generate(n, k);
        for (int i = 0; i < n; i++) {
            StdOut.print(permutation[i]+" ");
        }
    }
}
