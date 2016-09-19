package DataStructures.Maps;


public interface IMap<K,T> {
    int getSize();
    boolean isEmpty();
    T get(K key);
    void put(K key,T value);
    T remove(K key);

    String printKeys();
    String printValues();
}
