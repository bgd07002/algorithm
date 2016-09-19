package InterviewProblems.ElementsOfProgrammingInterviews;


import java.util.Set;

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

        int i = 0;
        int smallestOne = -1;
        int smallestZero = -1;
        while (i < 32) {
            if ((num & (1 << i)) > 0 && smallestOne == -1)
                smallestOne = i;

            if ((num | (1 << i)) == 0 && smallestZero == -1)
                smallestZero = i;

            if (smallestOne >=0 && smallestZero >= 0)
                break;

            i++;
        }
        int numClosest = swapBits(num, smallestOne, smallestZero);
        return numClosest;
    }

    /**
     * 5.5 Power Set of all subsets of S
     * Example: Power set for {ABC}
     * 0, A, B, C, AB, AC, BC, ABC
     */
    public String powerSet(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(", ");

        for (String el : set) {
            sb.append(el).append(", ");
        }
        return null;
    }

}
