package DataStructures.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapIteratorSeparateChaining<K,T> implements Iterator<Entry<K,T>> {

    private ArrayList<List<Entry<K,T>>> bucketList;
    private int listIdx;
    private int bucketIdx;

    public MapIteratorSeparateChaining(ArrayList<List<Entry<K,T>>> bucketList) {
        this.bucketList = bucketList;

        int i= 0;
        while (i < bucketList.size()) {
            if (bucketList.get(i) != null && bucketList.get(i).size() > 0) {
                listIdx = i;
                bucketIdx =0;
                return;
            }
            i++;
        }
    }

    @Override
    public boolean hasNext() {
        return (listIdx < bucketList.size() && bucketIdx < bucketList.get(listIdx).size());
    }

    @Override
    public Entry<K,T> next() {
        Entry<K,T> temp = bucketList.get(listIdx).get(bucketIdx);

        if (bucketIdx < bucketList.get(listIdx).size()-1)
            bucketIdx++;
        else {
            listIdx++;
            while (listIdx < bucketList.size()) {
                if (bucketList.get(listIdx).size() > 0) {
                    bucketIdx =0;
                    break;
                }
                listIdx++;
            }
        }
        return temp;
    }
}
