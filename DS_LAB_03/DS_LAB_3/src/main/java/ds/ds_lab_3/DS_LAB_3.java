/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ds.ds_lab_3;

/**
 *
 * @author USER
 */
public   class DS_LAB_3 {
 public static class Node{
       
     int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    
/* 
   struct Node{
        int data;
        Node* next;
        
        Node(int data){
            this.data = data;
            this.next = nullptr;
        }
    }
      
    */

    private Node head;
        DS_LAB_3(){
            this.head = null;
        }
        
        
        public void insertAtStart(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;          
        }
        
        public void insertAtEnd(int data){
            Node newNode = new Node(data);
            Node currentNode = head;
            
            while(currentNode!=null){
                      currentNode = currentNode.next;
            }
            currentNode = newNode;
            head.next = currentNode;
                }
        
        public void insertAtPosition(int data,int position){
            Node newNode = new Node(data);
            Node currentNode = head;
            Node temp ;
            int i=0;
            while(currentNode!=null){
              
                if(i==position){
                  temp =  currentNode.next;
                  currentNode.next = newNode;
                  newNode.next = temp;
                  return;
                }
                currentNode = currentNode.next;
                  i++;
            }
        }
        
        public void deleteFromStart(){
            head = head.next;
        }
        
        public void deleteFromEnd(){
            if(head==null){
                System.out.println("List is already empty");
                return;
            }
          Node newNode = head;
         
          while(newNode.next.next!=null){      
              newNode = newNode.next;
          }
          newNode.next = null;   
        }
        
        public void deleteFromValue(int data){
            if(head == null){
                System.out.println("List is Empty");
            }
            Node newNode = head;
            while(newNode!=null){
                if(newNode.next.data==data){
                    newNode.next = newNode.next.next;
                    return;
                  }
                newNode = newNode.next;
            }
        }
        
        public void Display(){
            Node newNode = head;
            while(newNode!=null){
                System.out.print(newNode.data+" -> ");
                newNode = newNode.next;
            }
            System.out.println("Null");
        }
        
        public void search(int data){
            if(head==null){
                System.out.println("List is Empty");
            return;
            }
            int count=0;
            Node newNode = head;
            while(newNode!=null){
                if(newNode.data==data){
                    System.out.println("Index :"+count);
                    return;
                }
                newNode = newNode.next;
                count++;
            }
        }
        
        public void reverse(){
            DS_LAB_3 list = new DS_LAB_3();
            Node newNode = head;
            while(newNode!=null){
                list.insertAtStart(newNode.data);
                newNode = newNode.next;
            }
           list.Display();
        }
        
        public void countNode(){
            Node newNode = head;
            int count = 0;
            while(newNode !=null){
                count++;
                newNode = newNode.next;
            }
            System.out.println("Total Nodes :"+count);
        }
    
    
    public static void main(String[] args) {
      DS_LAB_3 list = new DS_LAB_3();
      list.insertAtStart(45);
      list.insertAtEnd(50);
      list.insertAtStart(40);
      list.insertAtPosition(47, 1);
      list.Display();
      list.insertAtPosition(48, 2);
      list.deleteFromStart();
      list.deleteFromEnd();
      list.insertAtStart(41);
      list.insertAtStart(42);
      list.deleteFromValue(45);
      list.Display();
      list.search(45);
      list.Display();
      list.countNode();
      list.reverse();
      
    }
}
