import java.util.*;


public class Bellman_Ford {

    private static class Edge {

        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private int vertices, edges;
    private Edge[] edgeList;

    public Bellman_Ford(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.edgeList = new Edge[edges];
    }


    public void addEdge(int index, int source, int destination, int weight) {
        edgeList[index] = new Edge(source, destination, weight);
    }

    public void shortestPath(int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;


        // Relax edges repeatedly
        for (int i = 0; i < vertices - 1; i++) {
            for (int j = 0; j < edges; j++) {
                int u = edgeList[j].source;
                int v = edgeList[j].destination;
                int w = edgeList[j].weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }


        // Check for negative cycles
        for (int j = 0; j < edges; j++) {
            int u = edgeList[j].source;
            int v = edgeList[j].destination;
            int w = edgeList[j].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Graph contains negative cycle.");
                return;
            }
        }

        // Print shortest path distances
        printDistances(distance);
    }

    private void printDistances(int[] distance) {
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }


    public static void main(String[] args) {

        int vertices = 5;
        int edges = 8;

        Bellman_Ford graph = new Bellman_Ford(vertices, edges);

        graph.addEdge(0, 0, 1, -1);
        graph.addEdge(1, 0, 2, 4);
        graph.addEdge(2, 1, 2, 3);
        graph.addEdge(3, 1, 3, 2);
        graph.addEdge(4, 1, 4, 2);
        graph.addEdge(5, 3, 2, 5);
        graph.addEdge(6, 3, 1, 1);
        graph.addEdge(7, 4, 3, -3);

        int source = 0;
        graph.shortestPath(source);
        
    }
}
