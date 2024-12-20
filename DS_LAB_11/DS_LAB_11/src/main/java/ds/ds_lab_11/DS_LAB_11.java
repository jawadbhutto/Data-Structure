/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ds.ds_lab_11;

/**
 *
 * @author USER
 */
import java.util.*;
import java.util.Scanner;
public class DS_LAB_11 {
   
   //AdjacencyMatrixGraph
    //Task 2
    public static void DisplayAdjacencyMatrix(int matrix[][]){
        System.out.println("Adjacency Matrix");
        
        for(int i=0; i<matrix.length; i++){
             for(int j=0;j<matrix[0].length; j++){
                 System.out.print(matrix[i][j]+" ");
             }
             System.out.println("");
         }
        
    }
    
    public static void main(String[] args) {
       // System.out.println("Hello World!");
        
         Scanner sc = new Scanner(System.in);
         
         System.out.print("Enter number of vertices: ");
         int vertices = sc.nextInt();
         
         int matrix[][] = new int[vertices][vertices];
         
        
         for(int i=0; i<vertices; i++){
             System.out.println("Enter Vertices "+(i+1)+" Edges:");
             System.out.print("edge 1: ");
             int u = sc.nextInt();
             System.out.print("edge 2: ");
             int v = sc.nextInt();
             
             matrix[u-1][v-1] = 1;            
         }
        
//         for(int i=0; i<matrix.length; i++){
//             for(int j=0;j<matrix[0].length; j++){
//                 System.out.print(matrix[i][j]+" ");
//             }
//             System.out.println("");
//         }

           DisplayAdjacencyMatrix(matrix);
           
           findShortestPath(matrix,1,4);
        
    }
    
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
}
