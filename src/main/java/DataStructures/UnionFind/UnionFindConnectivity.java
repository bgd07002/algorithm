package DataStructures.UnionFind;

/**
 * Given a set of N objects, support two operation:
 * * Connect two objects.
 * * Is there a path connecting the two objects?
 */
public class UnionFindConnectivity implements IUnionFind {

    private int[] connnectivityVector;

    /**
     * Initialize union-find data structure with N singleton objects (0 to N – 1)
     */
    public UnionFindConnectivity(int[] connnectivityVector) {
        this.connnectivityVector = connnectivityVector;
    }

    /**
     * Union: Replace components containing objects p and q with their union
     */
    @Override
    public void union(int p, int q) {
        if (connected(p,q))
            return;

        int component_of_P = connnectivityVector[p];
        for (int i=0; i<connnectivityVector.length; i++)
            if (connnectivityVector[i] == connnectivityVector[q])
                connnectivityVector[i] = component_of_P;
    }

    @Override
    public void disconnect(int p, int q) {
        if (!connected(p,q))
            return;

        int maxComponentNumber = 0;
        for (int i=0; i < connnectivityVector.length; i++) {
            if (connnectivityVector[i] > maxComponentNumber)
                maxComponentNumber = connnectivityVector[i];
        }
        connnectivityVector[q] = maxComponentNumber + 1;
    }

    /**
     * Find: In which component is object p ?
     */
    @Override
    public int find(int p) {
        return connnectivityVector[p];
    }

    /**
     * Connected: Are objects p and q in the same component?
     */
    @Override
    public boolean connected(int p, int q) {
        return connnectivityVector[p] == connnectivityVector[q];
    }
}
