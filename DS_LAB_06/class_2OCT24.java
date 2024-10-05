/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_6;

/**
 *
 * @author USER
 */
public class class_2OCT24 {
    
    public static int[] selectionsort(int arr[]){
    
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            int minindex = i;
           for(int j = i+1; j<arr.length; j++){
                if(arr[minindex]>arr[j]){
                    minindex = j;
                   count++;
                }
                
            }
            int temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex] = temp;
        }
        System.out.println("Count = "+count);
        return arr;
    }
    public static void main(String args[]){
        
        int arr2[] = {10,3,119,90,40,4,12,1};
        int arr1[] = selectionsort(arr2);
        
        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i]+"-->");
        }
        
    }
}
