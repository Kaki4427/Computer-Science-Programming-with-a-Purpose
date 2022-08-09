public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] counts = new int[n];
        int[] sum = new int[n];

        for (int i = 0; i < trials; i++) {
            boolean[] days = new boolean[n];
            int p = 0;
            while (p<n) {
                int r = (int) (Math.random() * (n-1));
                if (days[r]==true) {
                    counts[p]++;
                    break;
                }
                else {
                    p++;
                    days[r]=true;
                }
            }
        }

        int i = 0;
        sum[i] = counts[i];
        System.out.println(i+1 + "\t" + counts[i] + "\t" + (double) sum[i]/trials);
        while  (sum[i] < trials/2) {
            i++;
            sum[i] = sum[i-1] + counts[i];
            System.out.println(i+1 + "\t" + counts[i] + "\t" + (double) sum[i]/trials);
        }
    }
}
