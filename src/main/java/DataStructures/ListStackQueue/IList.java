package DataStructures.ListStackQueue;

public abstract class IList<T extends Comparable<T>> {

    public abstract void addFirst(T element);
    public abstract void addLast(T element);
    public abstract T removeFirst();
    public abstract T removeLast();
    public abstract void remove(T objValue);
    public abstract int size();
    public abstract Node<T> getHead();

    public boolean isEmpty() { return this.size() == 0; }

    public String printElements() {
        StringBuilder sb = new StringBuilder("[");
        ListIterator<T> it = new ListIterator<>(this);
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext())
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
