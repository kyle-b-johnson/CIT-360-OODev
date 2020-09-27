package fileHandling;

import java.io.*;
import java.util.Scanner;

public class textFile {

    public static int  countFileValues (File inputFile)
            throws FileNotFoundException {

        Scanner lineScanner = new Scanner(inputFile);
        lineScanner.useDelimiter(",");
        int valueCount = 0;

        while(lineScanner.hasNext() /*&& valueCount < 25*/) {
            System.out.println(lineScanner.next());
            valueCount++;

        }

        return valueCount;
    }



}
