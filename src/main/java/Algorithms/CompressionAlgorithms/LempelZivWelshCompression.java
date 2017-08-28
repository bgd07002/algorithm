package Algorithms.CompressionAlgorithms;

import java.util.*;

public class LempelZivWelshCompression {

    private Map<String, Integer> symbolTable;
    private static final int LEMPEL_ZIV_BINARY_LENGTH = 12;

    public LempelZivWelshCompression() {
        symbolTable = new LinkedHashMap<>();
        loadSymbolTableForAscii();
    }

    /**
     * Fill symbol table from 0 to 255 and leave blank for 256-4095.
     * Later on, we will fill the rest
     */
    private void loadSymbolTableForAscii() {
        for (int i=0; i<256; i++) {
            symbolTable.put(Character.toString((char)i),i);
        }
    }

    /**
     * Lempel-Ziv-Welsh Compression
     */
    public String compress(String s) {
        List<Integer> encodedList = new ArrayList<>();

        char[] sArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< sArr.length; i++) {
            sb.append(sArr[i]);
            if (!symbolTable.keySet().contains(sb.toString())) {
                symbolTable.put(sb.toString(), symbolTable.keySet().size());
            }
            int encodedNum = symbolTable.get(sb.toString());
            if (!encodedList.contains(encodedNum)) {
                encodedList.add(encodedNum);
                sb = new StringBuilder();
            }
        }

        //Take care of any leftovers
        if (sb.length() > 0)
            encodedList.add(symbolTable.get(sb.toString()));

        //Now convert encoded numbers into binary
        StringBuilder encodingInBinary = new StringBuilder();
        for (int i : encodedList)
            encodingInBinary.append(convertIntoToBin(i));
        return encodingInBinary.toString();
    }

    private StringBuilder convertIntoToBin(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< LEMPEL_ZIV_BINARY_LENGTH; i++) {
            sb.append(num & 1);
            num = num >> 1;
        }
        return sb.reverse();
    }

    private int convertBinToInt(String binStr) {
        int sum =0;
        for (char c : binStr.toCharArray())
            sum = 2*sum + (int) c -48;

        return sum;
    }

    /**
     * Decompression from Lempel-Ziv-Welsh algorithm
     */
    public String decompress(String s) {
        //Compression error
        if (s.length() % 12 != 0)
            return null;

        List<Integer> encodingNumList = new ArrayList<>();
        int i =0;
        while (i<s.length()) {
            String subStr = s.substring(i,i+LEMPEL_ZIV_BINARY_LENGTH);
            int num = convertBinToInt(subStr);
            encodingNumList.add(num);
            i += LEMPEL_ZIV_BINARY_LENGTH;
        }

        StringBuilder plaintext = new StringBuilder();
        for (int num : encodingNumList) {
            boolean isFound = false;
            for (String key : symbolTable.keySet())
                if (symbolTable.get(key).equals(num)) {
                    plaintext.append(key);
                    isFound = true;
                }

            //element not found on symbol table. Something wrong happened during compression
            if (!isFound)
                return null;
        }
        return plaintext.toString();
    }

}
