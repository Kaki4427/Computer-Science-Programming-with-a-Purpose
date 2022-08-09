//t[0] = 0, t[2n] = t[n], t[2n+1] = 1-t[n]
public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        a[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i%2 == 0) a[i] = a[i/2];
            else a[i] = 1-a[(i-1)/2];
        }

        String[][] pattern = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) pattern[i][j] = "+  ";
                else pattern[i][j] = "-  ";
                System.out.print(pattern[i][j]);
            }
            System.out.println();
        }
    }
}
