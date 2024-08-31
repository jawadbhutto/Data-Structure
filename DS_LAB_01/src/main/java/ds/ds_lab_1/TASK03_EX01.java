/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_1;

/**
 *
 * @author USER
 */
public class TASK03_EX01 {
    public static void main(String args[]){
 
        int num1[] = new int[6];
        num1[0] = 8;
        num1[1] = 16;
        num1[2] = 24;
        num1[3] = 32;
        num1[4] = 40;
        num1[5] = 48;
        
        int index = 2;
        
        for(int i = index; i < num1.length-1; i++){
            
            num1[i] = num1[i+1];
        }
        
       num1[num1.length-1] = 0;
       
       for(int i = 0; i<num1.length; i++){
             System.out.print(num1[i]+" ");
        }
        
    }
    
}
