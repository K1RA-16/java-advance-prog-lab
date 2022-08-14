import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
class part_d
{
    public static void main(String[] args) throws Exception
    {   
        String filePath = "example.c";
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.isEmpty()) continue;
            line = line.trim();
            if(line.contains("//")) continue;
            buffer.append(line+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        sc.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("example.c"));
        writer.write(fileContents);
        writer.flush();
    }
}
