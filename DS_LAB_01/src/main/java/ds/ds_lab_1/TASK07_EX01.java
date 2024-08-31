/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.ds_lab_1;
import java.util.Arrays;
/**
 *
 * @author USER
 */
public class TASK07_EX01 {
     



 
    public static boolean areAnagrams(String str1, String str2) {
       
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String string1 = "listen";
        String string2 = "silent";

        if (areAnagrams(string1, string2)) {
            System.out.println(string1 + " and " + string2 + " are anagrams.");
        } else {
            System.out.println(string1 + " and " + string2 + " are not anagrams.");
        }
    }
}
 

