import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        int[][] kernel = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int width = picture.width();
        int height = picture.height();

        int[][] r = new int[width][height];
        int[][] g = new int[width][height];
        int[][] b = new int[width][height];
        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                Color c = picture.get(col, row);
                r[col][row] = c.getRed();
                g[col][row] = c.getGreen();
                b[col][row] = c.getBlue();
            }

        Picture target = new Picture(width, height);
        for (int col = 1; col < width-1; col++) {
            for (int row = 1; row < height-1; row++) {
                int red = kernel[0][0] * r[col - 1][row - 1] + kernel[0][1] * r[col - 1][row] + kernel[0][2] * r[col - 1][row + 1] +
                        kernel[1][0] * r[col][row - 1] + kernel[1][1] * r[col][row] + kernel[1][2] * r[col][row + 1] +
                        kernel[2][0] * r[col + 1][row - 1] + kernel[2][1] * r[col + 1][row] + kernel[2][2] * r[col + 1][row + 1];
                int green = kernel[0][0] * g[col - 1][row - 1] + kernel[0][1] * g[col - 1][row] + kernel[0][2] * g[col - 1][row + 1] +
                        kernel[1][0] * g[col][row - 1] + kernel[1][1] * g[col][row] + kernel[1][2] * g[col][row + 1] +
                        kernel[2][0] * g[col + 1][row - 1] + kernel[2][1] * g[col + 1][row] + kernel[2][2] * g[col + 1][row + 1];
                int blue = kernel[0][0] * b[col - 1][row - 1] + kernel[0][1] * b[col - 1][row] + kernel[0][2] * b[col - 1][row + 1] +
                        kernel[1][0] * b[col][row - 1] + kernel[1][1] * b[col][row] + kernel[1][2] * b[col][row + 1] +
                        kernel[2][0] * b[col + 1][row - 1] + kernel[2][1] * b[col + 1][row] + kernel[2][2] * b[col + 1][row + 1];
                red = Math.max(0, red);
                red = Math.min(255, red);
                green = Math.max(0, red);
                green = Math.min(255, green);
                blue = Math.max(0, red);
                blue = Math.min(255, blue);
                Color nc = new Color(red, green, blue);
                target.set(col, row, nc);
            }
        }
        target.show();
        return target;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
//    public static Picture gaussian(Picture picture) {
//        int[][] kernel = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//    }

    // Returns a new picture that applies a sharpen filter to the given picture.
//    public static Picture sharpen(Picture picture) {
//        int[][] kernel = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
//    public static Picture laplacian(Picture picture) {
//        int[][] kernel = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//    }

    // Returns a new picture that applies an emboss filter to the given picture.
//    public static Picture emboss(Picture picture) {
//        int[][] kernel = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//    }

    // Returns a new picture that applies a motion blur filter to the given picture.
//    public static Picture motionBlur(Picture picture) {
//    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        identity(source);
        // gaussian(source);
        // sharpen(source);
        // laplacian(source);
        // emboss(source);
        // motionBlur(source);
    }

}
