public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double [] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i]*alpha;
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double [] b = new double[a.length];
        for (int i = a.length; i > 0; i--) {
            b[a.length-i] = a[i-1];
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double [] c = new double[a.length+ b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length+i] = b[i];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] c;
        if (a.length < b.length) {
            c = new double[b.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] + b[i];
            }
            for (int i = 0; i < b.length - a.length; i++) {
                c[a.length+i] = b[a.length+i];
            }
        }
        else if (b.length < a.length) {
            c = new double[a.length];
            for (int i = 0; i < b.length; i++) {
                c[i] = a[i] + b[i];
            }
            for (int i = 0; i < a.length - b.length; i++) {
                c[b.length + i] = a[b.length + i];
            }
        }
        else {
            c = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] + b[i];
            }
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
            int items = (int) (a.length/alpha);
            double[] b = new double[items];
            for (int i = 0; i < items; i++) {
                int j = (int) (i*alpha);
                b[i] = a[j];
            }
            return b;
        }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] piano = StdAudio.read("piano.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] music = mix(merge(merge(merge(amplify(piano, 0.8), cow), reverse(harp)), beatbox), changeSpeed(singer, 2));
        StdAudio.play(music);
        StdAudio.close();
    }
}
