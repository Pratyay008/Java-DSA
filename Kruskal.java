import java.util.*;


public class Kruskal {

    private static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }


    private int numVertices;
    private List<Edge> edgeList;

    public Kruskal(int numVertices) {
        this.numVertices = numVertices;
        this.edgeList = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edgeList.add(new Edge(source, destination, weight));
    }


    public void minimumSpanningTree() {

        // Sort the edges in non-decreasing order of their weights
        Collections.sort(edgeList, Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            parent[i] = i;
        }


        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edgeList) {
            int root1 = find(parent, edge.source);
            int root2 = find(parent, edge.destination);

            if (root1 != root2) {
                mst.add(edge);
                union(parent, root1, root2);
            }
        }

        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println(edge.source + " -- " + edge.destination + " : " + edge.weight);
        }
    }


    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int root1, int root2) {
        parent[root2] = root1;
    }


    public static void main(String[] args) {
        int numVertices = 5;
        Kruskal kruskal = new Kruskal(numVertices);

        kruskal.addEdge(0, 1, 2);
        kruskal.addEdge(0, 3, 6);
        kruskal.addEdge(1, 2, 3);
        kruskal.addEdge(1, 3, 8);
        kruskal.addEdge(1, 4, 5);
        kruskal.addEdge(2, 4, 7);
        kruskal.addEdge(3, 4, 9);

        kruskal.minimumSpanningTree();
        
    }
}
