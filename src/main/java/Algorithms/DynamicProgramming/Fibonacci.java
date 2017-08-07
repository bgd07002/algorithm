package Algorithms.DynamicProgramming;

public class Fibonacci {

    public int computeFibonnaci(int num) {
        if (num < 0)
            return -1;

        if (num == 0)
            return 0;

        int[] fibArr = new int[num+1];
        fibArr[0] = 0;
        fibArr[1] = 1;
        for (int i= 2; i < fibArr.length; i++) {
            fibArr[i] = fibArr[i-1] + fibArr[i-2];
        }
        return fibArr[num];
    }
}
