/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ds.ds_lab_8;

/**
 *
 * @author USER
 */
public class DS_LAB_8 {
    
    private Node root;
    
    
       DS_LAB_8 (String a, int size){
           root  = new Node(a,size);
       }
       
       public void displayByLoop(){
           System.out.println(""+root.data);
           
           for(int i=0; i<root.children.length; i++){
               System.out.println(""+root.children[i].data);
               for(int j = 0; j<root.children[i].children.length; j++){
                   System.out.println(""+root.children[i].children[j].data);   
               }
           }
       }
       
       public void DisplayByRec(Node node, int level){
           if(node == null){
               return;
           }
           
           System.out.println(" ".repeat(level*2)+node.data);
           
           for(int i=0; i<node.children.length ; i++){
               DisplayByRec(node.children[i],level+1);
           }
       }
      
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        DS_LAB_8 tree  = new DS_LAB_8("A",2);
        Node B = new Node("B",2);
        Node C = new Node("C",2);
        tree.root.addChild(B);
        tree.root.addChild(C);
        
        Node D = new Node("D",2);
        Node E = new Node("E",2);
        B.addChild(D);
        B.addChild(E);
        
        Node F = new Node("F",2);
        Node G = new Node("G",2);
               // tree.DisplayByRec(C, 2);

        C.addChild(F);
        C.addChild(G);
        
        tree.DisplayByRec(tree.root, 2);
//        
//        System.out.println(""+tree.root.data);
//        System.out.println(""+tree.root.children[0].data);
//        System.out.println(""+tree.root.children[1].data);
//      
//      System.out.println(tree.root.children[0].children[0].data);
//       System.out.println(tree.root.children[0].children[1].data);
//        System.out.println(tree.root.children[1].children[0].data);
//        System.out.println(tree.root.children[1].children[1].data);
    }
}
