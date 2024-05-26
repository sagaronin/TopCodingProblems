package arrays_strings;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class LogFileParsing {
    public static void main(String[] args) {
        String fileName = "src/resource/log.txt";
        // System.out.println("Total error count : " + getTotalErrorCount(fileName));
        getErrorTypeWiseCountForEashCamera(fileName);
    }

    public static int getTotalErrorCount(String filePath) {
        int errorCount = 0;
        try {
            // Create a File object for the text file
            File file = new File(filePath);

            // Create a Scanner object to read the file
            Scanner scanner = new Scanner(file);

            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.toLowerCase().contains("err") || line.toLowerCase().contains("error")) {
                    errorCount++;
                }

                // Print the line to the console
                System.out.println(line);
            }
            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in opening file: " + e.getMessage());
        }
        return errorCount;
    }

    public static void getErrorTypeWiseCountForEashCamera(String filePath) {
        Map<String, Map<String, Integer>> camWithError = new HashMap<>();

        try {
            // Create a File object for the text file
            File file = new File(filePath);

            // Create a Scanner object to read the file
            Scanner scanner = new Scanner(file);

            // skip header line
            scanner.nextLine();
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.toLowerCase().contains("err") || line.toLowerCase().contains("error")) {
                    String camSerialNumber = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
                    String errorCodes = line.substring(line.indexOf(":") + 1);
                    String[] listOfErrorCodes = errorCodes.split(",");
                    System.out.println(
                            "Error codes for " + camSerialNumber + " are :" + Arrays.toString(listOfErrorCodes));

                    if (!camWithError.containsKey(camSerialNumber)) {
                        camWithError.put(camSerialNumber, new HashMap<String, Integer>());
                    }
                    Map<String, Integer> errorCodesInCam = camWithError.get(camSerialNumber);
                    for (String errorCode : listOfErrorCodes) {
                        if (errorCodesInCam.containsKey(errorCode.trim())) {
                            
                            errorCodesInCam.put(errorCode.trim(), errorCodesInCam.get(errorCode.trim()) + 1);
                        } else {
                            errorCodesInCam.put(errorCode.trim(), 1);
                        }
                    }
                }
              

            }
            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in opening file: " + e.getMessage());
        }
        System.out.println("---------------final output----------------");
        for (String camera : camWithError.keySet()) {
            System.out.println("Camera ID: " + camera);
            for (Entry<String, Integer> entry : camWithError.get(camera).entrySet()) {
            System.out.print("Code:Count - " + entry.getKey()+":"+entry.getValue());
            System.out.println();
            }
            System.out.println("-------------");
        }
    }

}
