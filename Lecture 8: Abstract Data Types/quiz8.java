public class quiz8 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1 + string2);

        String example = "abcdabcdeabcd";
        String s = example.substring(1, 4);
        String t = example.substring(5, 8);
        StdOut.println(s.equals(t));
        StdOut.println(s == t);
        StdOut.println(s.length() == t.length());
    }
}
