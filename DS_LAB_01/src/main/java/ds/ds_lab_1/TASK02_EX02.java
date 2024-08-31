/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_1;

/**
 *
 * @author USER
 */
public class TASK02_EX02 {
    public static void main(String args[]){
        int num1[] = new int[6];
        num1[0] = 100;
        num1[1] = 200;
        num1[2] = 300;
        num1[3] = 400;
        num1[4] = 500;
        
        for(int i = num1.length-1; i>num1.length/2; i--){
               num1[i] = num1[i-1];
      }
        
        num1[num1.length/2-1] = 250;
        
        for(int i = 0; i<num1.length; i++){
          System.out.print(num1[i]+" ");
      }
    }
    
}
