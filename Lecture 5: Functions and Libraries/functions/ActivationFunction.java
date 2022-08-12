public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double t = Double.NaN;
        if (x < Math.abs(x)) t = 0;
        else if (x + Math.abs(x) == 0) t = 0.5;
        else if (x > 0) t = 1;
        return t;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        return 1/(1+ Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) return 1.0;
        if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) return -1.0;
        return (Math.exp(x) - Math.exp(-x))/(Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY) return 1.0;
        if (x == Double.NEGATIVE_INFINITY) return -1.0;
        return x/(1+ Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        double t = Double.NaN;
        if (x <= -2) t = -1;
        else if (x < 0) t = x + Math.pow(x, 2)/4;
        else if (x < 2) t = x - Math.pow(x, 2)/4;
        else if (x >= 2) t = 1;
        return t;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside("+x+") = "+heaviside(x));
        StdOut.println("sigmoid("+x+") = "+sigmoid(x));
        StdOut.println("tanh("+x+") = "+tanh(x));
        StdOut.println("softsign("+x+") = "+softsign(x));
        StdOut.println("sqnl("+x+") = "+sqnl(x));
    }
}
