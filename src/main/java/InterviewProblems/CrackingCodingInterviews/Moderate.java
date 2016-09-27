package InterviewProblems.CrackingCodingInterviews;

import java.util.*;

public class Moderate {

    /**
     * 16.1 Number Swapper: Write a function to swap a number in place (i.e. without temporary variables)
     */
    public int[] numberSwapper(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a,b};
    }

    /**
     * 16.2 Word Frequencies: Design a method to find the frequency of occurrences of any given word in a book.
     * What if we were running this algorithms multiple times?
     */
    public int wordFrequency(String text, String word) {
        //To specifically split on white space and the apostrophe
        //String[] tokens = text.split("[\\s']");

        //Or to split on any word character
        String[] tokens = text.split("[\\W]");

        int freq = 0;
        for (String s : tokens) {
            if (s.equalsIgnoreCase(word))
                freq++;
        }
        return freq;
    }

    /**
     * 16.3 Line Intersection
     * 16.4 Tic Tac Toe Win: Design an algorithm to figure out if someone won a game of tic tac toe.
     */
    public boolean ticTacToeWon(int[][] ticTacToeBoard) {
        if (ticTacToeBoard.length != ticTacToeBoard[0].length || ticTacToeBoard.length != 3)
            return false;

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        int[] columnSum = new int[ticTacToeBoard.length];

        for (int i=0; i < ticTacToeBoard.length; i++) {
            int rowSum = 0;
            for (int j =0; j < ticTacToeBoard[i].length; j++) {
                if (ticTacToeBoard[i][j] > 1 || ticTacToeBoard[i][j] < -1)
                    return false;

                rowSum += ticTacToeBoard[i][j];
                columnSum[j] += ticTacToeBoard[i][j];

                //Diagonal Validation
                if (i == j)
                    diagonalSum1 += ticTacToeBoard[i][j];

                if (i + j == ticTacToeBoard.length-1)
                    diagonalSum2 += ticTacToeBoard[i][j];
            }
            //Validating rows
            if (rowSum == 3 || rowSum == -3)
                return true;
        }

        if (diagonalSum1 == 3 || diagonalSum1 == -3 || diagonalSum2 == 3 || diagonalSum2 == -3)
            return true;

        for (int colSum : columnSum) {
            if (colSum == 3 || colSum == -3)
                return true;
        }

        return false;
    }

    /**
     * 16.5 Factorial Zeros: Write an algorithm which computes the number of trailing zeros in n factorial.
     */
    public int factorialZeros(int n) {

        int totalFiveMultiples = 0;
        for (int i =1; i <= n; i++) {
            if (i % 5 ==0) {
                int temp = i;
                while (temp % 5 == 0) {
                    totalFiveMultiples++;
                    temp /=5;
                }
            }
        }
        return totalFiveMultiples;
    }

    /**
     * 16.6 Smallest Difference: Given two arrays of integers, compute the pair of values (one value to each array)
     * with smallest non-negative difference.
     * Input: {1,3,15,11,2} and {23, 127, 235, 19, 8}
     * Output: 3 from pair {11,8}
     */
    public int smallestDifferenceIntArr(int[] arr1, int[] arr2) {
        //O(nlogn)
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int min = Math.max(Math.abs(arr2[arr2.length-1]-arr1[0]), Math.abs(arr1[arr1.length-1]-arr2[0]));
        //Complexity -> O(nlogn)
        for (int i=0; i < arr1.length; i++) {
            int diff = Math.max(Math.abs(arr2[arr2.length-1]-arr1[i]), Math.abs(arr2[0]-arr1[i]));
            diff = smallestDifferenceIntArrHelper(arr2, diff, arr1[i], 0, arr2.length-1);
            if (diff < min)
                min = diff;
        }
        return min;
    }

    private int smallestDifferenceIntArrHelper(int[] arr, int diff, int num, int start, int end) {
        int mid = (start+end)/2;
        int tempDiff = diff;

        if (Math.abs(arr[mid]-num) < diff) {
            tempDiff = Math.abs(arr[mid] - num);
            if (arr[start] <= num && num < arr[mid])
                return smallestDifferenceIntArrHelper(arr, tempDiff, num, start, mid-1);
            else if (num > arr[mid] && num <= arr[end])
                return smallestDifferenceIntArrHelper(arr, tempDiff, num, mid+1, end);
            else if (num < arr[start])
                return Math.abs(arr[start] - num);
            else
                return Math.abs(arr[end] - num);
        }
        else
            return tempDiff;
    }

    /**
     * 16.7 Number Max: Write a method to find the maximum of two numbers. You shouldn't use if-else or any other
     * comparison method. (???)
     */
    public int maxWithoutBranching(int a, int b) {
        int sigBitInInt = Integer.valueOf("0x80000000", 16).intValue();
        int signBitValue = ((a-b) | sigBitInInt);

        if (signBitValue > 0)
            return a;
        else
            return b;
    }

    /**
     * 16.8 English Int: Given an integer, print an English phase that describes the integer
     * (One Thousand Two Hundred Thirty Four)
     */
    public String englishInt(int n) {
        String[] smallInts = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                              "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] midNumbers = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"};
        String[] bigNumbers = {"", "Thousand", "Million", "Billion"};


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<4; i++) {
            if (n/(int)Math.pow(1000, i) == 0)
                break;

            String str = writeThousands((n/(int)Math.pow(1000, i)%1000), smallInts, midNumbers);
            if (str.trim().equals("Zero"))
                continue;

            str += bigNumbers[i] + " ";
            sb.insert(0, str);
        }
        return sb.toString().trim();
    }

    private String writeThousands(int n, String[] smallInts, String[] midNumbers) {
        StringBuilder sb = new StringBuilder();

        //Third digit
        if (n % 1000 >= 100)
            sb.append(smallInts[(n / 100)%10]).append(" ").append(midNumbers[10]).append(" ");

        //Second digit
        if (n % 100 >= 10 && n % 100 < 20) {
            sb.append(smallInts[10 + (n % 10)]).append(" ");
            return sb.toString();
        }
        else if (n % 100 >= 20) {
            sb.append(midNumbers[(n / 10) % 10]).append(" ");
        }

        //First digit
        sb.append(smallInts[n%10]).append(" ");

        return sb.toString();
    }

    /**
     * 16.9 Operations: Write methods to implement multiply, substract, and divide operations for integers.
     * Results of all of these are integers. Use only add operator.
     */
    public class OperationsWithAddition {

        public int substract(int a, int b) {
            return a + (-b);
        }

        public int multiply(int a, int b) {
            int sum = 0;
            boolean isBnegative = (b < 0) ? true : false;

            if (isBnegative)
                b = -b;

            for (int i=0; i < b; i++)
                sum +=a;

            if (isBnegative)
                return -sum;

            return sum;
        }

        public int divide(int a, int b) {

            boolean isANegative = (a < 0) ? true : false;
            boolean isBNegative = (b < 0) ? true : false;

            if (isANegative)
                a = -a;

            if (isBNegative)
                b = -b;

            int divFactor = 0;
            a = substract(a,b);
            while (a > 0) {
                a = substract(a,b);
                divFactor++;
            }

            if ((isANegative && !isBNegative) || (!isANegative && isBNegative))
                return -divFactor;

            return divFactor;
        }
    }

    /**
     * 16.10 Living People: Given a list of people with their birth and death years, implement a method
     * to compute the year with most people alive. Assume that all people were born between 1900 and
     * 2000 (inclusive).
     * 16.11 Diving Board: Skip this
     */
    public int livingPeople(ArrayList<int[]> peopleAge) {

        int sumBirth = 0;
        int sumDeath = 0;
        int eligiblePeople = 0;

        for (int[] personAge : peopleAge) {
            if (personAge.length != 2)
                continue;

            sumBirth += personAge[0]-1900;
            sumDeath += personAge[1]-1900;
            eligiblePeople++;
        }

        return (sumDeath + sumBirth)/(2*eligiblePeople)+1900;
    }

    /**
     * 16.12 XML Encoding: XML is very verbose, you need to encode it where each tag gets mapped
     * to pre-defined integer value.
     *
     * Element   --> Tag Attributes END Children END
     * Attribute --> Tag Value
     * END       --> 0
     * Tag       --> Some predefined mapping to int
     * Value     --> String value
     *
     * family    -> 1
     * person    -> 2
     * firstName -> 3
     * lastName  -> 4
     * state     -> 5
     *
     * <family lastName="McDowell" state="CA">
     *     <person firstName="Gayle">Some message<person/>
     * <family/>
     *
     * 1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0
     *
     * Write a method to print encoded version of XML element (passed Element and Attribute objects).
     */
    public String xmlEncoding(String xml) {
        StringBuilder encoding = new StringBuilder();
        LinkedList<String> tokens = new LinkedList<>();

        Map<String, Integer> mapAttributes = new HashMap<>();
        mapAttributes.put("family", 1);
        mapAttributes.put("person", 2);
        mapAttributes.put("firstName", 3);
        mapAttributes.put("lastName", 4);
        mapAttributes.put("state", 5);

        //Tokenize XML tags
        char[] xmlArr = xml.toCharArray();
        int i =0;
        while (i < xml.length()) {
            if (xmlArr[i] == '<') {
                int endTagIdx = xml.indexOf(">", i);
                String token = xml.substring(i, endTagIdx+1);
                tokens.add(token.trim());
                i = endTagIdx;
            } else if ((xmlArr[i] >= 'a' && xmlArr[i] <= 'z') || (xmlArr[i] >= 'A' && xmlArr[i] <= 'Z')) {
                int beginTagIdx = xml.indexOf("<", i);
                String tagVal = xml.substring(i, beginTagIdx);
                tokens.add(tagVal);
                i = beginTagIdx;
                continue;
            }
            i++;
        }

        //Parse tokens
        for (String token : tokens) {
            if (!token.contains(">") && !token.contains("<"))
                encoding.append(token).append(" ");

            if (token.contains("/>"))
                encoding.append("0 ");

            if (token.contains("<") && !token.contains("/>")) {
                String[] attr = token.replace("<", "").replace(">","").split(" ");
                for (int j =0; j< attr.length; j++) {
                    if (mapAttributes.containsKey(attr[j])) {
                        encoding.append(mapAttributes.get(attr[j])).append(" ");
                        continue;
                    }

                    if (attr[j].contains("=")) {
                        String[] keyValue = attr[j].split("=");
                        if (keyValue.length == 2 && mapAttributes.containsKey(keyValue[0])) {
                            encoding.append(mapAttributes.get(keyValue[0])).append(" ");
                            encoding.append(keyValue[1].replace("\"", "")).append(" ");
                        }
                    }
                }
                encoding.append("0 ");
            }
        }

        return encoding.toString().trim();
    }

    /**
     * 16.13 and 16.14 -> Geometry
     * 16.15 Mastermind:
     */

    /**
     * 16.16 Sub Sort: Given an array of integers, write a method to find the indices m and n such that if you sort
     * elements from m through n, the entire array would be sorted. Minimize n-m.
     *
     * Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
     * Output: (3,9)
     */
    public int[] subSort(int[] intArr) {

        int curBegin = 0;
        int curEnd = intArr.length-1;

        while (curEnd > curBegin) {
            if (intArr[curBegin+1] < intArr[curBegin] && intArr[curEnd] < intArr[curEnd-1])
                break;

            if (intArr[curBegin+1] >= intArr[curBegin])
                curBegin++;

            if (intArr[curEnd] >= intArr[curEnd-1])
                curEnd--;
        }

        //Find min and max between curBegin and curEnd
        int min = intArr[curBegin];
        int max = intArr[curEnd];
        for (int i = curBegin; i<= curEnd; i++) {
            if (intArr[i] < min)
                min = intArr[i];

            if (intArr[i] > max)
                max = intArr[i];
        }

        int[] output = new int[]{curBegin, curEnd};

        //Now scan from 0 to curBegin for min
        for (int i =0; i < curBegin; i++) {
            if (min < intArr[i]) {
                output[0] = i;
                break;
            }
        }

        //Another scan from curEnd to end for max
        for (int i =intArr.length-1; i > curEnd; i--) {
            if (max > intArr[i]) {
                output[1] = i;
                break;
            }
        }

        return output;
    }

    /**
     * 16.17 Contiguous Sequence: You are given an array of integers (both positive and negative). Find the contiguous
     * sequence with largest sum.
     * Input: 2, -8, 3, -2 4, -10
     * Output: 5 -> {3, -2, 4}
     */

    /**
     * 16.26 Calculator: Given an arithmetic equation consisting of positive integers, +, -, *, and /
     * (no parentheses), compute the result.
     *
     * Input: 2*3+5/6*3+15 = 6+5/2+15
     * Output: 23.5
     */
    public int noParenthesesCalculator(String expr) {
        char[] expArr = expr.replace(" ", "").toCharArray();
        return 1;
    }

}
