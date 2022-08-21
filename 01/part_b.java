import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class part_b {
    static int findIndex(int n) {
        int i = n % 8;
        if (i == 0)
            return 2;
        if (i < 5)
            return i;
        else
            return 10 - i;
    }

    static String getPath() {
        String path = "";
        Scanner s = new Scanner(System.in);
        System.out.println("enter path of the input file");
        path = s.nextLine();
        return path;
    }

    public static void main(String[] args) throws Exception {
        String path = getPath();

        try {
            String inputPath = path + ".inp";
            String outputPath = path + ".out";
            Scanner sc = new Scanner(new File(inputPath));
            int n = 0; // number of elements
            if (sc.hasNextLine()) {
                n = sc.nextInt();
            }
            String[] arr = { "thumb", "index", "middle", "ring", "little" };
            int i = findIndex(n);
            StringBuffer buffer = new StringBuffer();
            buffer.append(arr[i - 1]);
            String fileContents = buffer.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
            writer.write(fileContents);
            writer.flush();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
