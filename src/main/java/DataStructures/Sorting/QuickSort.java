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

    public void sortThreeWayPartition(ArrayList<T> collection) {
        if (collection == null || collection.size() < 2)
            return;
        sortThreeWayPartitionHelper(collection, 0, collection.size()-1);
    }

    private void sortThreeWayPartitionHelper(ArrayList<T> collection, int start, int end) {

        int lt = start;
        int gt = end-1;

        // ---<v-- lt --=v---- i ---gt--- >v ---||pivot
        if (gt <= lt)
            return;

        T pivot = collection.get(end);
        int i =start;
        while (i <= gt) {
            int compare = collection.get(i).compareTo(pivot);
            //Exchange col[lt] with col[i]; increment both lt and i
            if (compare < 0) {
                T temp = collection.get(lt);
                collection.set(lt, collection.get(i));
                collection.set(i, temp);
                lt++;
                i++;
            }
            //if col[i]>v, exchange col[gt] with col[i], decrement gt
            else if (compare > 0) {
                T temp = collection.get(gt);
                collection.set(gt, collection.get(i));
                collection.set(i, temp);
                gt--;
            }
            //if col[i] == v, increment i
            else
                i++;
        }

        //Now exchange position i and pivot element
        collection.set(end, collection.get(i));
        collection.set(i, pivot);

        //Iteration is done. Now take care of recursion
        sortThreeWayPartitionHelper(collection, start, lt-1);
        sortThreeWayPartitionHelper(collection, gt+1, end);
    }

}
