public class ColorHSB {
    private final int hue, saturation, brightness;
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100 ) {
            throw new IllegalArgumentException("Bad Parameter!");
        }
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (saturation == 0 || brightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("No Argument!");
        }
        return (int) (Math.min(Math.pow((hue - that.hue), 2), Math.pow(360-Math.abs(hue - that.hue), 2)) +
                Math.pow((saturation - that.saturation), 2) + Math.pow((brightness - that.brightness), 2));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB original = new ColorHSB(h, s, b);
        String result = "";
        int dis_near = 360*360;
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int nh = StdIn.readInt();
            int ns = StdIn.readInt();
            int nb = StdIn.readInt();
            ColorHSB pre = new ColorHSB(nh, ns, nb);
            if (original.distanceSquaredTo(pre) < dis_near) {
                dis_near = original.distanceSquaredTo(pre);
                result = name + " " + pre.toString();
            }
        }
        StdOut.println(result);
    }

}
