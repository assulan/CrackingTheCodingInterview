package chapter4;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by asus on 8/20/17.
 * Adopted from: http://algs4.cs.princeton.edu/42digraph/Digraph.java.html
 * Directed graph implemented as adjacency list.
 */

public class DirectedGraph {
    private int V;  // number of vertices
    private int E;  // number of edges
    private List<Integer>[] adj;  // adjacency list, adj[v] = list of adjacent vertices.

    public DirectedGraph(int V) throws Exception {
        if (V < 0) throw new Exception("Negative number of vertices");
        this.V = V;

        adj = new List[V];
        for (int v = 0; v < V; v++){
            adj[v] = new ArrayList<>();
        }
    }

    // Add directed edge from v to w, i.e. v->w
    public void addEdge(int v, int w) throws Exception {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        E++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++){
            builder.append(String.format("Vertex %d: ", v));
            for (int w : adj[v]){
                builder.append(String.format("%d ", w));
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public List<Integer> adjacent_vertices(int v) throws Exception {
        validateVertex(v);
        return adj[v];
    }

    public int E(){
        return E;
    }

    public int V(){
        return V;
    }

    private void validateVertex(int v) throws Exception {
        if (v < 0 || v > V) throw new Exception("Invalid vertex number");
    }
}
