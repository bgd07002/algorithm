package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrimitiveTypes {

    /**
     * 5.1 Computing Parity: Compute the parity of very large number of 64 bits non-negative integers.
     * Parity 1 -> Number of 1s is odd, otherwise it is 0.
     */
    public int computeParity(long number) {

        int bitSum = 0;
        while (number != 0) {
            bitSum ^= (number & 1);
            number = number >>> 1;
        }
        return bitSum;
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
        int mostSigBit = 31;
        for (int i =0; i <= mid; i++) {
            num = swapBits(num, i, mostSigBit-i);
        }
        return num;
    }

    /**
     * 5.4 Closest Integer With Same Weight
     */
    public int closestIntegerSameWeight(int num) {

        if (num == Integer.MIN_VALUE || num == 0)
            return -1;

        int smallestOneLocation = -1;
        int smallestZeroLocation = -1;

        for (int i=0; i < Integer.SIZE; i++) {
            if (smallestOneLocation == -1 && ((num >> i) & 1) == 1)
                smallestOneLocation = i;

            if (smallestZeroLocation == -1 && ((num >> i) & 1) == 0)
                smallestZeroLocation = i;

            if (smallestOneLocation != -1 && smallestZeroLocation != -1)
                break;
        }

        if (smallestOneLocation > smallestZeroLocation)
            smallestZeroLocation = smallestOneLocation-1;

        return swapBits(num, smallestOneLocation, smallestZeroLocation);
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

            int cur =i;
            int j =0;
            while(cur > 0) {
                if ((cur & 1) == 1)
                    sb.append(set[j]);

                cur = cur >> 1;
                j++;
            }
            sb.append(", ");
        }
        String makeupOutput = sb.toString().trim();
        return makeupOutput.substring(0, makeupOutput.length()-1);
    }


    /**
     * 5.9 Elias Gamma Encoding
     *      1.) Write n in binary to form a string b
     *      2.) Subtract 1 from string length and add that many zeros to the front
     *      Example: 13 -> 1101 -> Encoding -> 0001101
     */
    public String eliasGammaEncoding(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbTemp;

        for (int i : numbers) {
            sbTemp = new StringBuilder();
            while (i > 0) {
                sbTemp.append(i & 1);
                i = i >> 1;
            }
            //Add zeros first
            int ilength = sbTemp.length()-1;
            while (ilength > 0) {
                sb.append("0");
                ilength--;
            }
            sb.append(sbTemp.reverse());
        }

        return sb.toString();
    }

    public int[] eliasGammaDecoding(String encoding) {
        if (!encoding.matches("[01]+"))
            throw new IllegalArgumentException("Non-binary character on file or input contents");

        List<Integer> decodedIntegerList = new ArrayList<>();
        char[] encodingChar = encoding.toCharArray();

        int countZeros = 0;
        boolean isCountingZeros = true;
        int number =0;
        for (int i =0; i< encodingChar.length; i++) {
            if (isCountingZeros) {
                if (encodingChar[i] == '0')
                    countZeros++;
                else {
                    isCountingZeros = false;
                    number = Character.getNumericValue(encodingChar[i]);
                }
            } else {
                if (countZeros > 0) {
                    countZeros--;
                    number = (number << 1) + Character.getNumericValue(encodingChar[i]);
                } else {
                    isCountingZeros = true;
                    decodedIntegerList.add(number);
                    number =0;
                    countZeros++;
                }
            }
        }

        if (number > 0)
            decodedIntegerList.add(number);

        int[] arr = decodedIntegerList.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    /**
     * 5.10 Check integer is palindrome.
     * Solution 1: Convert to string and verify it.
     * Solution 2: Utilize integer arithmetic. if 123 == 123
     */
    public boolean isIntegerPalindrome(int num) {
        if (num < 0)
            return false;

        int newNum = 0;
        int remainder = 0;

        while (num > newNum) {
            remainder = (num % 10);
            newNum = 10*newNum + remainder;
            num /= 10;

            if (num == newNum)
                return true;
        }

        if (10*num + remainder == newNum)
            return true;

        return false;
    }

    /**
     * 5.11 Rectangle Intersection: Check if two rectangles have intersection
     */
    public class Rectangle {
        private int x,y,width,height;

        public int getX() { return x; }
        public int getY() { return y; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public boolean isRectanglesIntersect(Rectangle r1, Rectangle r2) {
        //Case I
        if (r1.x+r1.width > r2.x && r2.y + r2.height > r1.y)
            return true;
        //Case II
        else if (r1.x + r1.width > r2.x && r1.y + r1.height > r2.y)
            return true;
        //Case III
        else if (r2.x + r2.width > r1.x && r1.y + r1.height > r2.y)
            return true;
        //Case IV
        else if (r2.x + r2.width > r1.x && r2.y + r2.height > r2.y)
            return true;
        //Case V (one rectangle is inside of another)
        else if (r1.x < r2.x && r1.x + r1.width > r2.x + r2.width && r2.y > r1.y && r1.y + r1.height > r2.y + r2.height)
            return true;
        else if (r2.x < r1.x && r2.x + r2.width > r1.x + r1.width && r1.y > r2.x && r2.y + r2.height > r1.y + r1.height)
            return true;

        return false;
    }

    /*
    private boolean isRectanglesIntersect(Rectangle r1, Rectangle r2) {
        if ((r1.x+r1.width > r2.x && r1.y+r1.height > r2.y &&
                r1.x+r1.width < r2.x+r2.width && r1.y+r1.height < r2.y+r2.height) ||
                (r2.x+r2.width > r1.x && r2.y+r2.height > r1.y &&
                        r2.x+r2.width < r1.x+r1.width && r2.y+r2.height < r1.y+r1.height))
            return true;

        return false;
    }

    public Rectangle rectangeIntersection(Rectangle r1, Rectangle r2) {
        if (isRectanglesIntersect(r1,r2)) {
            if (r2.x > r1.x)
                return new Rectangle(r2.x, r2.y, r1.x+r1.width-r2.x, r1.y+r1.height-r2.y);
            else
                return new Rectangle(r1.x, r1.y, r2.x+r2.width-r1.x, r2.y+r2.height-r1.y);
        }
        return null;
    }
    */
}
