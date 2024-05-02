import java.util.*;

public class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Add an edge to the graph
    void addEdge(int v, int w) {
        if (v >= 0 && v < V && w >= 0 && w < V) {
            adj[v].add(w);
        } else {
            throw new IllegalArgumentException("Invalid edge: " + v + " -> " + w);
        }
    }

    // BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s.
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of vertices: ");
            int V = scanner.nextInt();
            if (V <= 0) {
                throw new IllegalArgumentException("Number of vertices must be positive.");
            }

            Graph g = new Graph(V);

            System.out.println("Enter the number of edges: ");
            int E = scanner.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("Number of edges must be non-negative.");
            }

            System.out.println("Enter the edges (source destination): ");
            for (int i = 0; i < E; i++) {
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                g.addEdge(source, destination);
            }

            System.out.print("Enter the starting vertex for BFS: ");
            int startVertex = scanner.nextInt();
            if (startVertex < 0 || startVertex >= V) {
                throw new IllegalArgumentException("Starting vertex is out of bounds.");
            }

            System.out.println("BFS Traversal starting from vertex " + startVertex + ":");
            g.BFS(startVertex);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
