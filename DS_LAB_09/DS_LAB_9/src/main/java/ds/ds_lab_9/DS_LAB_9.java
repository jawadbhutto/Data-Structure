/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ds.ds_lab_9;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author USER
 */
public class DS_LAB_9 {
Node root;

    DS_LAB_9(int data){
       this.root = new Node(data);
    }
    
    public void PostOrderDisplay(Node newNode){
        if(newNode != null){
        System.out.print(" "+newNode.data);
        if(newNode.left!=null){
            PostOrderDisplay(newNode.left);
        }
        if(newNode.right != null){
            PostOrderDisplay(newNode.right);
        }
        }   
    }
    
    public void PreOrderDisplay(Node newNode){
        if(newNode != null){
        if(newNode.left!=null){
            PreOrderDisplay(newNode.left);
        }
        if(newNode.right != null){
            PreOrderDisplay(newNode.right);
        }
        System.out.print(" "+newNode.data);
        }   
    }
    
    public void InOrderDisplay(Node newNode){
        if(newNode != null){
        if(newNode.left!=null){
            InOrderDisplay(newNode.left);
        }
        System.out.print(" "+newNode.data);
        if(newNode.right != null){
            InOrderDisplay(newNode.right);
        }
        }   
    }
    
public void LevelOrderDisplay(Node newNode){
        if(newNode == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(newNode);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(" " + current.data);

            if(current.left != null){
                queue.add(current.left);
            }

            if(current.right != null){
                queue.add(current.right);
            }
        }
    }
    
    
    public static void main(String[] args) {
      //  System.out.println("Hello World!");
      
      DS_LAB_9 tree= new DS_LAB_9(1);
      
      Node B = new Node(2);
      Node C = new Node(3);
      
      tree.root.left = B;
      tree.root.right = C;
      Node D = new Node(4);
      Node E = new Node(5);
      Node F = new Node(6);
      Node G = new Node(7);
      
      B.left = D;
      B.right = E;
      
      C.left = F;
      C.right = G;
        System.out.println(" Post Order");
      tree.PostOrderDisplay(tree.root);
        System.out.println("\nPre Order ");
      tree.PreOrderDisplay(tree.root);
        System.out.println("\nIn Order");
       tree.InOrderDisplay(tree.root);
       System.out.println("\nLevel Order");
       tree.LevelOrderDisplay(tree.root);
      
    }
}
