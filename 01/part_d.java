
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

class part_d {
    static void whileLoop(StringBuffer buffer, String path) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("include")) {
                    addStringFromExternal(buffer, line);
                    continue;
                }
                if (line.isEmpty())
                    continue;
                line = line.trim();
                if (line.contains("/*")) {
                    try {
                        while (!line.contains("*/")) {
                            line = sc.nextLine();
                        }
                        continue;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                if (line.contains("//"))
                    continue;
                buffer.append(line + "\n");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void addStringFromExternal(StringBuffer buffer, String line) throws FileNotFoundException {
        try {
            String path = line.substring(10, line.length() - 1);
            whileLoop(buffer, path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            String path = "main.c";
            StringBuffer buffer = new StringBuffer();
            whileLoop(buffer, path);
            String fileContents = buffer.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter("part_d_output.c"));
            writer.write(fileContents);
            writer.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
