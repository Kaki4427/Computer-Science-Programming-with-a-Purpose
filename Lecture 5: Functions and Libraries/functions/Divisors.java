public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int pa = Math.abs(a);
        int pb = Math.abs(b);
        int c = 0;
        if (pa < pb) {
            c = pa;
            pa = pb;
            pb = c;
        }
        if (a == 0 && b == 0) return 0;
        while (pb != 0) {
            c = pa;
            pa = pb;
            pb = c%pb;
        }
        return pa;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 && b == 0) return 0;
        int pa = Math.abs(a);
        int pb = Math.abs(b);
        int c = 0;
        if (pa < pb) {
            c = pa;
            pa = pb;
            pb = c;
        }
        return pa/gcd(a, b)*pb;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        int cd = gcd(a, b);
        if (cd == 1) return true;
        else return false;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0) return 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (areRelativelyPrime(i, n)) count++;
        }
        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a +") = " + totient(a));
        StdOut.println("totient(" + b +") = " + totient(b));
    }
}
