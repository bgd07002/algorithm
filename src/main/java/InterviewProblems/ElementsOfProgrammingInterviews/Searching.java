package InterviewProblems.ElementsOfProgrammingInterviews;

public class Searching {

    /**
     * 12.1 Search a sorted array for the first occurrence of k
     */
    public int firstOccurrence(int[] sortedArr, int k) {
        return firstOccurrenceHelper(sortedArr, k, 0, sortedArr.length-1);
    }

    private int firstOccurrenceHelper(int[] sortedArr, int k, int start, int end) {
        int mid = (start+end)/2;
        if (sortedArr[mid] == k) {
            while (mid > 0 && sortedArr[mid] == k) {
                mid--;
            }
            return mid+1;
        }

        if (end > start) {
            int foundIdx = (k > sortedArr[mid]) ? firstOccurrenceHelper(sortedArr, k, mid+1, end) :
                    firstOccurrenceHelper(sortedArr, k, start, mid-1);
            return foundIdx;
        }
        return -1;
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
