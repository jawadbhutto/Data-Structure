/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ds.ds_lab_7;

/**
 *
 * @author USER
 */
public class DS_LAB_7 {
    
int arr[];
int front,rear;

DS_LAB_7(int size){
    arr = new int[size];
    this.front=-1; this.rear=-1;
}

public boolean isFull(){
    return arr.length-1 == rear;
}
public boolean isEmpty(){
    return front==-1 && rear== -1;
}
public void enqueue(int data){
    if(isEmpty()){
        rear++;
        front++;
        arr[rear] = data;
        return;
    }
    rear++;
    arr[rear] = data;
}
public int dequeue(){
    if(isEmpty()){
        return front;
    }
    int temp = arr[front];
    for(int i=0; i<rear; i++){
        arr[i]=arr[i+1];
    }
    arr[rear--]=0;
    if(rear == -1){
        front--;
    }
    return temp;
}
public int peek(){
    if(isEmpty()){
        return front;
    }
    return arr[front];
}

public void display(){
    if(isEmpty()){
        System.out.println("Queue is Empty");
        return;
    }
for(int i = 0; i<=rear; i++){
    System.out.print(arr[i]+" --> ");
}
}
 public static void main(String args[]){
   DS_LAB_7 queue = new DS_LAB_7(5);
   
   queue.enqueue(1);
   queue.enqueue(2);
   queue.enqueue(3);
   queue.dequeue();
   queue.enqueue(4);
   queue.enqueue(5);
   queue.enqueue(6);
   queue.display();
   
}
}
