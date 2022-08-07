public class RandomWalker {
    public static void main(String[] args) {
        int d = Integer.parseInt(args[0]);
        int we = 0;
        int sn = 0;
        int count = 0;
        while (Math.abs(we) + Math.abs(sn) < d) {
            System.out.println("(" + we + ", " + sn + ")");
            double r = Math.random();
            if (r < 0.25) we = we + 1;
            else {
                if (r < 0.5) we = we - 1;
                else {
                    if (r < 0.75) sn = sn + 1;
                    else sn = sn - 1;
                }
            }
            count += 1;
        }
        System.out.println("(" + we + ", " + sn + ")");
        System.out.println("steps = " + count);

    }
}
