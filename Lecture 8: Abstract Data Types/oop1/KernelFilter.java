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
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int fc = col-1;
                int tc = col+1;
                int fr = row-1;
                int tr = row+1;
                if (fc < 0) fc = width-1;
                if (tc == width) tc = 0;
                if (fr < 0) fr = height-1;
                if (tr == height) tr = 0;
                int red = kernel[0][0]*r[fc][fr] + kernel[1][0]*r[fc][row] + kernel[2][0]*r[fc][tr] +
                        kernel[0][1]*r[col][fr] + kernel[1][1]*r[col][row] + kernel[2][1]*r[col][tr] +
                        kernel[0][2]*r[tc][fr] + kernel[1][2]*r[tc][row] + kernel[2][2]*r[tc][tr];
                int green = kernel[0][0]*g[fc][fr] + kernel[1][0]*g[fc][row] + kernel[2][0]*g[fc][tr] +
                        kernel[0][1]*g[col][fr] + kernel[1][1]*g[col][row] + kernel[2][1]*g[col][tr] +
                        kernel[0][2]*g[tc][fr] + kernel[1][2]*g[tc][row] + kernel[2][2]*g[tc][tr];
                int blue = kernel[0][0]*b[fc][fr] + kernel[1][0]*b[fc][row] + kernel[2][0]*b[fc][tr] +
                        kernel[0][1]*b[col][fr] + kernel[1][1]*b[col][row] + kernel[2][1]*b[col][tr] +
                        kernel[0][2]*b[tc][fr] + kernel[1][2]*b[tc][row] + kernel[2][2]*b[tc][tr];
                red = Math.max(0, red);
                red = Math.min(255, red);
                green = Math.max(0, green);
                green = Math.min(255, green);
                blue = Math.max(0, blue);
                blue = Math.min(255, blue);
                Color nc = new Color(red, green, blue);
                target.set(col, row, nc);
            }
        }
        target.show();
        return target;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = {{1.0/16.0, 2.0/16.0, 1.0/16.0}, {2.0/16.0, 4.0/16.0, 2.0/16.0}, {1.0/16.0, 2.0/16.0, 1.0/16.0}};
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
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int fc = col-1;
                int tc = col+1;
                int fr = row-1;
                int tr = row+1;
                if (fc < 0) fc = width-1;
                if (tc == width) tc = 0;
                if (fr < 0) fr = height-1;
                if (tr == height) tr = 0;
                double red = kernel[0][0]*r[fc][fr] + kernel[1][0]*r[fc][row] + kernel[2][0]*r[fc][tr] +
                        kernel[0][1]*r[col][fr] + kernel[1][1]*r[col][row] + kernel[2][1]*r[col][tr] +
                        kernel[0][2]*r[tc][fr] + kernel[1][2]*r[tc][row] + kernel[2][2]*r[tc][tr];
                double green = kernel[0][0]*g[fc][fr] + kernel[1][0]*g[fc][row] + kernel[2][0]*g[fc][tr] +
                        kernel[0][1]*g[col][fr] + kernel[1][1]*g[col][row] + kernel[2][1]*g[col][tr] +
                        kernel[0][2]*g[tc][fr] + kernel[1][2]*g[tc][row] + kernel[2][2]*g[tc][tr];
                double blue = kernel[0][0]*b[fc][fr] + kernel[1][0]*b[fc][row] + kernel[2][0]*b[fc][tr] +
                        kernel[0][1]*b[col][fr] + kernel[1][1]*b[col][row] + kernel[2][1]*b[col][tr] +
                        kernel[0][2]*b[tc][fr] + kernel[1][2]*b[tc][row] + kernel[2][2]*b[tc][tr];
                red = Math.max(0, red);
                int R = Math.min(255, (int) Math.round(red));
                green = Math.max(0, green);
                int G = Math.min(255, (int) Math.round(green));
                blue = Math.max(0, blue);
                int B = Math.min(255, (int) Math.round(blue));
                Color nc = new Color(R, G, B);
                target.set(col, row, nc);
            }
        }
        target.show();
        return target;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int[][] kernel = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
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
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int fc = col-1;
                int tc = col+1;
                int fr = row-1;
                int tr = row+1;
                if (fc < 0) fc = width-1;
                if (tc == width) tc = 0;
                if (fr < 0) fr = height-1;
                if (tr == height) tr = 0;
                int red = kernel[0][0]*r[fc][fr] + kernel[1][0]*r[fc][row] + kernel[2][0]*r[fc][tr] +
                        kernel[0][1]*r[col][fr] + kernel[1][1]*r[col][row] + kernel[2][1]*r[col][tr] +
                        kernel[0][2]*r[tc][fr] + kernel[1][2]*r[tc][row] + kernel[2][2]*r[tc][tr];
                int green = kernel[0][0]*g[fc][fr] + kernel[1][0]*g[fc][row] + kernel[2][0]*g[fc][tr] +
                        kernel[0][1]*g[col][fr] + kernel[1][1]*g[col][row] + kernel[2][1]*g[col][tr] +
                        kernel[0][2]*g[tc][fr] + kernel[1][2]*g[tc][row] + kernel[2][2]*g[tc][tr];
                int blue = kernel[0][0]*b[fc][fr] + kernel[1][0]*b[fc][row] + kernel[2][0]*b[fc][tr] +
                        kernel[0][1]*b[col][fr] + kernel[1][1]*b[col][row] + kernel[2][1]*b[col][tr] +
                        kernel[0][2]*b[tc][fr] + kernel[1][2]*b[tc][row] + kernel[2][2]*b[tc][tr];
                red = Math.max(0, red);
                red = Math.min(255, red);
                green = Math.max(0, green);
                green = Math.min(255, green);
                blue = Math.max(0, blue);
                blue = Math.min(255, blue);
                Color nc = new Color(red, green, blue);
                target.set(col, row, nc);
            }
        }
        target.show();
        return target;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int[][] kernel = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
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
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int fc = col-1;
                int tc = col+1;
                int fr = row-1;
                int tr = row+1;
                if (fc < 0) fc = width-1;
                if (tc == width) tc = 0;
                if (fr < 0) fr = height-1;
                if (tr == height) tr = 0;
                int red = kernel[0][0]*r[fc][fr] + kernel[1][0]*r[fc][row] + kernel[2][0]*r[fc][tr] +
                        kernel[0][1]*r[col][fr] + kernel[1][1]*r[col][row] + kernel[2][1]*r[col][tr] +
                        kernel[0][2]*r[tc][fr] + kernel[1][2]*r[tc][row] + kernel[2][2]*r[tc][tr];
                int green = kernel[0][0]*g[fc][fr] + kernel[1][0]*g[fc][row] + kernel[2][0]*g[fc][tr] +
                        kernel[0][1]*g[col][fr] + kernel[1][1]*g[col][row] + kernel[2][1]*g[col][tr] +
                        kernel[0][2]*g[tc][fr] + kernel[1][2]*g[tc][row] + kernel[2][2]*g[tc][tr];
                int blue = kernel[0][0]*b[fc][fr] + kernel[1][0]*b[fc][row] + kernel[2][0]*b[fc][tr] +
                        kernel[0][1]*b[col][fr] + kernel[1][1]*b[col][row] + kernel[2][1]*b[col][tr] +
                        kernel[0][2]*b[tc][fr] + kernel[1][2]*b[tc][row] + kernel[2][2]*b[tc][tr];
                red = Math.max(0, red);
                red = Math.min(255, red);
                green = Math.max(0, green);
                green = Math.min(255, green);
                blue = Math.max(0, blue);
                blue = Math.min(255, blue);
                Color nc = new Color(red, green, blue);
                target.set(col, row, nc);
            }
        }
        target.show();
        return target;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int[][] kernel = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
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
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int fc = col-1;
                int tc = col+1;
                int fr = row-1;
                int tr = row+1;
                if (fc < 0) fc = width-1;
                if (tc == width) tc = 0;
                if (fr < 0) fr = height-1;
                if (tr == height) tr = 0;
                int red = kernel[0][0]*r[fc][fr] + kernel[1][0]*r[fc][row] + kernel[2][0]*r[fc][tr] +
                        kernel[0][1]*r[col][fr] + kernel[1][1]*r[col][row] + kernel[2][1]*r[col][tr] +
                        kernel[0][2]*r[tc][fr] + kernel[1][2]*r[tc][row] + kernel[2][2]*r[tc][tr];
                int green = kernel[0][0]*g[fc][fr] + kernel[1][0]*g[fc][row] + kernel[2][0]*g[fc][tr] +
                        kernel[0][1]*g[col][fr] + kernel[1][1]*g[col][row] + kernel[2][1]*g[col][tr] +
                        kernel[0][2]*g[tc][fr] + kernel[1][2]*g[tc][row] + kernel[2][2]*g[tc][tr];
                int blue = kernel[0][0]*b[fc][fr] + kernel[1][0]*b[fc][row] + kernel[2][0]*b[fc][tr] +
                        kernel[0][1]*b[col][fr] + kernel[1][1]*b[col][row] + kernel[2][1]*b[col][tr] +
                        kernel[0][2]*b[tc][fr] + kernel[1][2]*b[tc][row] + kernel[2][2]*b[tc][tr];
                red = Math.max(0, red);
                red = Math.min(255, red);
                green = Math.max(0, green);
                green = Math.min(255, green);
                blue = Math.max(0, blue);
                blue = Math.min(255, blue);
                Color nc = new Color(red, green, blue);
                target.set(col, row, nc);
            }
        }
        target.show();
        return target;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            weights[i][i] = 1.0 / 9.0;
        }
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rnew = 0.0;
        double gnew = 0.0;
        double bnew = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                for (int i = -4; i < 5; i++) {
                    for (int j = -4; j < 5; j++) {
                        Color color = picture.get((w + col + i) % w, (h + row + j) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        rnew += r * weights[i + 4][j + 4];
                        gnew += g * weights[i + 4][j + 4];
                        bnew += b * weights[i + 4][j + 4];
                    }
                }
                int R = (int) Math.round(rnew);
                int G = (int) Math.round(gnew);
                int B = (int) Math.round(bnew);
                if (R > 255) R = 255;
                if (G > 255) G = 255;
                if (B > 255) B = 255;
                if (R < 0) R = 0;
                if (G < 0) G = 0;
                if (B < 0) B = 0;
                Color newcolor = new Color(R, G, B);
                target.set(col, row, newcolor);
                rnew = 0.0;
                gnew = 0.0;
                bnew = 0.0;
            }
        }
        target.show();
        return target;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        identity(source);
        gaussian(source);
        sharpen(source);
        laplacian(source);
        emboss(source);
        motionBlur(source);
    }

}
