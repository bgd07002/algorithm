package DataStructures.HeapPriorityQueue;

import java.util.ArrayList;

/**
 * Min-heap implementation
 */
public class ArrayHeap<K extends Comparable<K>,D> implements IHeap {

    private ArrayList<Entry<K,D>> heapList;

    public ArrayHeap() {
        heapList = new ArrayList<>();
    }

    @Override
    public void insert(Entry newEntry) {
        heapList.add(newEntry);
        heapify();
    }

    private void heapify() {
        if (heapList.size() == 0)
            return;

        int idxCur = heapList.size()-1;
        while (idxCur > 0) {
            int compare = heapList.get(idxCur).getKey().compareTo(heapList.get((idxCur-1)/2).getKey()) ;
            if (compare >= 0)
                break;
            else {
                Entry<K,D> temp = heapList.get(idxCur);
                heapList.set(idxCur, heapList.get((idxCur-1)/2));
                heapList.set((idxCur-1)/2, temp);
                idxCur = (idxCur-1)/2;
            }
        }
    }

    private void sink() {
        if (heapList.size() == 0)
            return;

        int idxCur = 0;
        while (idxCur < heapList.size()) {
            int leftchild  = 2 * idxCur+1;
            int rightChild = 2 * idxCur+2;

            int smallerIdxChild = -1;
            if (leftchild >= heapList.size() && rightChild < heapList.size())
                smallerIdxChild = rightChild;
            else if (rightChild >= heapList.size() && leftchild < heapList.size())
                smallerIdxChild = leftchild;
            else if (rightChild >= heapList.size() && leftchild >= heapList.size())
                break;
            else
                smallerIdxChild = (heapList.get(leftchild).getKey().compareTo(heapList.get(rightChild).getKey()) > 0) ? rightChild : leftchild;

            if (heapList.get(smallerIdxChild).getKey().compareTo(heapList.get(idxCur).getKey()) < 0) {
                Entry<K,D> temp = heapList.get(idxCur);
                heapList.set(idxCur, heapList.get(smallerIdxChild));
                heapList.set(smallerIdxChild, temp);
                idxCur = smallerIdxChild;
            } else
                break;
        }
    }

    @Override
    public Object remove() {
        return heapList.remove(heapList.size()-1).getValue();
    }

    @Override
    public int getSize() {
        return heapList.size();
    }

    @Override
    public Entry getMin() {
       return heapList.get(0);
    }

    @Override
    public Entry extractMin() {
        Entry<K,D> temp = heapList.get(0);
        heapList.set(0, heapList.get(heapList.size()-1));
        sink();
        heapList.remove(heapList.size()-1);
        return temp;
    }

    @Override
    public String printHeap() {
        StringBuilder sb = new StringBuilder();
        for (Entry<K,D> entry : heapList) {
            sb.append(entry.getKey().toString()).append(", ");
        }
        return sb.toString();
    }
}
