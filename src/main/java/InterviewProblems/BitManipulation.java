package InterviewProblems;


public class BitManipulation {

    /**
     * 5.1 You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j
     * in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
     * EXAMPLE:
     * Input: N = 10000000000, M = 10101, i = 2, j = 6
     * Output: N = 10001010100
     */
    public int setNSubsetsOfM(int N, int M, int i, int j) {

        //All 1's
        int max = ~0;
        System.out.println("Max: " + Integer.toBinaryString(max));

        //1's through position j, then 0's
        int left = max - ((1 << j) - 1);
        System.out.println("Left: " + Integer.toBinaryString(left));

        //1's after position i
        int right = ((1 << i) -1);
        System.out.println("Right: " + Integer.toBinaryString(right));

        //1's, with 0s between i and j
        int mask = left | right;
        System.out.println("Mask: " + Integer.toBinaryString(mask));

        System.out.println("Output: " + Integer.toBinaryString((N & mask) | (M << i)));
        //Clear i through j, then put m in there
        return (N & mask) | (M << i);
    }

    /**
     * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation. If the number can not
     * be represented accurately in binary, print “ERROR”
     */

    /**
     * 5.4 Given an integer, print the next smallest and next largest number that have the
     * same number of 1 bits in their binary representation.
     */
    public int[] minMaxSameBits(int input) {
        int[] output = new int[2];

        //First count the number of bits
        int numOfOnes = 0;
        int numOfBits = 0;
        while (input > 0) {
            numOfOnes += input%2;
            input /= 2;
            numOfBits++;
        }

        //output[0] is the minimum
        int i =0;
        while (i < numOfOnes) {
            output[0] += (int) Math.pow(2, i++);
        }

        //output[1] is the max
        output[1] = (output[0] << (numOfBits-numOfOnes));
        return output;
    }

    /**
     * 5.5 What the following code does n & (n-1) == 0
      */

    /**
     * 5.6 Write a function to determine the number of bits required to convert integer A to integer B.
     * Input: 31, 14
     * Output: 2
     */
    public int numBitsToConvert(int a, int b) {
        int xor = a^b;

        int numOfOnes = 0;
        while (xor > 0) {
            numOfOnes += xor%2;
            xor /= 2;
        }
        return numOfOnes;
    }

    /**
     * 5.7 Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).
     */
    public int swapOddEvenBits(int x) {
        return ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
    }

    /**
     * An array A[1... n] contains all the integers from 0 to n except for one number which is missing. In this problem, we cannot access an entire integer
     * in A with a single operation. The elements of A are represented in binary, and the only operation we can use to access them is “fetch the jth
     * bit of A[i]”, which takes constant time. Write code to find the missing integer. Can you do it in O(n) time?
     */
}
