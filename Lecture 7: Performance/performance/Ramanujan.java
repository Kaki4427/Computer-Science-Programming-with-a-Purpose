public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n){
        int count = 0;

        for (long a = 1; a < Math.cbrt(n/2); a++) {
            long a3 =  a * a * a;
            long b = (long) Math.cbrt(n - a3);
            if (a3 + b * b * b == n) {
                count++;
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
