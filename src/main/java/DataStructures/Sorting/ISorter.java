package DataStructures.Sorting;

import java.util.ArrayList;

public interface ISorter<T extends Comparable<? super T>>{
    void sortList(ArrayList<T> collection);
}
