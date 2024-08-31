/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_1;

/**
 *
 * @author USER
 */
public class TASK04_EX02 {
    public static void main(String args[]){
 
        int num1[] = new int[6];
        num1[0] = 4;
        num1[1] = 6;
        num1[2] = 2;
        num1[3] = 8;
        num1[4] = 10;
        num1[5] = 12;
        
        int element = 8;
        for(int i = 0; i<num1.length; i++){
            if(num1[i] == element){
                System.out.println("Element "+num1[i]+" found at Index "+i);
            }
        }
        
    }
}
