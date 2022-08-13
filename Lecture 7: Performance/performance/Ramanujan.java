public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n){
        int count = 0;

        for (long i = 1; (long) Math.pow(i, 3) < n/2; i++) {
            for (long j = i+1; (long) Math.pow(j, 3) < n; j++) {
                if ((long) Math.pow(i, 3) + (long) Math.pow(j, 3) == n) count++;
                if (count > 1) return true;
            }
        }
        return false;
    }


    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.print(isRamanujan(n));
    }
}
