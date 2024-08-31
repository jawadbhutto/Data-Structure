/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_1;

/**
 *
 * @author USER
 */
public class TASK04_EX03 {
     public static void main(String args[]){
 
        int num1[] = new int[6];
        num1[0] = 11;
        num1[1] = 22;
        num1[2] = 33;
        num1[3] = 44;
        num1[4] = 55;
        num1[5] = 66;
        
        int element = 33;
        for(int i = 0; i<num1.length; i++){
            if(num1[i] == element){
                System.out.println("Element "+num1[i]+" found at Index "+i);
            }
        }
        
    }
}
