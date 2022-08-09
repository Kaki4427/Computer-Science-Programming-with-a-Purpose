public class DiscreteDistribution {
    public static void main(String[] args) {
        int[] a = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }

        int m = a[0];
        int[] S = new int[a.length];
        S[0] = 0;
        for (int i = 1; i < a.length; i++) {
            S[i] = S[i-1] + a[i];
        }

        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * S[a.length - 1]);
            for (int j = 1; j < a.length; j++) {
                if (r >= S[j-1] && r < S[j]) result[i] = j;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
