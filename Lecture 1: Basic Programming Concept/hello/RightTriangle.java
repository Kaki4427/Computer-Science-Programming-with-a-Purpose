public class RightTriangle {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        boolean right = a > 0 && b > 0 && c > 0;
        right = right && (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a);
        System.out.println(right);
    }
}
