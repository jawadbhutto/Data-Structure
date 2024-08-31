/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_1;

/**
 *
 * @author USER
 */
public class TASK02_EX01 {
    public static void main(String args[]){
        int num1[] = new int[7];
        num1[0] = 12;
        num1[1] = 24;
        num1[2] = 36;
        num1[3] = 48;
        num1[4] = 60;
        
        for(int i = num1.length-1; i>0; i--){
            num1[i] = num1[i-1];
        }
        
        num1[0] = 6;
        
        for(int i = 0; i<num1.length; i++){
          System.out.print(num1[i]+" ");
      }
    }
}
