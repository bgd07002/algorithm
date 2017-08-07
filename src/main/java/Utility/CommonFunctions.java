package Utility;

import java.io.*;
import java.util.*;

public class CommonFunctions {

    /**
     * This method loads the dictionary
     */
    public static ArrayList<String> loadDictionary(String fileName, String separator) throws IOException {

        ArrayList<String> outputList = new ArrayList<>();
        ClassLoader classLoader = CommonFunctions.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                if (separator == null)
                    outputList.add(scanner.nextLine());
                else {
                    String[] sepText = scanner.nextLine().split(separator);
                    for (String s : sepText)
                        outputList.add(s);
                }
            }
        }
        return outputList;
    }

}
