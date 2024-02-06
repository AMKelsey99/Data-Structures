/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphadt;
import java.util.*;
/**
 *
 * @author alana
 */
public class GraphADT<E> {
int size;
LinkedList<edge> edgeList[];
LinkedList<vertex> adjList[];

public GraphADT(int s) {
    this.size = s;
    edgeList = new LinkedList[s];
    adjList = new LinkedList[s];
    
    //create the graph 
    for (int i = 0; i < s; i++) {
        edgeList[i] = new LinkedList<>();
        adjList[i] = new LinkedList<>();
    }
}

class edge<E> {
    int v;
    int v2;
    vertex node1;
    vertex node2;
    
    public edge(vertex v, vertex v2) {
        this.v = v.value;
        this.v2 = v2.value;
        node1 = v;
        node2 = v2;
    }
    
    public void setFirst(vertex n) {
        node1 = n;
    }
    
    public void setDest(vertex n) {
        node2 = n;
    }
    
}

    class vertex {
        int value;
        vertex next;
        
        public vertex(int v) {
            this.value = v;
            this.next = null;
        }
        
        public void setNext(vertex v) {
            this.next = v;
        }
    }

    /*
public void createListEdge(int i, int ii) {
    vertex source = new vertex(i);
    vertex dest = new vertex(ii);
    edge e = new edge(source,dest);
    edgeList[e.v].add(e);
}*/

public void createListAdj(int i, int ii) {
    vertex source = new vertex(i);
    vertex dest = new vertex(ii);
    edge ed = new edge(source, dest);
    adjList[source.value].addFirst(source);
    adjList[dest.value].addFirst(dest);
    edgeList[ed.v].add(ed);
    source.setNext(dest);
}

/*
//prints each linked list
public void printEdgeGraph() {
    for (int i = 0; i < size; i++) {
        if(edgeList[i].size()>0) {
            System.out.print("\nnode " + i + " connects to nodes: ");
            for (int ii = 0; ii < edgeList[i].size(); ii++) {
                if (edgeList[i].get(ii) != null) {
                System.out.print(edgeList[i].get(ii).v2 + " ");
                }
            }
        }
    }
} */

public void printAdjGraph() {
    for (int i = 0; i < size; i++) {
        if(adjList[i].size() > 0) {
            System.out.print("\n" + i + " --> ");
            for (int ii = 0; ii < adjList[i].size(); ii++) {
                if (adjList[i].get(ii).next != null) {
                System.out.print(adjList[i].get(ii).next.value + " ");
                }
            }
        }
    }
}

public void printVertices() {
    for (LinkedList<vertex> v : adjList) {
        System.out.println(v.element().value);
    }
}

public LinkedList<vertex>[] vertices() {
    return adjList;
}

public LinkedList<edge>[] edges() {
    return edgeList;
}

public edge getEdge(int u, int v) {
    edge ed = null;
    for (LinkedList<edge> e : edgeList) {
        if (e.element().v == u && e.element().v2 == v)
        ed = e.element();
    }
    return ed;
}

public vertex removeVertex(vertex r) {
    vertex ve = null;
    for (LinkedList<vertex> v : adjList) {
        if (v.element() == r) {
            ve = v.element();
            v.remove(v.element());
        }
    }
    return ve;
}

public edge removeEdge(edge r) {
    edge ed = null;
    for (LinkedList<edge> e : edgeList) {
        if (e.element() == r) {
            ed = e.element();
            e.remove(e.element());
        }
    }
    return ed;
}

public int numVertices() {
    int i = 0;
    for (LinkedList<vertex> v : adjList) {
        i++;
    }
    return i;
}

public int numEdges() {
    int i = 0;
    for (LinkedList<edge> e : edgeList) {
        i++;
    }
    return i;
}

    public static void main(String[] args) {
    
        //System.out.println("Get edge example:" + g1.getEdge(2, 3).v + "," + g1.getEdge(2, 3).v2);
        
     
        GraphADT g2 = new GraphADT(4);
        g2.createListAdj(1, 2);
        g2.createListAdj(2, 3);
        g2.createListAdj(3, 1);
        g2.createListAdj(2, 0);
        g2.createListAdj(0, 1);
        g2.createListAdj(3, 0);
        g2.printAdjGraph();
        //System.out.println("");
        //g2.printVertices();
    }
    
}
