/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author keyur
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contest7 {
    
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        int n = 3, q = 6;
        int[] a = {1, 3, 2};
        long[] left = {1,1,1,2,2,3};
        long[] right = {1,2,3,2,3,3};
//        int n = scan.nextInt(), q = scan.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scan.nextInt();
//        }
//        
//        long[] left = new long[q];
//        long[] right = new long[q];
//        for (int i = 0; i < q; i++) {
//            left[i] = scan.nextInt();
//            right[i] = scan.nextInt();
//        }
//        
//        for (int i = 0; i < q; i++) {
//            System.out.println(left[i] + "-->" + right[i]);
//        }
        
        int sum;
        int leftValue,rightValue,prevLeftValue,max;
            
            String key;
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < q; i++) {
            sum = 0;
            System.out.println(i + "==========================");
             leftValue = (int) left[i] - 1;
             rightValue = (int) right[i] - 1;
             prevLeftValue = leftValue;
                         System.out.println(leftValue + "::" + rightValue);
            while (leftValue <= rightValue) {
                
                System.out.println(" prevLeft::" + prevLeftValue + "left::" + leftValue + ",right::" + rightValue);
                max = a[prevLeftValue];
                key = prevLeftValue + "" + leftValue;
                if (hm.isEmpty() || hm.get(key)==null) {
                    for (int k = prevLeftValue + 1; k <= leftValue; k++) {
                        System.out.println(k + ":inner:" + a[k]);
                        if (max < a[k]) {
                            max = a[k];
                        }
                    }
                    hm.put(key, max);
                }else{
                    max=hm.get(key);
                }
                System.out.println("max::" + max);
                sum += max;
                if (leftValue == rightValue && prevLeftValue != rightValue) {
                    System.out.println("if..");
                    ++prevLeftValue;
                    leftValue = prevLeftValue;
//                    System.out.println("left::"+leftValue);
                } else {
                    leftValue++;
                    
                }
                
            }
            System.out.println("sum::" + sum);
        }
        scan.close();
    }
    
    public static int getMaxSum(int[] arr, int sum, int left, int right) {
        
        return 0;
    }
    
}
