package InterviewProblems;

public class StringsArrays {

    /**
     * 1.1 Implement an algorithm to determine if a string has all unique characters. What
     * if you cannot use additional data structures?
     */
    public boolean isStringUniqueChars(String inputStr) {

        if (inputStr == null || inputStr.length() > 256 )
            return false;

        boolean[] charArr = new boolean[256];
        for (char ch : inputStr.toCharArray()) {

            int idx = (int)ch;
            if (charArr[idx])
                return false;
            else
                charArr[idx] = true;
        }
        return true;
    }

    /**
     * 1.2 Given two strings, write a method to decide if one is a permutation of the other.
     */
    public boolean isAnagram(String sOriginal, String sPermuted) {
        if (sOriginal.length() != sPermuted.length())
            return false;

        int[] intArray = new int[256];
        for (char ch : sOriginal.toCharArray()) {
            intArray[(int)ch]++;
        }

        for (char ch: sPermuted.toCharArray()) {
            if (intArray[(int)ch] < 1)
                return false;
            else
                intArray[(int)ch]--;
        }
        return true;
    }

    /**
     * 1.3 Write a method to replace all spaces in a string with'%20'.
     */
    public String replaceSpaceChars(String inputStr) {
        StringBuilder sb = new StringBuilder();

        for (char ch : inputStr.toCharArray()) {
            if (ch != ' ')
                sb.append(ch);
            else
                sb.append("%20");
        }
        return sb.toString();
    }

    /**
     * Implement a function void reverse(char* str) in Cor C++ which reverses a null-terminated
     * string.
     */
    public String reverseString(String str) {

        if (str == null || str.length() <= 1 )
            return str;

        char[] strArr = str.toCharArray();
        for (int i=0; i < strArr.length - i; i++) {
            char temp = strArr[i];
            strArr[i] = strArr[str.length()-i-1];
            strArr[str.length()-i-1] = temp;
        }
        return new String(strArr);
    }

    /**
     * 1.6 Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become
     * a2blc5a3. If the "compressed" string would not become smaller than the original
     * string, your method should return the original string.
     */
    public String stringCompression(String inputStr) {
        StringBuilder sb = new StringBuilder();
        char[] inputArr = inputStr.toCharArray();

        for (int i=0; i < inputArr.length; ) {
            char temp = inputArr[i];
            int compNumber = 1;
            int j= i+1;
            do {
                if (j == inputArr.length || inputArr[j] != temp) {
                    sb.append(inputArr[i])
                            .append(compNumber);
                    i = j;
                    break;
                } else {
                    compNumber++;
                }
                j++;
            } while (j <= inputArr.length);
        }

        return (sb.length() < inputStr.length()) ? sb.toString() : inputStr;
    }

    public static void main(String[] args)
    {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isAnagram("abcde", "edcba");
        boolean b1 = sa.isAnagram("abcde", "cdeaaf");
        System.out.println("Result1:" + b);
        System.out.println("Result2:" + b1);
    }

}
