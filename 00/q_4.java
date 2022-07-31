import java.util.*;

class q_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range of the numbers");
        int lo = sc.nextInt();
        int hi = sc.nextInt();
        input(sc, lo, hi);

    }

    private static void input(Scanner sc, int lo, int hi) {
        System.out.println("player No. 1 - Enter the number");
        int n1 = sc.nextInt();

        if (n1 >= lo && n1 <= hi) {
            matchNumber(sc, n1, 0);

        } else {
            System.out.println("PLayer No. 1 - Please enter a valid number !!!");
            System.out.println();
            input(sc, lo, hi);
        }
    }

    private static void matchNumber(Scanner sc, int n1, int a) {
        int n2;
        System.out.println("player No. 2 - Guess the number");
        n2 = sc.nextInt();
        a++;
        if (n1 == n2) {
            System.out.println("Player No. 2 has guessed the number in " + a + " tries");
            return;
        } else if (n2 > n1) {
            System.out.println("Guess lower");
            matchNumber(sc, n1, a);
        } else if (n2 < n1) {
            System.out.println("Guess higher");
            matchNumber(sc, n1, a);
        }
    }
}
