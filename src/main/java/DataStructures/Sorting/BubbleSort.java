package DataStructures.Sorting;

import java.util.ArrayList;

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

        //5 1 4 2 8
        while (cur2 < collection.size()) {
            if (collection.get(cur1).compareTo(collection.get(cur2)) > 0) {
                isSorted = false;
                T temp = collection.get(cur2);
                collection.set(cur2, collection.get(cur1));
                collection.set(cur1, temp);
            }
            cur1++;
            cur2++;
        }
        return isSorted? true: bubbleSort(collection);
    }























    /*
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
    */
}
