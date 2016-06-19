/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackrocktest;

import java.util.Scanner;

/**
 *
 * @author keyur
 */
public class Solution5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer num = scan.nextInt();
        int[] n = new int[num];
        for (int i = 0; i < num; i++) {
            n[i] = scan.nextInt();
        }
        Integer result=0;
        //System.out.println("String::" + s);
        for (Integer i = 0; i < num; i++) {
            printCombination(n, num, i+1);
        }
        System.out.println(values%1000000007);

    }
    
    
    static void combinationUtil(int arr[], int n, int r, int index,
                                int data[], int i)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            int value=1;
            for (int j=0; j<r; j++){
                value*=data[j];
                System.out.print(data[j]+" ");
            }
            System.out.println("");
            values+=value*r;
        return;
        }
 
        // When no more elements are there to put in data[]
        if (i >= n)
        return;
 
        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, n, r, index+1, data, i+1);
 
        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(arr, n, r, index, data, i+1);
    }
 
    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];
 
        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }
 
    
    static Integer values=0;
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer num = scan.nextInt();
        Integer[] n = new Integer[num];
        String s = "";
        for (int i = 0; i < num; i++) {
            n[i] = scan.nextInt();
            s += n[i];
        }
        Integer result=0;
        //System.out.println("String::" + s);
        for (Integer i = 0; i < num; i++) {
            print("", s, i + 1);
           
        }
        System.out.println(values%1000000007);

    }

    public static void print(String prefix, String remaining, Integer k) {
        if (k == 0) {
            //System.out.println(prefix);
            values+=print(prefix);
            //System.out.println(print(prefix)+",values::"+values);
            return ;
//            return;
        }
        if (remaining.length() == 0) {
            return;
        }
        print(prefix + remaining.charAt(0), remaining.substring(1), k - 1);
        print(prefix, remaining.substring(1), k);
    }

    public static Integer print(String prefix) {
        Integer number = Integer.parseInt(prefix);
        Integer length=prefix.length();
        Integer value=1;
        if (prefix.length() > 1) {
            Integer d,k;
            while (number > 0) {
                d = number / 10;
                k = number - d * 10;
                number = d;
                value*=k;
//                //System.out.println(k);
            }
            return length*value;
        }else{
            return number;
        }

    }

}
