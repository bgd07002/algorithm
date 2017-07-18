package DataStructures.Sorting;

import java.util.ArrayList;

public class SelectionSort <T extends Comparable<T>> implements ISorter<T> {

    /**
     * Complexity-> (N-1)+(N-2)+...+1 ~ O(N^2)
     * If input sorted => O(N^2)
     * Partially sorted => O(N^2)
     */
    @Override
    public void sortList(ArrayList<T> collection) {
        if (collection == null || collection.size() < 2)
            return;

        for (int i=0; i < collection.size(); i++) {
            for (int j = i+1; j< collection.size(); j++) {
                if (collection.get(i).compareTo(collection.get(j)) > 0) {
                    T temp = collection.get(i);
                    collection.set(i, collection.get(j));
                    collection.set(j, temp);
                }
            }
        }
    }
}
