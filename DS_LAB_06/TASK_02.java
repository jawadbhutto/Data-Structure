/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_6;

/**
 *
 * @author USER
 */
public class TASK_02 {
        
    public static int[] earlyStopBubbleSort(int []arr){
        boolean check = false;
        int tr = 1;
        for(int i=0;i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    check = true;
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;    
                }
                System.out.print(tr+++"-");
            }
            if(!check){
                System.out.println("Already Sorted");
                return arr;
            }
            check = false;
        }
//        for(int i =0; i<arr.length; i++){
//            System.out.print(arr[i]+" --> ");
//        }
//        System.out.println("");
        return arr;
    }
    
    public static void main(String args[]){
        
        int arr2[] = {2,1,5,4,6,7};
        int arr1[] = earlyStopBubbleSort(arr2);
        
        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i]+" --> ");
        }
       
    }
    
}
