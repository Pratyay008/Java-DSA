import java.util.*;

public class M_Coloring {

    private int[][] graph;
    private int numVertices;
    private int numColors;
    private int[] color;

    public M_Coloring(int[][] graph, int numColors) {
        this.graph = graph;
        this.numVertices = graph.length;
        this.numColors = numColors;
        this.color = new int[numVertices];
    }


    public void solve() {
        if (colorGraph(0)) {
            System.out.println("Graph can be colored using " + numColors + " colors:");
            printColors();
        } else {
            System.out.println("Graph cannot be colored using " + numColors + " colors.");
        }
    }

    private boolean colorGraph(int vertex) {
        if (vertex == numVertices) {
            return true; // All vertices have been assigned a color
        }

        for (int c = 1; c <= numColors; c++) {
            if (isSafe(vertex, c)) {
                color[vertex] = c;

                if (colorGraph(vertex + 1)) {
                    return true;
                }

                color[vertex] = 0; // Backtracking
            }
        }

        return false; // No valid color found for the vertex
    }

    private boolean isSafe(int vertex, int currentColor) {
        for (int v = 0; v < numVertices; v++) {
            if (graph[vertex][v] == 1 && color[v] == currentColor) {
                return false; // Adjacent vertices have the same color
            }
        }
        return true;
    }

    private void printColors() {
        for (int v = 0; v < numVertices; v++) {
            System.out.println("Vertex " + v + ": Color " + color[v]);
        }
    }


    public static void main(String[] args) {
        
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };
        int numColors = 3;

        M_Coloring M_Coloring = new M_Coloring(graph, numColors);
        M_Coloring.solve();

    }
}
