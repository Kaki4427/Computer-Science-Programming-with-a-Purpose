public class RevesPuzzle {
    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }
    private static void rev(int n, String from, String temp, String to, String temp2) {
        int k = (int) (n + 1 - Math.round(Math.sqrt(2 * n + 1)));
        if (k == 0){
            StdOut.println("Move disc " + 1  + " from " + from + " to " + to);
            return;
        }
        rev(k, from , to, temp , temp2);
        hanoi(n-k, k, from, temp2, to);
        rev(k, temp, from, to, temp2);
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        rev(n, "A", "B", "D", "C");
    }
}
