import java.util.*;

public class HamiltonianPath {

    private int numVertices;
    private int[] path;
    private boolean[] visited;
    private int[][] graph;

    public HamiltonianPath(int[][] graph) {
        this.numVertices = graph.length;
        this.path = new int[numVertices];
        this.visited = new boolean[numVertices];
        this.graph = graph;
    }

    public void findHamiltonianPath() {
        path[0] = 0; // Start with the first vertex

        if (hamiltonianPathUtil(1)) {
            System.out.println("Hamiltonian path exists:");
            printPath();
        } else {
            System.out.println("No Hamiltonian path exists.");
        }
    }


    private boolean hamiltonianPathUtil(int position) {

        if (position == numVertices) {
            // All vertices have been included in the path
            // Check if there is an edge from the last vertex to the first vertex
            if (graph[path[position - 1]][path[0]] == 1) {
                return true;
            }
            return false;
        }


        for (int vertex = 1; vertex < numVertices; vertex++) {
            if (isSafe(vertex, position)) {
                path[position] = vertex;
                visited[vertex] = true;

                if (hamiltonianPathUtil(position + 1)) {
                    return true;
                }

                // Backtracking
                path[position] = -1;
                visited[vertex] = false;
            }
        }

        return false;
    }


    private boolean isSafe(int vertex, int position) {
        // Check if the vertex is adjacent to the previously added vertex
        if (graph[path[position - 1]][vertex] == 0) {
            return false;
        }

        // Check if the vertex has already been visited
        if (visited[vertex]) {
            return false;
        }

        return true;
    }


    private void printPath() {
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
        System.out.println(path[0]); // Print the first vertex again to complete the cycle
    }



    public static void main(String[] args) {

        // No path
        int[][] graph1 = {
            {0, 1, 1, 1, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0}
        };

        HamiltonianPath hp1 = new HamiltonianPath(graph1);
        hp1.findHamiltonianPath();


        // Path exists
        int[][] graph2 = {
            { 0, 1, 1, 1, 0 },
            { 1, 0, 1, 0, 1 },
            { 1, 1, 0, 1, 1 },
            { 1, 0, 1, 0, 0 }
        };

        HamiltonianPath hp2 = new HamiltonianPath(graph2);
        hp2.findHamiltonianPath();
        
    }
}
