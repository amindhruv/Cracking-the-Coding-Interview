package Trees_Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        System.out.print("Enter start and end node between 1 to " + graph.vertices + ": ");
        Scanner in = new Scanner(System.in);
        int start = in.nextInt(), end = in.nextInt();
        in.close();
        System.out.println("There is " + (isRoute(graph, start - 1, end - 1) ? "a " : "no ") + "route between node " + start + " & " + end);
    }

    private static boolean isRoute(Graph graph, int start, int end) {
        if (start == end) return true;
        boolean[] visited = new boolean[graph.vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int neighbor : graph.neighbors[vertex]) {
                if (neighbor == end) return true;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
