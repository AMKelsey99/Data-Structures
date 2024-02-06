/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listgraph;
import java.util.*;
/**
 *
 * @author alana
 */
public class ListGraph {

    
    class edge {
        int u;
        int v;
        int w;
        
        public edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    class listGraph {
        static class node {
            int v;
            int w;
            
            node(int v, int w) {
                this.v = v;
                this.w = w;
            }
        }
        
        List<List<node>> adjList = new LinkedList<>();
        
        public graph(List<edge> edges) {
            for (int i = 0; i < edges.size)
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
