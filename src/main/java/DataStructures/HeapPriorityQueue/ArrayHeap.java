package DataStructures.HeapPriorityQueue;

import java.util.ArrayList;

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

    @Override
    public D remove() {
        return heapList.remove(heapList.size()-1).getValue();
    }

    @Override
    public int getSize() {
        return heapList.size();
    }

    @Override
    public Entry<K,D> getMin() {
        return heapList.get(0);
    }

    @Override
    public Entry<K,D> extractMin() {
        if (heapList.size() == 0)
            return null;

        Entry<K,D> minElement = heapList.get(0);
        if (heapList.size() > 1) {
            heapList.set(0, heapList.remove(heapList.size()-1));
            sink();
        } else
            heapList.remove(0);

        return minElement;
    }

    @Override
    public String printHeap() {
        StringBuilder sb = new StringBuilder();
        for (Entry<K,D> entry : heapList) {
            sb.append(entry.getKey().toString()).append(", ");
        }
        return sb.toString();
    }

    private int getParentIndex(int nodeIdx) {
        return (nodeIdx-1)/2;
    }

    private int getLeftChildIndex(int nodeIdx) {
        return (2*nodeIdx + 1);
    }

    private int getRightChildIndex(int nodeIdx) {
        return (2*nodeIdx + 2);
    }

    private void heapify() {
        if (heapList == null)
            return;

        int idx = heapList.size()-1;
        int idxParent;

        while (idx > 0) {
            idxParent = getParentIndex(idx);

            int compare = heapList.get(idx).getKey().compareTo(heapList.get(idxParent).getKey());
            if (compare > 0)
                return;
            else {
                Entry<K,D> temp = heapList.get(idxParent);
                heapList.set(idxParent, heapList.get(idx));
                heapList.set(idx, temp);

                idx = idxParent;
            }
        }
    }

    private void sink() {
        if (heapList == null)
            return;

        Entry<K,D> sinkElement = heapList.get(0);
        int cur = 0;

        do{
            int leftChildIdx = getLeftChildIndex(cur);
            int rightChildIdx = getRightChildIndex(cur);

            if (leftChildIdx >= heapList.size() && rightChildIdx >= heapList.size())
                break;

            int compareChildren;
            if (rightChildIdx >= heapList.size())
                compareChildren = -1;
            else if (leftChildIdx >= heapList.size())
                compareChildren = 1;
            else
                compareChildren = heapList.get(leftChildIdx).getKey().compareTo(heapList.get(rightChildIdx).getKey());

            if (compareChildren > 0) {
                int compareKeyToRight = sinkElement.getKey().compareTo(heapList.get(rightChildIdx).getKey());
                if (compareKeyToRight > 0) {
                    heapList.set(cur, heapList.get(rightChildIdx));
                    heapList.set(rightChildIdx, sinkElement);
                    cur = 2*cur+2;
                } else
                    return;
            } else {
                int compareKeyToLeft = sinkElement.getKey().compareTo(heapList.get(leftChildIdx).getKey());
                if (compareKeyToLeft > 0) {
                    heapList.set(cur, heapList.get(leftChildIdx));
                    heapList.set(leftChildIdx, sinkElement);
                    cur = 2*cur+1;
                } else
                    return;
            }
        } while (cur < heapList.size());
    }

}
