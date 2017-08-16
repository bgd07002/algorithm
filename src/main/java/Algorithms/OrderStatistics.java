package Algorithms;

import java.util.ArrayList;

/**
 * Goal. Given an array of n items, find the kth smallest item.
 */
public class OrderStatistics<T extends Comparable<T>> {

    private ArrayList<T> collection;

    public OrderStatistics(ArrayList<T> collection) {
        this.collection = collection;
    }

    public T smallestKItem(int k) {
        return smallestKItemHelper(k, 0, collection.size()-1);
    }

    private T smallestKItemHelper(int k, int start, int end) {

        int curToBeReplaced = -1;
        if (start < end ) {
            T pivot = collection.get(end);
            int cur1 = start;
            int cur2 = end-1;

            while(cur1 < cur2) {

                int comparisonCur1 = collection.get(cur1).compareTo(pivot);
                int comparisonCur2 = collection.get(cur2).compareTo(pivot);

                if (comparisonCur1 < 0 && comparisonCur2 > 0) {
                    cur1++;
                    cur2--;
                } else if (comparisonCur1 < 0 && comparisonCur2 < 0) {
                    cur1++;
                } else if (comparisonCur1 > 0 && comparisonCur2 > 0) {
                    cur2--;
                } else {
                    T temp = collection.get(cur1);
                    collection.set(cur1, collection.get(cur2));
                    collection.set(cur2, temp);
                    cur1++;
                    cur2--;
                }
            }

            curToBeReplaced = (cur1 >= cur2)? cur1 : cur2;
            if (collection.get(curToBeReplaced).compareTo(collection.get(end)) > 0) {
                T temp = collection.get(curToBeReplaced);
                collection.set(curToBeReplaced, collection.get(end));
                collection.set(end, temp);
            }

            if (curToBeReplaced == k-1)
                return collection.get(curToBeReplaced);
            else if (start == end-1 && k-1 == end)
                return collection.get(end);
            else if (k-1 < curToBeReplaced)
                return smallestKItemHelper(k, start, curToBeReplaced);
            else
                return smallestKItemHelper(k, curToBeReplaced, end);
        }
        return null;
    }
}
