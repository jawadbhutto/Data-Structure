/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_9;

/**
 *
 * @author USER
 */
public class Node {
    int data;
    Node right;
    Node left;
    
    Node(int data){
        this.data = data;
        this.right = this.left = null;
    }
    
    public void addLeftChild(Node newNode){
        left = newNode;
    }
    public void addRightChild(Node newNode){
        right = newNode;
    }
}
