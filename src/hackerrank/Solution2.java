/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author keyur
 */
public class Solution2 {

    public static int getNumOfBeautiTriplets(int[] arr, int x) {

        int count = 0;
        for (int i = 0; i + x + x < arr.length; i++) {
            if (arr[i] > 0 && arr[i + x] > 0 && arr[i + x + x] > 0) {
                count++;
            }
        }

        return count;

    }

    public static int getNumOfBeautiTriplets1(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == x) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[k] - arr[j] == x) {
                            count++;
                        }
                    }
                }

            }
        }
        return count;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int a[] = new int[1000];
        for (int a_i = 0; a_i < n; a_i++) {
            a[in.nextInt()]++;
        }
        int numOfBeautiTriplets = getNumOfBeautiTriplets(a, x);
        System.out.println(numOfBeautiTriplets);
    }
}

