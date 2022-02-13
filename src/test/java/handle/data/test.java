package handle.data;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class test {
    public static void main (String[] args) {
        Hashtable<String, String> dic = new Hashtable<String, String>();

        // Check file exist
        File yourFile = new File("score.txt");
        try {
            yourFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write File(String s)
        // (key + "-" + value + "\n")
        // ("")
        try (FileWriter writer = new FileWriter("test.txt", true );
             BufferedWriter bw = new BufferedWriter(writer)) {

            String key = "mau than1";
            String value = "tq2";
            bw.write(key + "-" + value + "\n");
            //bw.write(""); // dic.txt rong

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

//        Read file
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("test.txt"))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println("doc:" + line);

                // Read key value
                Scanner scan = new Scanner(line);
                //Initialize the string delimiter
                scan.useDelimiter("-");

                dic.put(scan.next(), scan.next());
                scan.close();

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("hashtable: " + dic);
    }
}
