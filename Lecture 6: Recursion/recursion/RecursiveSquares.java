public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length/2);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length/2);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        double nl = length/2;
        double x0 = x - nl, x1 = x + nl;
        double y0 = y - nl, y1 = y + nl;
        draw(n-1, x0, y1, nl);
        draw(n-1, x1, y1, nl);
        drawSquare(x, y, length);
        draw(n-1, x0, y0, nl);
        draw(n-1, x1, y0, nl);
    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
