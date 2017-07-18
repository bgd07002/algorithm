package DataStructures.Sorting;

import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>> implements ISorter<T> {

    public void sortList(ArrayList<T> collection) {
        mergeSort(collection, 0, collection.size()-1);
    }

    private void mergeSort(ArrayList<T> collection, int start, int end) {
        if (start < end) {
            int mid = (start + end)/2;
            mergeSort(collection, start, mid);
            mergeSort(collection, mid+1, end);
            merge(collection, start, end, mid);
        }
    }

    private void merge(ArrayList<T> collection, int start, int end, int mid) {

        ArrayList<T> sortedCollection = new ArrayList<>();
        int cur1 = start;
        int cur2 = mid+1;

        while (cur1 <= mid && cur2 <= end) {
            if (collection.get(cur1).compareTo(collection.get(cur2)) < 0)
                sortedCollection.add(collection.get(cur1++));
            else
                sortedCollection.add(collection.get(cur2++));
        }

        while (cur1 <= mid)
            sortedCollection.add(collection.get(cur1++));

        while (cur2 <= end)
            sortedCollection.add(collection.get(cur2++));

        int i = start;
        for (T element : sortedCollection)
            collection.set(i++, element);
    }
}
