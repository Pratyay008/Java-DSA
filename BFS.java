import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private static class Graph {

        private int vertices;
        private LinkedList<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
        }


        public void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices];

            Queue<Integer> queue = new LinkedList<>();
            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                LinkedList<Integer> adjacentVertices = adjacencyList[currentVertex];
                for (int adjacentVertex : adjacentVertices) {
                    if (!visited[adjacentVertex]) {
                        visited[adjacentVertex] = true;
                        queue.add(adjacentVertex);
                    }
                }
            }
        }
    }
    

    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        System.out.println("BFS traversal starting from vertex 0:");
        graph.bfs(0);
        System.out.println();
        
    }
}
