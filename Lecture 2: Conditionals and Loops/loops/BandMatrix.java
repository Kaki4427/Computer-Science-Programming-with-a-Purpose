public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n - 1; j++) {
                if (Math.abs(i - j) <= width) s = s + "*  ";
                else s = s + "0  ";
            }
            if (Math.abs(i - (n - 1)) <= width) s = s + "*";
            else s = s + "0";
            System.out.println(s);
        }
    }
}
