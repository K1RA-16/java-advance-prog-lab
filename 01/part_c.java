import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.*;

public class part_c {
    static BigInteger chessGrains(int n) {
        BigInteger curr = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger multiple = BigInteger.valueOf(2);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum = sum.add(curr);
                curr = curr.multiply(multiple);
            }
        }
        return sum;
    }

    static String getPath() {
        String path = "";
        Scanner s = new Scanner(System.in);
        System.out.println("enter path of the input file");
        path = s.nextLine();
        return path;
    }

    public static void main(String[] args) {
        String path = getPath();
        try {
            String inputPath = path + ".inp";
            String outputPath = path + ".out";
            Scanner sc = new Scanner(new File(inputPath));
            int n = 0; // number of elements
            if (sc.hasNextLine()) {
                n = sc.nextInt();
            }
            BigInteger ans = chessGrains(n);
            StringBuffer buffer = new StringBuffer();
            buffer.append(ans);
            String fileContents = buffer.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
            writer.write(fileContents);
            writer.flush();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
