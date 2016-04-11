/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortexample;

/**
 *
 * @author keyur
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 9, 6, 5, 1, 8, 7};
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println("");
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i ; j++) {
                if (arr[j] > arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println("");
        }
    }
}
