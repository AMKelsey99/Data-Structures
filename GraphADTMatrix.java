/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphadtmatrix;

/**
 *
 * @author alana
 */
public class GraphADTMatrix {
    vertex Matrix[][];
    int size;
    
    public GraphADTMatrix(int n) {
        this.size =  n;
        Matrix = new vertex[size][size];
    }
    
    public int numVertices() {
    return size;
    }

            
class vertex {
        String vertexName;
        int value;
        vertex next;
        
        public vertex(int v, String vertexName) {
            this.vertexName = vertexName;
            this.value = v;
            this.next = null;
        }
        
        public void setNext(vertex v) {
            this.next = v;
        }
    }

public void addEdge(int i, int ii, String n) {
    vertex v = new vertex(i,n);
    Matrix[i][ii] = v;
    Matrix[ii][i] = v;
}

public void removeEdgeBoolean(int i, int ii) {
    Matrix[i][ii] = null;
    Matrix[ii][i] = null;
}

public void printGraph() {
    for (int i=0; i<size;i++) {
        for (int j = 0; j<size; j++) {
            if (Matrix[i][j] != null) {
            System.out.print(Matrix[i][j].vertexName + " ");
            } else {
                System.out.print("[]" + " ");
            }
        }
        System.out.println();
    }
}



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GraphADTMatrix g = new GraphADTMatrix(4);
       g.addEdge(0, 2, "A");
       g.addEdge(3, 2, "B");
       g.addEdge(0, 1, "C");
       g.addEdge(2, 1, "D");
       g.addEdge(0, 3, "E");
       g.printGraph();
    }
    
}
