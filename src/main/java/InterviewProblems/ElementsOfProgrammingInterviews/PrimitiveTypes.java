package InterviewProblems.ElementsOfProgrammingInterviews;

public class PrimitiveTypes {

    /**
     * 5.1 Computing Parity: Compute the parity of very large number of 64 bits non-negative integers.
     * Parity 1 -> Number of 1s is odd, otherwise it is 0.
     */
    public int computeParity(long number) {
        int bitSum = (number >= 0)? 0: 1;

        number = (number > 0)? number: -number;
        while (number > 0) {
            bitSum += (number % 2);
            number /=2;
        }
        return (bitSum % 2);
    }

    /**
     * 5.2 Swap Bits: Swap bits at i and j for 64 bit integer
     */
    public int swapBits(int num, int i, int j) {
        if (((num >> i) & 1) != ((num >> j) & 1))
            num ^= (1 << i) | (1 << j);

        return num;
    }

    /**
     * 5.3 Bit Reversal
     */
    public int reverseBits(int num) {
        int mid = 15;
        for (int i =0; i <= mid; i++)
            num = swapBits(num, i, 31-i);
        return num;
    }

    /**
     * 5.4 Closest Integer With Same Weight
     */
    public int closestIntegerSameWeight(int num) {

        if (num == Integer.MAX_VALUE || num == 0)
            return -1;

        int intSize =32;
        int smallestOne = -1;
        int smallestZero = -1;
        for (int i=0; i < intSize; i++) {
            if ((num & (1 << i)) > 0) {
                smallestOne = i;
                break;
            }
        }

        for (int i = smallestOne - 1 ; i >= 0; i--) {
            if ((num ^ (1 << i)) > 0) {
                smallestZero = i;
                break;
            }
        }

        if (smallestZero == -1) {
            for (int i = smallestOne + 1; i < intSize; i++) {
                if ((num ^ (1 << i)) > 0) {
                    smallestZero = i;
                    break;
                }
            }
        }

        int numClosest = swapBits(num, smallestOne, smallestZero);
        return numClosest;
    }

    /**
     * 5.5 Power Set of all subsets of S
     * Example: Power set for {ABC}
     * 0, A, B, C, AB, AC, BC, ABC
     */
    public String powerSet(String[] set) {
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(", ");

        //Use lexicographic notation to show all subsets
        for (int i =1; i < Math.pow(2,set.length); i++) {
            int iBinary = 0;
            int iTemp = i;
            StringBuilder setSB = new StringBuilder();
            while (iTemp > 0) {
                if (iTemp % 2 == 1)
                    setSB.append(set[iBinary]);

                iBinary++;
                iTemp /= 2;
            }
            sb.append(setSB.toString()).append(", ");
        }
        String makeupOutput = sb.toString().trim();
        return makeupOutput.substring(0, makeupOutput.length()-1);
    }

    /**
     * 5.6 String Integer Encoding: "123" -> 123, "-123" -> -123, "123bc" -> Exception
     * Edge Cases: Max integer
     */
    public int stringIntegerEncoding(String str) {
        if (!str.matches("[0-9-]+"))
            return -1;

        char[] strArr = str.toCharArray();
        int number = (strArr[0] != '-') ? Character.getNumericValue(strArr[0]): 0;
        for (int i= 1; i < strArr.length; i++) {
            number = 10* number + Character.getNumericValue(strArr[i]);
        }
        return (strArr[0] == '-') ? -number : number;
    }

    /**
     * 5.7 Base Conversion: Write a function that performs the base conversion for 2 <= b <= 16
     */
    public String baseConversion(int num, int base) {
        StringBuilder sb = new StringBuilder();
        char[] convMapping = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int numPos = (num < 0)? -num : num;

        while(numPos > 0) {
            int residue = numPos % base;
            sb.append(convMapping[residue]);
            numPos /= base;
        }

        sb = (num < 0) ? sb.append('-').reverse() : sb.reverse();
        return sb.toString();
    }

    /**
     * 5.8 Spreadsheet Column Encoding: Convert id into A, B,...,Z, AA, AB,..., AZ,..., ZZ ,AAA, AAB,...
     */
    public String spreadsheetEncoding(int id) {
        char[] alphabetEnc = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int alphabetSize = alphabetEnc.length;

        /**
         * 0-5
         * 6-30
         * 31-155
         */
        int encodingLength = 0;
        while () {

            encodingLength++;
        }

        return null;
    }
}
