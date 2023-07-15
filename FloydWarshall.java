import java.util.Arrays;

public class FloydWarshall {

    private static final int INF = Integer.MAX_VALUE;

    private int numVertices;
    private int[][] distance;

    public FloydWarshall(int numVertices) {
        this.numVertices = numVertices;
        this.distance = new int[numVertices][numVertices];

        // Initialize distance matrix
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }
    }


    public void addEdge(int source, int destination, int weight) {
        distance[source][destination] = weight;
    }


    public void shortestPaths() {
        
        // Perform Floyd-Warshall algorithm
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distance[i][k] != INF && distance[k][j] != INF &&
                            distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // Print shortest path distances
        printDistances();
    }


    private void printDistances() {
        System.out.println("Shortest path distances:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (distance[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distance[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {

        int numVertices = 4;
        FloydWarshall fw = new FloydWarshall(numVertices);

        fw.addEdge(0, 1, 3);
        fw.addEdge(0, 2, 6);
        fw.addEdge(1, 2, 2);
        fw.addEdge(1, 3, 1);
        fw.addEdge(2, 3, 4);


        fw.shortestPaths();

    }
}
