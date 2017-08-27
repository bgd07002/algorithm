package InterviewProblems.ElementsOfProgrammingInterviews;

public class Searching {

    /**
     * 12.1 Search a sorted array for the first occurrence of k
     */
    public int firstOccurrence(int[] sortedArr, int k) {
        return firstOccurrenceHelper(sortedArr, k, 0, sortedArr.length-1);
    }

   private int firstOccurrenceHelper(int[] sortedArr, int k, int start, int end) {
       if (start > end)
           return -1;

       int mid = (start+end)/2;
       if (k > sortedArr[mid])
           return firstOccurrenceHelper(sortedArr, k, mid+1, end);
       else if (k < sortedArr[mid])
           return firstOccurrenceHelper(sortedArr, k, start, mid-1);
       else {
           int cur = mid;
           while (sortedArr[cur] == k) {
               cur--;
           }
           return cur+1;
       }
   }

    /**
     * 12.2 Search a sorted array equal to its index
     * Brute force
     */
    public int searchElementEqualtoIndex(int[] sortedArr) {
        return searchElementEqualtoIndexHelper(sortedArr, 0, sortedArr.length-1);
    }

    private int searchElementEqualtoIndexHelper(int[] sortedArr, int start, int end) {
        int mid = (start+end)/2;
        if (sortedArr[mid] == mid)
            return mid;

        if (end > start) {
            int idx = searchElementEqualtoIndexHelper(sortedArr, mid+1, end);
            if (idx > -1)
                return idx;
            idx = searchElementEqualtoIndexHelper(sortedArr, start, mid-1);
            if (idx > -1)
                return idx;
        }
        return -1;
    }
}
