import java.math.BigInteger;
import java.util.*;
public class part_c {
    static BigInteger chessGrains(int n)
    {
        BigInteger curr = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger multiple =  BigInteger.valueOf(2);
        
        for (int i = 1; i <= n; i++) {
            for(int j = 1;j<=n;j++) {
                sum = sum.add(curr);
                curr = curr.multiply(multiple);
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();
        BigInteger ans = chessGrains(n); 
        System.out.println(ans);
    }
}
