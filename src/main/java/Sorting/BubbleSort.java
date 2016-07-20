package Sorting;

import java.util.ArrayList;

/**
 * Created by bdundar on 6/15/2016.
 */
public class BubbleSort<T extends Comparable<T>> implements ISorter<T>  {

    public void sortList(ArrayList<T> collection) {
        if (collection == null || collection.size() < 2)
            return;

        bubbleSort(collection);
    }

    boolean bubbleSort(ArrayList<T> collection) {
        boolean isSorted = true;
        int cur1 = 0;
        int cur2 = 1;

        while (cur2 < collection.size()) {
            int compare = collection.get(cur1).compareTo(collection.get(cur2));

            if (compare > 0) {
                T temp = collection.get(cur1);
                collection.set(cur1, collection.get(cur2));
                collection.set(cur2, temp);
                isSorted = false;
            }
            cur1++;
            cur2++;
        }

        return (isSorted)? true : bubbleSort(collection);
    }
}
