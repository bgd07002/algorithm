package DataStructures.Sorting;

import java.util.ArrayList;

public class QuickSort<T extends Comparable<T>> implements ISorter<T>  {

    public void sortList(ArrayList<T> collection) {

        if (collection == null || collection.size() < 2)
            return;

        quickSort(collection, 0, collection.size()-1);
    }

    private void quickSort(ArrayList<T> collection, int start, int end) {

        int curToBeReplaced = -1;
        if (start < end-1) {
            T pivot = collection.get(end);
            int cur1 = start;
            int cur2 = end-1;

            while(cur1 < cur2 ) {
                int compareCur1 = collection.get(cur1).compareTo(pivot);
                int compareCur2 = collection.get(cur2).compareTo(pivot);

                if (compareCur1 < 0 && compareCur2 > 0) {
                    cur1++;
                    cur2--;
                } else if (compareCur1 < 0 && compareCur2 < 0) {
                    cur1++;
                } else if (compareCur1 > 0 && compareCur2 > 0) {
                    cur2--;
                }
                else {
                    T temp = collection.get(cur1);
                    collection.set(cur1, collection.get(cur2));
                    collection.set(cur2, temp);
                    cur1++;
                }
            }

            curToBeReplaced = (cur1 >= cur2)? cur1 : cur2;
            if (collection.get(curToBeReplaced).compareTo(collection.get(end)) > 0) {
                T temp = collection.get(curToBeReplaced);
                collection.set(curToBeReplaced, collection.get(end));
                collection.set(end, temp);
            }

            quickSort(collection, start, curToBeReplaced-1);
            quickSort(collection, curToBeReplaced, end);
        }
    }
}
