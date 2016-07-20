package Sorting;

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

        ArrayList<T> sortedList = new ArrayList();

        int i = start;
        int j = mid+1;
        while (i <= mid && j <= end) {
            int compare = collection.get(i).compareTo(collection.get(j));
            if (compare > 0) {
                sortedList.add(collection.get(j++));
            } else {
                sortedList.add(collection.get(i++));
            }
        }

        while (i <= mid) {
            sortedList.add(collection.get(i++));
        }

        while (j <= end) {
            sortedList.add(collection.get(j++));
        }

        int cur = start;
        for (T el : sortedList) {
            collection.set(cur++, el);
        }
    }
}
