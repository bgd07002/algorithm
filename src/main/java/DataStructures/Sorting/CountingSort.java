package DataStructures.Sorting;


import java.util.List;

public class CountingSort {

    /**
     * Consider the data in the range 0 to 9.
     * Input data: 1, 4, 1, 2, 7, 5, 2
     */
    public int[] sortIntegers(int[] list, int minElement, int maxElement) {

        //1) Take a count array to store the count of each unique object.
        //Index:     0  1  2  3  4  5  6  7  8  9
        //Count:     0  2  2  0  1  1  0  1  0  0
        int[] countingArr = new int[maxElement-minElement+1];
        for (int i=0; i < list.length; i++)
            countingArr[list[i]]++;

        //2) Modify the count array such that each element at each index stores the sum of previous counts.
        //Index:     0  1  2  3  4  5  6  7  8  9
        //Count:     0  2  4  4  5  6  6  7  7  7
        for (int i=1; i< countingArr.length; i++)
            countingArr[i] += countingArr[i-1];

        //3) Output each object from the input sequence followed by decreasing its count by 1.
        //Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
        //Put data 1 at index 2 in output. Decrease count by 1 to place next data 1 at an index 1 smaller than this index.
        int[] aux = new int[list.length];
        for (int i=0; i< list.length; i++) {
            aux[countingArr[list[i]] - 1] = list[i];
            --countingArr[list[i]];
        }

        for (int i=0; i< list.length; i++)
            list[i] = aux[i];

        return list;
    }


    //Sort strings by nth letter
    public List<String> sortStringsBy_N_th_Letter(List<String> strList, int n) {
        //A=0,...,Z=25
        int[] nthLetterArr = new int[26];

        //1) Take a count array to store the count of each unique object.
        for (int i=0; i< strList.size(); i++) {
            char c = strList.get(i).charAt(n);
            nthLetterArr[(int)c-65]++;
        }

        //2) Modify the count array such that each element at each index stores the sum of previous counts.
        for (int i=1; i < nthLetterArr.length; i++) {
            nthLetterArr[i] += nthLetterArr[i-1];
        }

        //3) Output each object from the input sequence followed by decreasing its count by 1.
        String aux[] = new String[strList.size()];
        for (int i=0; i< strList.size(); i++) {
            int charVal = (int)strList.get(i).charAt(n)-65;
            aux[nthLetterArr[charVal]-1] = strList.get(i);
            --nthLetterArr[charVal];
        }

        for (int i=0; i< strList.size(); i++)
            strList.set(i, aux[i]);

        return strList;
    }

}
