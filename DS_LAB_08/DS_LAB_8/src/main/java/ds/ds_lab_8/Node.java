/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_8;

/**
 *
 * @author USER
 */
public class Node {
    
    String data;
        Node []children;
        int count;
        
        Node(String data,int size){
            this.data = data;
            this.children = new Node[size];
            count = 0;
        }
        
        void addChild(Node newChild){
          
           if(children.length > count){
           this.children[this.count++] = newChild;
           } else{ System.out.println(newChild.data+" can not added");}
          
       }
}
