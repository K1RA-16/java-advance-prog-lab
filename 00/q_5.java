import java.util.*;

public class q_5 {
    static int n1 = 0, n2 = 1, n3 = 0;

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.print(n1 + " " + n2);// printing 0 and 1
        iteration(n);// iterative
        for (int i = 0; i < n; i++) {
            System.out.print(recursion(i) + " ");// recursive
        }
    }

    static void iteration(int count) {
        int i;
        for (i = 2; i < count; ++i)// loop starts from 2 because 0 and 1 are already printed
        {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }

    static int recursion(int n) {
        if (n <= 1)
            return n;
        return recursion(n - 1)
                + recursion(n - 2);
    }
}
