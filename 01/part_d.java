import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
class part_d
{
    static void addStringFromExternal(StringBuffer buffer ,String line) throws FileNotFoundException{
        String path = line.substring(10,line.length()-1);
        Scanner sc = new Scanner(new File(path));
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            if(line.contains(".h")) {
                addStringFromExternal(buffer,line);
                continue;
            }
            line = line.trim();
            if(line.contains("/*")){
                while(!line.contains("*/")) sc.nextLine();
                sc.nextLine();
            }
            if(line.contains("//")) continue;
            buffer.append(line+System.lineSeparator());
        }
    }
    public static void main(String[] args) throws Exception
    {   
        Scanner sc = new Scanner(new File("01d_test1.c"));
        // Scanner scMyH = new Scanner(new File("01_test_cases/my.h"));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.contains(".h")) {
                addStringFromExternal(buffer,line);
                continue;
            }
            if(line.isEmpty()) continue;
            line = line.trim();
            if(line.contains("/*")){
                try{
                    while(!line.contains("*/")){    
                        line = sc.nextLine();}
                    continue;
                } catch(Exception e){
                    System.out.println(e);
                }      
            }
            if(line.contains("//")) continue;
            buffer.append(line+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("example.c"));
        writer.write(fileContents);
        writer.flush();
    }
}
