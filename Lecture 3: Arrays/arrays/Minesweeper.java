public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] mine = new int[m][n];
        for (int i =0; i < k; i++) {
            int a = (int) (Math.random() * m);
            int b = (int) (Math.random() * n);
            while (mine[a][b] >8) {
                a = (int) (Math.random() * m);
                b = (int) (Math.random() * n);
            }
            mine[a][b] = 9;
            if (a-1>=0 && b-1>=0) mine[a-1][b-1]++;
            if (a-1>=0) mine[a-1][b]++;
            if (a-1>=0 && b+1<=n-1) mine[a-1][b+1]++;
            if (b-1>=0) mine[a][b-1]++;
            if (b+1<=n-1) mine[a][b+1]++;
            if (a+1<=m-1 && b-1>=0) mine[a+1][b-1]++;
            if (a+1<=m-1) mine[a+1][b]++;
            if (a+1<=m-1 && b+1<=n-1) mine[a+1][b+1]++;
        }

        for (int i =0; i < m; i++) {
            for (int j =0; j < n; j++) {
                if (mine[i][j] < 9) {
                    System.out.print(mine[i][j] + "  ");
                }
                else System.out.print("*  ");
            }
            System.out.println();
        }
    }
}
