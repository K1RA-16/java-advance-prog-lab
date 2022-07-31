import java.util.*;

//the person who picks the last stick wins
class q_3 {
    static int sticks = 0,
            userPoint = 0, computerPoint = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char c = 'N';
        do {
            sticks = 15;
            if (sticks == 0) {
                return;
            }
            System.out.println(sticks);
            initialise(scn);
            System.out.println("Do you want to quit? - Y OR N");
            c = scn.next().charAt(0);
        } while (c != 'Y');
    }

    private static void initialise(Scanner scn) {
        int turn = 0; // 1 for user's turn, 0 for computer's turn
        int n = 0;
        while (sticks != 0) {
            // System.out.println("Remaining Sticks: " + sticks);//displays the remaining
            // sticks / use for debugging

            if (turn == 1) {
                n = 0;
                n = userStick(scn);
                turn = 0;
            } else {
                n = computerStick(scn, n);
                turn = 1;
            }
            sticks -= n;
        }
        if (turn == 1) {
            System.out.print("computer wins this round");
            computerPoint += 5;
            userPoint -= 5;
        } else {
            System.out.print("YOU win this round");
            computerPoint -= 5;
            userPoint += 5;
        }
        System.out.println();
        System.out.println("your points: " + userPoint);
        System.out.println(
                "Computer's points: " + computerPoint);
    }

    private static int computerStick(Scanner scn, int n2) {
        int n = 2;
        if (n2 != 0) {
            n = 4 - n2;
        }
        System.out.println("sticks picked by computer - " + n);
        return n;
    }

    private static int userStick(Scanner scn) {
        System.out.println("Pick the number of sticks between 1 and 3");
        int n = scn.nextInt();
        if (n > sticks || n > 3 || n < 1) {
            System.out.println("Pick a valid number of sticks");
            return userStick(scn);
        }
        return n;
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}