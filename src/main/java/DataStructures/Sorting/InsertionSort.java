package DataStructures.Sorting;

import java.util.ArrayList;

public class InsertionSort<T extends Comparable<T>> implements ISorter<T> {

    public void sortList(ArrayList<T> collection) {

        if (collection == null || collection.size() < 2)
            return;

        for (int i=1; i< collection.size(); i++) {
            for (int j = i; j > 0; j--) {

                int compareResult  = (collection.get(j)).compareTo(collection.get(j-1));

                if (compareResult < 0) {
                    T temp = collection.get(j);
                    collection.set(j, collection.get(j-1));
                    collection.set(j-1, temp);
                }
                else {
                    break;
                }
            }
        }
    }
}
