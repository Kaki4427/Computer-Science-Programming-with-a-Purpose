public class Clock {
    private int hour, minute;
    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Bad Parameter!");
        }
        hour = h;
        minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) {
            throw new IllegalArgumentException("Bad Format!");
        }
        Character s0 = s.charAt(0);
        Character s1 = s.charAt(1);
        char s2 = s.charAt(2);
        Character s3 = s.charAt(3);
        Character s4 = s.charAt(4);
        if (!Character.isDigit(s0) || !Character.isDigit(s1) ||
                !Character.isDigit(s3) || !Character.isDigit(s4) || s2 != ':') {
            throw new IllegalArgumentException("Bad Number!");
        }
        int h = Character.getNumericValue(s0) * 10 + Character.getNumericValue(s1);
        int m = Character.getNumericValue(s3) * 10 + Character.getNumericValue(s4);
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Bad Parameter!");
        }
        hour = h;
        minute = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        if (hour<10 && minute<10) return 0 + "" + hour + ":" + 0 + minute;
        else if (hour<10) return 0 + "" + hour + ":" + minute;
        else if (minute<10) return hour + ":" + 0 + minute;
        else return hour + ":" + minute;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) return true;
        else if (hour == that.hour) {
            if (minute < that.minute) return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minute != 59) minute++;
        else {
            minute = 0;
            if (hour != 23) hour++;
            else {
                hour = 0;
            }
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Should be positive!");
        }
        int day = delta % 1440;
        int deltah = day/60;
        int deltam = day % 60;
        int spare = 0;
        if (minute + deltam <= 59) minute = minute + deltam;
        else {
            minute = (minute + deltam) % 60;
            spare++;
        }
        if (hour + deltah + spare < 24) hour = hour + deltah +spare;
        else hour = (hour + deltah +spare) % 24;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c1 = new Clock(23, 59);
        Clock c2 = new Clock("18:00");
        c1.toc(60);
        c2.tic();
        StdOut.println(c1.toString());
        StdOut.println(c2.toString());
        StdOut.println(c1.isEarlierThan(c2));
    }
}
