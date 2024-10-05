/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_6;

/**
 *
 * @author USER
 */
public class TASK_03 {
    
    public static String [] bubbleSort(String arr[]){
        
        for(int i=0;i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j].length()>arr[j+1].length()){
                    String temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;    
                }
            }
        }
        return arr;
    }
    
    public static void main(String args[]){
        
        String ar[]= {"apple","pie", "banana","cat"};
        String []arr = bubbleSort(ar);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" --> ");
        }
    }
    
}
