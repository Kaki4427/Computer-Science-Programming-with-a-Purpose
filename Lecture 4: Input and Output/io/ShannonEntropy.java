public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] count = new int[m];
        int sum = 0;
        while (!StdIn.isEmpty()) {
            int ni = StdIn.readInt();
            count[ni-1]++;
            sum ++;
        }
        double H = 0;
        for (int i = 0; i < m; i++) {
            double p = (double) count[i]/sum;
            if (p != 0) H += -(p* Math.log(p) / Math.log(2));
        }
        String s=String.format("%.4f", H);
        System.out.println(s);
    }
}
