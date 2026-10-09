package dataStructureAnalyzer;

import java.util.*;

public class GraphOperations {

    private final Map<Integer, List<Integer>> graph = new TreeMap<>();

    // Add a new vertex
    public void addVertex(int vertex) {
        if (graph.containsKey(vertex)) {
            System.out.println("Vertex already exists: " + vertex);
            return;
        }

        graph.put(vertex, new ArrayList<>());
        System.out.println("Vertex added successfully: " + vertex);
    }

    // Add a directed edge
    public void addEdge(int source, int destination) {
        if (source == destination) {
            System.out.println("Self-loop is not allowed.");
            return;
        }

        if (!graph.containsKey(source)) {
            addVertex(source);
        }

        if (!graph.containsKey(destination)) {
            addVertex(destination);
        }

        if (graph.get(source).contains(destination)) {
            System.out.println("Edge already exists.");
            return;
        }

        graph.get(source).add(destination);
        Collections.sort(graph.get(source));

        System.out.println("Edge added successfully: "
                + source + " -> " + destination);
    }

    // Display graph and statistics
    public void displayGraph() {
        if (graph.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\nGraph (Adjacency List):");

        for (Map.Entry<Integer, List<Integer>> entry
                : graph.entrySet()) {
            System.out.println(entry.getKey() + " -> "
                    + entry.getValue());
        }

        System.out.println("Total vertices: " + getVertexCount());
        System.out.println("Total edges: " + getEdgeCount());
    }

    // Breadth First Search
    public void bfs(int startVertex) {
        if (!graph.containsKey(startVertex)) {
            System.out.println("Vertex not found: " + startVertex);
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startVertex);
        visited.add(startVertex);

        System.out.print("BFS Traversal [Start: "
                + startVertex + "]: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbour : graph.get(current)) {
                if (visited.add(neighbour)) {
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println();
    }

    // Depth First Search
    public void dfs(int startVertex) {
        if (!graph.containsKey(startVertex)) {
            System.out.println("Vertex not found: " + startVertex);
            return;
        }

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal [Start: "
                + startVertex + "]: ");

        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    // Recursive DFS helper
    private void dfsRecursive(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbour : graph.get(vertex)) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }

    // Count vertices
    public int getVertexCount() {
        return graph.size();
    }

    // Count directed edges
    public int getEdgeCount() {
        int count = 0;

        for (List<Integer> neighbours : graph.values()) {
            count += neighbours.size();
        }

        return count;
    }

    // Check whether a vertex exists
    public boolean containsVertex(int vertex) {
        return graph.containsKey(vertex);
    }

    // Check whether a directed edge exists
    public boolean containsEdge(int source, int destination) {
        return graph.containsKey(source)
                && graph.get(source).contains(destination);
    }

    // Check whether the graph is empty
    public boolean isEmpty() {
        return graph.isEmpty();
    }
}

