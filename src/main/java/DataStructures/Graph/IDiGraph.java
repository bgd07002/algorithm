package DataStructures.Graph;

import java.util.ArrayList;

public interface IDiGraph<Vertex,Arc> {

    ArrayList<Vertex> vertices();
    ArrayList<Arc> edges();
    //Iterator<Vertex> incident(Vertex v);
    Vertex opposite(Vertex v, Arc e);
    Vertex[] endVertices(Arc e);
    boolean  areAdjacent(Vertex v1, Vertex v2);
    Object updateVertex(Vertex v, Object data);
    Object updateArc(Arc e, Object data);
    Vertex insertVertex(Object data);
    Arc insertEdge(Vertex v1, Vertex v2, Object data);
    Object removeVertex(Vertex v);
    Object removeEdge(Arc e);
}
