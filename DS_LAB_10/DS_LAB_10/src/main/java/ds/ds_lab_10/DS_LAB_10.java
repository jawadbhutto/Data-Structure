/*+
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ds.ds_lab_10;

/**
 *
 * @author USER
 */
import java.util.Queue;
import java.util.LinkedList;

public class DS_LAB_10 {
   int count=0; 
    Node root;
    
    public static Node insert(Node node,int data){
        
        if(node == null){
            return new Node(data);
        }
        
        if(data < node.data){
           node.left =  insert(node.left,data);
        }
        if(data > node.data){
           node.right = insert(node.right,data);
        }
        return node;
    }
    
    public static void InOrder(Node node){
        if(node == null){
            return;
        }
        InOrder(node.left);
        System.out.print(node.data+" ");
        InOrder(node.right);
    }
    
    public static void PreOrder(Node node){
        if(node == null){
            System.out.println("");
            return;
        }
        System.out.print(node.data+" ");
        PreOrder(node.left);
        PreOrder(node.right);
    }
    
    public static void PostOrder(Node node){
        if(node == null){
            System.out.println("");
            return;
        }
        PostOrder(node.left);
        System.out.print(node.data+" ");
        PostOrder(node.right);
    }
    
    public static void LevelOrder(Node node){
        if(node == null){
            System.out.println("");
            return;
        }
        
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while(!queue.isEmpty()){
            
            Node current = queue.poll();
            
            System.out.print(current.data+" ");
            
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right !=null){
                queue.add(current.right);
            }
        }   
    }
    
    public int CountNode(Node node){
        if(node == null){
            return 0;
        }
        this.count++;
        
        CountNode(node.left);
        CountNode(node.right);
        return count;
    }
    
    public boolean Search(Node node, int data){
         boolean search = false;
        if(node == null){
            System.out.println("");
            return search;
        }
        
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while(!queue.isEmpty()){
            
            Node current = queue.poll();
            
            if(current.data == data){
                search = true;
            }
            
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right !=null){
                queue.add(current.right);
            }
        } 
        return search;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        DS_LAB_10 bst = new DS_LAB_10();
        
        bst.root = insert(bst.root,50);
        bst.root = insert(bst.root,30);
        bst.root = insert(bst.root,20);
        bst.root = insert(bst.root,40);
        bst.root = insert(bst.root,70);
        bst.root = insert(bst.root,60);
        bst.root = insert(bst.root,80);
        
       InOrder(bst.root);
       
        System.out.println("");
        System.out.println(""+bst.CountNode(bst.root));
        System.out.println(""+bst.Search(bst.root,0));
        
    }
}
