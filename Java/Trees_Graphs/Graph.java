package Trees_Graphs;

import java.util.LinkedList;

public class Graph {
    int vertices;
    LinkedList<Integer>[] neighbors;

    Graph(int vertices) {
        this.vertices = vertices;
        this.neighbors = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            this.neighbors[i] = new LinkedList<>();
    }

    public void addEdge(int start, int end) {
        this.neighbors[start].add(end);
    }
}
