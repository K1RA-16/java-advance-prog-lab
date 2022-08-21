import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.*;

public class part_a {
    static int find(int[] arr, int k, int l, int r, int a) {
        if (l > r) {
            return -1;
        } else {
            int mid = l + (r - l) / 2;
            a++;
            if (arr[mid] == k) {
                return a;
            }
            if (arr[mid] > k) {
                return find(arr, k, l, mid - 1, a);
            } else {
                return find(arr, k, mid + 1, r, a);
            }

        }
    }

    static String getPath() {
        String path = "";
        Scanner s = new Scanner(System.in);
        System.out.println("enter path of the input file");
        path = s.nextLine();
        return path;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = getPath();
        try {
            String inputPath = path + ".inp";
            String outputPath = path + ".out";
            Scanner sc = new Scanner(new File(inputPath));
            int n = 0; // number of elements
            if (sc.hasNextLine()) {
                n = sc.nextInt();
            }
            int[] arr;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (sc.hasNextInt()) {
                    arr[i] = sc.nextInt();
                } else {
                    break;
                }

            }
            int k;
            k = sc.nextInt();
            int a = find(arr, k, 0, n - 1, 0);
            StringBuffer buffer = new StringBuffer();
            buffer.append(a);
            String fileContents = buffer.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
            writer.write(fileContents);
            writer.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}