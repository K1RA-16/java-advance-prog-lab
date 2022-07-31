import java.util.*;

//the person who picks the last stick wins
class q_1 {
    static int sticks = 0,
            userPoint = 0, computerPoint = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char c = 'N';
        do {
            sticks = getRandomNumberUsingInts(39, 81);
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
        System.out.println("Do you want to play first - Y OR N");
        char c = scn.next().charAt(0);

        int turn = 0; // 1 for user's turn, 0 for computer's turn
        if (c == 'Y') {
            turn = 1;
        }
        while (sticks != 0) {
            // System.out.println("Remaining Sticks: " + sticks);//displays the remaining
            // sticks / use for debugging

            int n;
            if (turn == 1) {
                n = userStick(scn);
                turn = 0;
            } else {
                n = computerStick(scn);
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

    private static int computerStick(Scanner scn) {
        int n = getRandomNumberUsingInts(1, 3);
        if (n > sticks) {
            return computerStick(scn);
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