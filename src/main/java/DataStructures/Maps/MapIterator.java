package DataStructures.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapIterator<K,T> implements Iterator<Entry<K,T>> {

    private ArrayList<List<Entry<K,T>>> bucketList;
    private int listIdx;
    private int bucketIdx;

    public MapIterator(ArrayList<List<Entry<K,T>>> bucketList) {
        this.bucketList = bucketList;

        int i= 0;
        while (i < bucketList.size()) {
            if (bucketList.get(i) != null && bucketList.get(i).size() >0) {
                listIdx = i;
                bucketIdx =0;
                return;
            }
            i++;
        }
    }

    @Override
    public boolean hasNext() {
        return (listIdx < bucketList.size() &&
                //bucketList.get(listIdx)!= null &&
                bucketList.get(listIdx).get(bucketIdx) != null);
    }

    @Override
    public Entry<K,T> next() {
        Entry<K,T> temp = bucketList.get(listIdx).get(bucketIdx);

        if (bucketIdx < bucketList.get(listIdx).size()-1)
            bucketIdx++;
        else {
            while (++listIdx < bucketList.size()) {
                if (bucketList.get(listIdx) != null && bucketList.get(listIdx).size() > 0) {
                    bucketIdx =0;
                    break;
                }
            }
        }
        return temp;
    }
}
