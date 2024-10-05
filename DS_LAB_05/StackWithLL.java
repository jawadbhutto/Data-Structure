/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_5;

/**
 *
 * @author USER
 */
public class StackWithLL {
    
    public class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
        }
    }
    
    private Node top;
    StackWithLL(){
        this.top = null;
    }
    
   
        public void push(int data){
            Node newNode = new Node(data);
         if(isEmpty()){
             top = newNode;
             return;
         }   
         newNode.next = top;
         top = newNode;
        }
        
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int temp = top.data;
            top = top.next;
            
            return temp;
        }
        
        public int peek(){
            return top.data;
        }
        
        public int size(){
            Node current = top;
            int count = 0;
            
            while(current != null){
                count++;
                current = current.next;
            }
            
            return count;
        }
        
        public void display(){
            Node current = top;
            
            while(current != null){
                System.out.print(current.data+"-->");
                current = current.next;
            }
            System.out.println("Null");
        }
        
        public boolean isEmpty(){
            return top == null;
        }

    public static void main(String args[]){
        
         StackWithLL st = new StackWithLL();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(35);
        st.display();
        st.pop();
        st.push(40);
        st.push(50);
        st.push(60); 
        st.push(70);
        st.push(70);
        st.push(70);
         st.display();
        
        
    }
}
