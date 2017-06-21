package InterviewProblems.LeetCode;


import java.util.Arrays;

public class LeetCode {

    /**
     * LeetCode 1: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution.
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i =0; i < nums.length; i++) {
            int residue = target - nums[i];
            for (int j = i+1; j < nums.length; j++)
                if (nums[j] == residue)
                    return new int[]{i,j};
        }
        return null;
    }

    /**
     * Leetcode 3: Given a string, find the length of the longest substring without repeating characters.
     * Example:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
     * "pwke" is a subsequence and not a substring.
     */


    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     Do not allocate extra space for another array, you must do this in place with constant memory.
     The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     Example:
     Given input array nums = [3,2,2,3], val = 3
     */
    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length ==0)
            return 0;

        int reader = 0;
        int writer = 0;
        while (reader < nums.length) {
            if (nums[reader] != val) {
                nums[writer] = nums[reader];
                writer++;
            }
            reader++;
        }
        return writer;
    }

    /**
     * Rotate an array of n elements to the right by k steps.
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;

        if (k <= 0)
            return;

        k = k % nums.length;
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length-k, temp,0 , k);

        for (int i =nums.length-k-1; i >=0; i--) {
            nums[i+k] = nums[i];
        }

        System.arraycopy(temp,0,nums,0,k);
    }

    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
     * the linked list should become 1 -> 2 -> 4 after calling your function.
     */



    public static void main(String[] args) {
        LeetCode a = new LeetCode();
        int[] input = {1,2,3,4,5,6,7};
        a.rotate(input,3);

        System.out.println(Arrays.toString(input));
    }
}
