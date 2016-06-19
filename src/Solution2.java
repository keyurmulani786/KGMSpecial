/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author keyur
 */
public class Solution2 {
    public static void main(String args[]){
        
    }
    public static int getMethod(int[] array){
        int largest = array[0];

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > largest)
                largest = array[i];   
        }

        int value=array[largest]-array[0];
        
        
        return value;
    }
}
