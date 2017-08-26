package chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asus on 8/20/17.
 * Find if there is a route between two nodes in directed graph.
 */
public class Challenge4_2 {
    public static DirectedGraph addEdges(DirectedGraph graph) throws Exception {
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 2);
        graph.addEdge(5, 4);
        graph.addEdge(6, 9);
        graph.addEdge(6, 4);
        graph.addEdge(6, 8);
        graph.addEdge(6, 0);
        graph.addEdge(7, 6);
        graph.addEdge(7, 9);
        graph.addEdge(8, 6);
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(10, 12);
        graph.addEdge(11, 4);
        graph.addEdge(11, 12);
        graph.addEdge(12, 9);
        return graph;
    }

    // Return true if there is a path between vertices v and w.
    // BFS search with a queue.
    public static boolean existsPath(DirectedGraph graph, int v, int w) throws Exception {
        Queue<Integer> queue = new LinkedList<>();

        for (int ww : graph.adjacent_vertices(v)){
            if (ww == w) return true;
            queue.add(ww);
        }
        while (!queue.isEmpty()){
            int ww = queue.poll();
            if (ww == w) return true;
            for (int n : graph.adjacent_vertices(ww)){
                if (n == w) return true;
                queue.add(n);
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        DirectedGraph graph = new DirectedGraph(13);
        System.out.println(graph);
        graph = addEdges(graph);
        System.out.println(graph);

        System.out.println(existsPath(graph, 8, 9));
    }
}
