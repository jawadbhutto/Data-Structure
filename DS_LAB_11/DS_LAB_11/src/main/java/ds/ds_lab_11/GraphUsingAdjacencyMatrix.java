/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_11;

/**
 *
 * @author USER
 */

    import java.util.*;

public class GraphUsingAdjacencyMatrix {

    // Task 2: Display the Adjacency Matrix
    public static void displayAdjacencyMatrix(int matrix[][]) {
        System.out.println("Adjacency Matrix");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Task 3: Find the Shortest Path Between Two Vertices Using BFS
    public static void findShortestPath(int[][] matrix, int start, int destination) {
        int vertices = matrix.length;
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];

        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start - 1); // Convert to 0-based indexing
        visited[start - 1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Check neighbors
            for (int i = 0; i < vertices; i++) {
                if (matrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue.add(i);

                    // Stop when destination is reached
                    if (i == destination - 1) {
                        printShortestPath(parent, start - 1, destination - 1);
                        return;
                    }
                }
            }
        }

        System.out.println("No path exists between " + start + " and " + destination);
    }

    public static void printShortestPath(int[] parent, int start, int destination) {
        List<Integer> path = new ArrayList<>();
        for (int at = destination; at != -1; at = parent[at]) {
            path.add(at + 1); // Convert back to 1-based indexing
        }

        Collections.reverse(path);

        System.out.print("Shortest Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
        System.out.println("Length: " + (path.size() - 1));
    }

    // Task 4: Find All Paths Between Two Vertices
    public static void findAllPaths(int[][] matrix, int start, int destination) {
        List<List<Integer>> allPaths = new ArrayList<>();
        findPathsDFS(matrix, start - 1, destination - 1, new boolean[matrix.length], new ArrayList<>(), allPaths);

        System.out.println("Paths:");
        for (List<Integer> path : allPaths) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print((path.get(i) + 1));
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" (Length: " + (path.size() - 1) + ")");
        }
    }

    private static void findPathsDFS(int[][] matrix, int current, int destination, boolean[] visited, List<Integer> path, List<List<Integer>> allPaths) {
        visited[current] = true;
        path.add(current);

        if (current == destination) {
            allPaths.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[current][i] == 1 && !visited[i]) {
                    findPathsDFS(matrix, i, destination, visited, path, allPaths);
                }
            }
        }

        visited[current] = false;
        path.remove(path.size() - 1);
    }

    // Task 5: Detect Connected Components in an Undirected Graph
    public static void detectConnectedComponents(int[][] matrix) {
        int vertices = matrix.length;
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfsForComponents(matrix, i, visited, component);
                components.add(component);
            }
        }

        System.out.println("Connected Components:");
        for (int i = 0; i < components.size(); i++) {
            System.out.print("Component " + (i + 1) + ": ");
            for (int j = 0; j < components.get(i).size(); j++) {
                System.out.print(components.get(i).get(j) + 1);
                if (j < components.get(i).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private static void dfsForComponents(int[][] matrix, int current, boolean[] visited, List<Integer> component) {
        visited[current] = true;
        component.add(current);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[current][i] == 1 && !visited[i]) {
                dfsForComponents(matrix, i, visited, component);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] matrix = new int[vertices][vertices];

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge (u v): ");
            int u = sc.nextInt();
            int v = sc.nextInt();

            matrix[u - 1][v - 1] = 1;
            //matrix[v - 1][u - 1] = 1; // For undirected graph
        }

        // Display adjacency matrix
        displayAdjacencyMatrix(matrix);

        // Find shortest path
        System.out.print("Enter start vertex for shortest path: ");
        int start = sc.nextInt();
        System.out.print("Enter destination vertex for shortest path: ");
        int destination = sc.nextInt();
        findShortestPath(matrix, start, destination);

        // Find all paths
        System.out.print("Enter start vertex for all paths: ");
        start = sc.nextInt();
        System.out.print("Enter destination vertex for all paths: ");
        destination = sc.nextInt();
        findAllPaths(matrix, start, destination);

        // Detect connected components
        detectConnectedComponents(matrix);

        sc.close();
    }
}
