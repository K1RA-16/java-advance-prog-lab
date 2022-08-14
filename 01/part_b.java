import java.util.*;
public class part_b {
    static int findIndex(int n){
        int i = n % 8;
        if (i == 0)
            return 2;
        if (i < 5)
            return i;
        else
            return 10 - i;
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();
        String[] arr = {"thumb","index","middle","ring","little"};
        int i = findIndex(n);
        System.out.println(arr[i-1]);
        

    }
}
