/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_7;

/**
 *
 * @author USER
 */
public class QueueUsingLL {
    private Node front;
    private Node rear;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
   QueueUsingLL(){
       this.front = null;
       this.rear = null;
   }
   
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear =  newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }

        int result = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.print("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    
    public void display(){
        if(isEmpty()){ System.out.println("Queue is Null"); return;}
        
        Node current = front;
        
        while(current!=null){
            System.out.println(current.data+" --> ");
            current = current.next;
        }
        
    
}    
    public static void main(String args[]){
        QueueUsingLL queue = new QueueUsingLL() ;
        queue.enqueue(1);
   queue.enqueue(2);
   queue.enqueue(3);
   queue.display();
   queue.dequeue();
   queue.enqueue(4);
   queue.enqueue(5);
   queue.enqueue(6);
   queue.display();

    }
}
