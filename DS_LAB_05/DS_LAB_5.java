/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ds.ds_lab_5;

/**
 *
 * @author USER
 */
public class DS_LAB_5 {

    int top = -1;
    int arr[];
    DS_LAB_5(int data){
    this.arr=new int[data];
    
    }
    
 
    public boolean isEmpty(){
        return top == -1;
    }
        
    public void push(int data){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        arr[++top] = data;
    }
    
    public int pop(){
        if(isEmpty()){
            return top;
        }
        int temp = arr[top];
        top--;

        return temp;
    }
    
    public int peek(){
        if(isEmpty()){
            return top;
        }

        return arr[top];    
    }
    
    public int size(){
        return top+2;
    }
    
    public void display(){
        for(int i=top; i>=0; i--){
            System.out.print(arr[i]+"-->");
        }
        System.out.println("Null");
    }
    
    public boolean isFull(){
        return (top+1) == arr.length;
    }
    

public static void main(String[] args) {
        System.out.println("Hello World!");
        
        DS_LAB_5 st = new DS_LAB_5(7);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(35);
        st.display();
        
        st.push(40);
        st.push(50);
        st.push(60); 
        st.push(70);
        st.push(70);
        st.push(70);
         st.display();
    }
}
