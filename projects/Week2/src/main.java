import java.util.*;
import java.io.*;

public class main {
    public static void main(String[]args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Hello!\n" +
                "This program will read data from a user-defined CSV file\n" +
                "and display the results as dictated by the various types from\n " +
                "the Java collections class.");

        String userFilePath = fileHandling.checks.setFilePath(userInput);

        fileHandling.checks.verifyFilePath(userInput, userFilePath);

        File inputFile = new File(userFilePath);

        try {
            fileHandling.checks.fileExists(inputFile);
        } catch (FileNotFoundException ex) {
            System.out.print("Error: File was unable to be found.\n" +
                    "Please enter a valid file path");
            userFilePath = fileHandling.checks.setFilePath(userInput);
        }

        while (!fileHandling.checks.isCSV(inputFile)
                && !fileHandling.checks.isTXT(inputFile)) {
            try {
                fileHandling.checks.fileFormatType(inputFile);
            } catch (IOException ex) {
                System.out.println("Error: This is not a .csv or .txt file.\n" +
                        "Please use a file with one of those file extensions.");
                userFilePath = fileHandling.checks.setFilePath(userInput);
                inputFile = new File(userFilePath);
            }
        }

        // Verify file can be read
        try {
            fileHandling.checks.checkFileRead(inputFile);
        }
        // Throw IOException (with name 'ex') if file cannot be read
        catch (IOException ex) {
            System.out.println("Error:\nCannot read from file.\n" +
                    "Please enter another file path.");
            userFilePath = fileHandling.checks.setFilePath(userInput);
        }

        System.out.println("How much of the file would you like to read?\n" +
                    "Note: This may depend on the format of the file you are " +
                    "using.\n" +
                    "1. Read just the first line\n" +
                    "2. Read the whole file");
         int readResponse = Integer.parseInt(userInput.next());

        //IF statement to determine delimiter (txt =  space, csv = comma)
            //Read in each value
        if (fileHandling.checks.isCSV(inputFile) && (readResponse == 2)) {
            try {
                System.out.println("There are "
                        + fileHandling.csvFile.countFileValues(inputFile)
                + " values in this file distributed across "
                        + fileHandling.csvFile.countLineValues(inputFile)
                + " lines within the file. Of those values " +
                        + fileHandling.csvFile.countFirstLineValues(inputFile)
                        + " are in the first line.");
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found.");
            }
        }

    }


}