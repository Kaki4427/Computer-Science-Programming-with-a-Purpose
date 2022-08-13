public class quiz6 {
    public static int Q2(int n)
    {
        if (n <= 0) return 1;
        return 1 + Q2(n-2) + Q2(n-3);
    }

    public static void Q3(int n)
    {
        if (n <= 0) return;
        StdOut.println(n);
        Q3(n-2);
        Q3(n-3);
        StdOut.println(n);
    }

    public static void Q4(int n)
    {
        if (n <= 0) return;
        StdOut.println(n);
        Q4(n-2);
        Q4(n-3);
        StdOut.println(n);
    }

    public static int Q5(int n)
    {
        int[] b = new int[n+1];
        b[0] = 1;
        for (int i = 2;	i <=n; i++)
        {
            b[i] = 0;
            for	(int j = 0; j <	i; j++)
                b[i] += b[j];
        }
        return b[n];
    }

    public static void main(String[] args) {
        StdOut.println("Answer of Q2:"+ Q2(6));
        StdOut.println("Answer of Q3:");
        Q3(6);
        StdOut.println("Answer of Q4:");
        Q4(7);
        StdOut.println("Answer of Q5:"+ Q5(8));
    }
}

