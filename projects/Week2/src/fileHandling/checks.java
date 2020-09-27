package fileHandling;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class checks {
    public static String setFilePath (Scanner scannerObject){
        System.out.println("Please enter a file path: ");

        return scannerObject.next();
    }

    public static void verifyFilePath (Scanner scannerObject, String filePath) {
        String responseString = "n";

        while (responseString.charAt(0) == 'n') {
            System.out.println("You have entered:\n" + filePath +
                    "\nas your desired file location. Is this correct? [Y/N]");
            responseString = scannerObject.next();

            if(responseString.charAt(0) == 'n'){
                System.out.println("You have indicated that you would like to " +
                        "change the file path.");
                setFilePath(scannerObject);
            }
        }
    }

    public static Boolean isCSV(File testFile) {
        String fileName = testFile.toString();

         return fileName.endsWith("csv");

    }

    public static Boolean isTXT(File testFile) {
        String fileName = testFile.toString();

        return (fileName.endsWith("txt"));
    }

    public static void fileFormatType(File testFile) throws IOException {
        if(!isCSV(testFile) && !isTXT(testFile))
            throw new IOException("File is in an invalid format");
    }

    public static void fileExists(File testFile) throws FileNotFoundException {
        if(!testFile.exists())
            throw new FileNotFoundException("File does not exist.");

    }

    public static void checkFileRead(File testFile) throws IOException {
        if (!testFile.canRead())
            throw new IOException("File cannot be read.");
    }
}
