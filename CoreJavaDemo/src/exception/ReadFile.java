package exception;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFile {

    public void writeFile(String filename){
        FileWriter writer = null;
        try {
             writer = new FileWriter(filename);
            System.out.println("in try");
             writer.write("hey\n");// here

        } catch (IOException e) {
            System.out.println("in catch");
            throw new RuntimeException(e);
        }finally {
            System.out.println("fianlly");
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("end of method");
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        readFile.writeFile("D:/test.txt");
    }
}
