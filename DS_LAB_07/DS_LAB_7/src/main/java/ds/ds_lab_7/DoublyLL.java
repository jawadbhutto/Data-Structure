/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_7;

/**
 *
 * @author USER
 */
public class DoublyLL {
    
    public class Node{
        int data;
        Node prev;
        Node next;
        
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    Node head;
    Node tail;
    
    DoublyLL(){
        this.head = null;
        this.tail = null;
    }
    
    public boolean isEmpty(){
        return head==null && tail==null;
    }
    
    public void insertAtStart(int data){
        Node newNode = new Node(data);
        
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;   
    }
    
    public void insertAtEnd(int data){
         Node newNode = new Node(data);
        
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
         newNode.prev = tail;
        tail = newNode;
    }
    
    public void insertAtPosition(int data,int position){    
        if( position == 0 ){
            insertAtStart(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        int index = 1;
        
        while (index != position && position > 0){
            current = current.next;
            index++;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) { // Big Problem Solved
            current.next.prev = newNode;
            } else {
                tail = newNode; // Update tail if inserting at the end
            }
        current.next = newNode;
    }
    
    public void deleteFromStart(){
        if(isEmpty()){
            System.out.println("LinkedList is Empty");
            return;
        }
        head = head.next;
        head.prev = null;
    }
    
    public void deleteFromEnd(){
        if(isEmpty()){
            System.out.println("LiinkedList is Empty");
        return;
        }
        tail = tail.prev;
        tail.next = null;        
    }
    
     public void deleteByValue(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Deleting head
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Deleting tail
                }

                return;
            }
            current = current.next;
        }

        System.out.println("Value not found.");
    }

    // Traversal Operations
    public void displayFromStart() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayFromEnd() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Search Operation
    public void search(int value) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == value) {
                System.out.println("Value found at position: " + index);
                return;
            }
            current = current.next;
            index++;
        }

        System.out.println("Value not found.");
    }

    // Reverse the List
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // Count Nodes
    public int countNodes() {
        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
   
    public void Display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    
    
    public static void main(String args[]){
        DoublyLL dll = new DoublyLL();
        dll.insertAtStart(30);
        dll.insertAtStart(20);
        dll.insertAtStart(10);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.insertAtPosition(35, 3);
        dll.insertAtPosition(60,6);
        dll.insertAtPosition(70, 7);
        dll.Display();
        dll.deleteFromStart();
        dll.Display();
        dll.deleteFromEnd();
        dll.Display();
        dll.displayFromEnd();
        dll.reverse();
        dll.deleteByValue(50);
        dll.Display();
        System.out.println( dll.countNodes());
        
        
    }
}
