package fileHandling;

import java.io.*;
import java.util.*;

public class csvFile {

    public static int  countFileValues (File inputFile)
            throws FileNotFoundException {

        Scanner lineScanner = new Scanner(inputFile);
        lineScanner.useDelimiter(",");
        int valueCount = 0;

        while(lineScanner.hasNext()) {
            valueCount++;
        }

        return valueCount;
    }

    public static int countLineValues (File inputFile)
            throws FileNotFoundException {
        Scanner fileScanner = new Scanner(inputFile);
        int lineCount = 0;
        int firstLineCount = 0;
        while(fileScanner.hasNextLine()) {
            String lineToRead = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(lineToRead);
            lineScanner.useDelimiter(",");
            int valueCount = 0;


            lineCount++;
        }
        return lineCount;
    }

    public static int countFirstLineValues (File inputFile)
            throws FileNotFoundException {
        Scanner fileScanner = new Scanner(inputFile);
        int lineCount = 0;
        int firstLineCount = 0;
        while(fileScanner.hasNextLine()) {
            String lineToRead = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(lineToRead);
            lineScanner.useDelimiter(",");
            int valueCount = 0;

            while (lineScanner.hasNext() /*&& valueCount < 25*/) {
                valueCount++;
                if(lineCount <1) {
                    firstLineCount++;
                }
            }
            lineCount++;
        }
        return firstLineCount;
    }

}
