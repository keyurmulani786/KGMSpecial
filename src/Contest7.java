/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author keyur
 */
import hackerrank.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contest7 {

    public static void main(String[] args) throws InterruptedException {
//        Scanner scan = new Scanner(System.in);

        int n = 3, q = 6;
        int[] a = {1, 3, 2};
        long[] left = {1, 1, 1, 2, 2, 3};
        long[] right = {1, 2, 3, 2, 3, 3};

        int sum;
        int leftValue, rightValue, prevLeftValue, max;

        String key;
        Map<String, Integer> hm = new HashMap<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < q; i++) {
            sum = 0;
            leftValue = (int) left[i] - 1;
            rightValue = (int) right[i] - 1;
            if (leftValue == rightValue) {
                sum = a[leftValue];
            } else {
                prevLeftValue = leftValue;
                while (leftValue <= rightValue) {
                    key = prevLeftValue + "" + leftValue;
                    if (hm.isEmpty() || hm.get(key) == null) {
                        max = a[prevLeftValue];
                        for (int k = prevLeftValue + 1; k <= leftValue; k++) {
                            if (max < a[k]) {
                                max = a[k];
                            }
                        }
                        hm.put(key, max);
                    } else {
                        System.out.println("asdas");
                        max = hm.get(key);
                    }
                    sum += max;
                    if (leftValue == rightValue && prevLeftValue != rightValue) {
                        ++prevLeftValue;
                        leftValue = prevLeftValue;
                    } else {
                        leftValue++;
                    }

                }
            }

            System.out.println("sum::" + sum);
        }
//        scan.close();
        long endTime = System.nanoTime();
        System.out.println("time::" + (endTime - startTime));
    }

}
