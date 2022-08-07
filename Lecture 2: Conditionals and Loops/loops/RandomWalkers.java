public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trial = Integer.parseInt(args[1]);
        int t = 0;
        double sum = 0;
        while (t < trial) {
            int we = 0;
            int sn = 0;
            double count = 0;
            while (Math.abs(we) + Math.abs(sn) < r) {
                double rand = Math.random();
                if (rand < 0.25) we = we + 1;
                else {
                    if (rand < 0.5) we = we - 1;
                    else {
                        if (rand < 0.75) sn = sn + 1;
                        else sn = sn - 1;
                    }
                }
                count += 1;
            }
            sum = sum + count;
            t = t + 1;
        }
        System.out.println("average number of steps = " + sum / trial);
    }
}
