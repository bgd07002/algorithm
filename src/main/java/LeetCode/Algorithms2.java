package LeetCode;

import java.util.regex.Pattern;

public class Algorithms2 {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 1)
            return s.length();

        String longestTemp = "";
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (sb.indexOf(Character.toString(c)) > -1) {
                if (sb.length() > longestTemp.length()) {
                    longestTemp = sb.toString();
                }
                sb = new StringBuilder();
            }
            sb.append(c);
        }

        if (sb.length() > longestTemp.length())
            longestTemp = sb.toString();

        return longestTemp.length();
    }


    /**
     * 387 - First unique character: Given a string, find the first non-repeating character in it and
     * return it's index. If it doesn't exist, return -1. You may assume the string contain only lowercase letters.
     * Examples:
     * s = "leetcode" => return 0.
     * s = "loveleetcode" => return 2.
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;

        int[] repeatingArr = new int[256];
        char[] sArr = s.toCharArray();
        for (int i=0; i < s.length(); i++){
            repeatingArr[(int)sArr[i]]++;
        }

        for (int i=0; i< s.length(); i++) {
            if (repeatingArr[(int)sArr[i]] < 2)
                return i;
        }
        return -1;
    }

    /**
     * 7 - Reverse Integer:
     * Reverse digits of an integer.
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     *
     * Note: The input is assumed to be a 32-bit signed integer. Your function should return 0 when the
     * reversed integer overflows.
     */
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;

        int reverse = 0;
        int remainder = 0;
        boolean isPositive = (x>=0) ? true : false;
        x = isPositive ? x : -x;

        while(x > 0) {
            remainder = x %10;
            x = x/10;
            reverse = 10*reverse + remainder;
        }
        return (isPositive) ? reverse : -reverse;
    }

    /**
     * 20 - Valid Parentheses: Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid. The brackets must close in the correct order, "()" and "()[]{}"
     * are all valid but "(]" and "([)]" are not.
     */
    public boolean isValid(String s) {
        if (s == null)
            return false;

        char[] sArr = s.toCharArray();
        for (int i=0; i < s.length();) {
            if (sArr[i] == '(')
                if (i + 1 == s.length() || sArr[i + 1] != ')')
                    return false;

            if (sArr[i] == '[')
                if (i+1 == s.length() || sArr[i+1] != ']')
                    return false;

            if (sArr[i] == '{')
                if (i+1 == s.length() || sArr[i+1] != '}')
                    return false;

            i += 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Algorithms2 a = new Algorithms2();
        /*
        int test1 = a.lengthOfLongestSubstring("abcabcbb");
        int test2 = a.lengthOfLongestSubstring("bbbbbb");
        int test3 = a.lengthOfLongestSubstring("pwwkew");
        int test4 = a.lengthOfLongestSubstring("dvdf");

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test4);
        */
        boolean b1 = a.isValid("()");
        boolean b2 = a.isValid("(){}[]()");
        boolean b3 = a.isValid("([)]");
        boolean b4 = a.isValid("(}");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
