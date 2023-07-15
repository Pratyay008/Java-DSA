import java.util.Arrays;
import java.util.PriorityQueue;


public class Dijkstra {

    private static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private int vertices;
    private Edge[] edgeList;
    private int[] distance;
    private boolean[] visited;

    public Dijkstra(int vertices, int edges) {
        this.vertices = vertices;
        this.edgeList = new Edge[edges];
        this.distance = new int[vertices];
        this.visited = new boolean[vertices];
    }


    public void addEdge(int index, int source, int destination, int weight) {
        edgeList[index] = new Edge(source, destination, weight);
    }


    public void shortestPath(int source) {

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll();
            visited[currentVertex] = true;

            for (Edge edge : edgeList) {
                if (edge.source == currentVertex && !visited[edge.destination]) {
                    int newDistance = distance[currentVertex] + edge.weight;
                    if (newDistance < distance[edge.destination]) {
                        distance[edge.destination] = newDistance;
                        priorityQueue.add(edge.destination);
                    }
                }
            }
        }

        printDistances();
    }

    private void printDistances() {
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }



    public static void main(String[] args) {

        int vertices = 6;
        int edges = 9;

        Dijkstra graph = new Dijkstra(vertices, edges);

        graph.addEdge(0, 0, 1, 4);
        graph.addEdge(1, 0, 2, 3);
        graph.addEdge(2, 1, 2, 1);
        graph.addEdge(3, 1, 3, 2);
        graph.addEdge(4, 2, 3, 4);
        graph.addEdge(5, 2, 4, 3);
        graph.addEdge(6, 3, 4, 2);
        graph.addEdge(7, 3, 5, 1);
        graph.addEdge(8, 4, 5, 5);

        int source = 0;
        graph.shortestPath(source);
        
    }
}
