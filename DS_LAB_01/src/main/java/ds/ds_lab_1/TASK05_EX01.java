/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_1;

/**
 *
 * @author USER
 */
public class TASK05_EX01 {
    public static void main(String args[]){
        int num1[] = new int[6];
        num1[0] = 1;
        num1[1] = 3;
        num1[2] = 5;
        num1[3] = 7;
        num1[4] = 9;
        num1[5] = 11;
        
        for(int i = num1.length-1; i>=0; i--){
            System.out.print(num1[i]+" ");
        }
    }
}
