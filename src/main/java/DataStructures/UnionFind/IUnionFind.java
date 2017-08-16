package DataStructures.UnionFind;

public interface IUnionFind {
    void union(int p, int q);
    void disconnect(int p, int q);
    int find(int p);
    boolean connected(int p, int q);
}
