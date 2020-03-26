import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

class MagicSquare {
    private static int number = 0;
    private static boolean flag = true;

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("Luna.txt");
        BufferedReader br = new BufferedReader(fr);
        String aLine = null;
        ArrayList<String[]> lines = new ArrayList<String[]>();

        while((aLine = br.readLine()) != null) {
            String[] lineArray = aLine.split("\t");
            lines.add(lineArray);
        }

        for(int i = 0; i < lines.size(); i++) {
            String[] line = lines.get(i);
            int total = 0;
            for(String s : line) {
                total += Integer.valueOf(s);
            }

            if (number == 0) {
                number = total;
            } else if (number != total) {
                System.out.println("Not a Magic Square");
                flag = false;
            }
        }

        if(flag == true) {
            System.out.println("Magic Square!");
        }

        br.close();
    }
}
