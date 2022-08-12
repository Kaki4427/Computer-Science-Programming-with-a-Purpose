public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                int ic = i%2;
                int jc = j%2;
                double a = (double) i;
                double b = (double) j;
                if (ic == jc) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(a+0.5, b+0.5, 0.5);
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(a+0.5, b+0.5, 0.5);
                }
            }
        }
    }
}
