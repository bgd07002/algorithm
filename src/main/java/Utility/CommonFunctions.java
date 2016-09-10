package Utility;

import java.io.*;
import java.util.*;

public class CommonFunctions {

    /**
     * This method loads the dictionary
     */
    public static ArrayList<String> loadDictionary(String fileName) throws IOException {

        ArrayList<String> outputList = new ArrayList<>();
        ClassLoader classLoader = CommonFunctions.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                outputList.add(scanner.nextLine());
            }
        }
        return outputList;
    }
}
