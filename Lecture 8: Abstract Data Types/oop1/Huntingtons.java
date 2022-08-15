public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int i = 0;
        while (i < dna.length()-3) {
            int recorder = 0;
            String codon = dna.substring(i, i+3);
            while (codon.equals("CAG")) {
                recorder++;
                StdOut.println(i);
                count = Math.max(count, recorder);
                i += 3;
                if (i+2 < dna.length()) codon = dna.substring(i, i+3);
                else break;
            }
            i++;
        }
        return count;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String t = s.replaceAll(" ", "");
        String v = t.replaceAll("\n", "");
        String w = v.replaceAll("\t", "");
        return w;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) return "not human";
        else if (maxRepeats < 36) return "normal";
        else if (maxRepeats < 40) return "high risk";
        else if (maxRepeats < 181) return "Huntington's";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String name = args[0];
        In file = new In(name);
        String dna = file.readAll();
        // String dna = StdIn.readAll();
        int max = maxRepeats(removeWhitespace(dna));
        StdOut.println("max repeats = "+ max);
        StdOut.print(diagnose(max));
    }
}
