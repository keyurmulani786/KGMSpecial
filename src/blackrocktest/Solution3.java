/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackrocktest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author keyur
 */
public class Solution3 {

//    public static void main(String args[]) {
//        Scanner scan = new Scanner(System.in);
//        int p = scan.nextInt();
//        double rate = scan.nextFloat();
//        int t = scan.nextInt();
//        int threshold = scan.nextInt();
//        int[] st = new int[t];
//        double incomeTotal = 0;
//        double incomeRate = 1.0 + (rate / 100.00);
//        double[] incomeSubTotal = new double[t];
//        Map<Double, int[]> map = new TreeMap<Double, int[]>(
//                new Comparator<Double>() {
//
//                    public int compare(Double o1, Double o2) {
//                        return o2.compareTo(o1);
//                    }
//
//                });
//// double iRate=incomeRate;
//        for (int i = 0; i < t; i++) {
//            st[i] = scan.nextInt();
//            double iRate = Math.pow(incomeRate, i + 1);
//            //System.out.println("--" + (p * (getSpendingRateIncome(st, i))) + "--" + iRate);
//            incomeSubTotal[i] = (p * (getSpendingRateIncome(st, i)) * iRate) / Math.pow(100, i + 1);
//            //System.out.println(i + " incomeSubTotal " + incomeSubTotal[i]);
//            incomeSubTotal[i] = Math.round(incomeSubTotal[i] * 1000000.0) / 1000000.0;
//            //System.out.println(i + " incomeSubTotal " + incomeSubTotal[i]);
//
//            incomeTotal += incomeSubTotal[i];
//        }
//        incomeTotal=Math.round(incomeTotal * 1000.0) / 1000.0;
//        System.out.println(incomeTotal);
//        map.put(incomeTotal, st);
//
//        double incomeTotal1 = 0, incomeTotal2 = 0;
//
//        List<Integer[]> list = new ArrayList();
//        int counter = 0;
//        for (int i = 0; i < t; i++) {
//            int[] tmp = st;
//            //System.out.println("-------------------low---------------------------" + st[i]);
//            int stValue = tmp[i];
//            int low = st[i] - threshold;
//            st[i] = low;
//            //System.out.println("-------------------low---------------------------" + st[i]);
//
//            for (int j = 0; j < t; j++) {
//                if (i != j) {
//                    int tmpSj = st[j];
//                    st[j] = st[j] + threshold;
//                    printCombination(st);
//                    List lst = getIncomeTotal(st, p, incomeRate);
//
//                    map.put((Double) lst.get(0), (int[]) lst.get(1));
//                    st[j] = tmpSj;
//
//                }
//            }
////            printCombination(st);
////            map.put(getIncomeTotal(st, p, incomeRate), st);
//            st[i] = stValue;
//            st = tmp;
//            //System.out.println("-------------------high---------------------------" + tmp[i]);
//            int high = st[i] + threshold;
//            st[i] = high;
//            //System.out.println("-------------------high---------------------------" + st[i]);
//
//            for (int j = 0; j < t; j++) {
//                if (i != j) {
//                    int tmpSj = st[j];
//                    st[j] = st[j] - threshold;
//                    printCombination(st);
//
//                    List lst = getIncomeTotal(st, p, incomeRate);
//
//                    map.put((Double) lst.get(0), (int[]) lst.get(1));
//                    st[j] = tmpSj;
//
//                }
//            }
//            st[i] = stValue;
////            map.put(getIncomeTotal(st, p, incomeRate), st);
////            printCombination(st);
//        }
//
//        int max = 0;
//        for (Map.Entry<Double, int[]> entry : map.entrySet()) {
//            if (max < 3) {
//
//                System.out.print(Math.round(entry.getKey() * 1000.0) / 1000.0 + " -");
//                int[] arr = entry.getValue();
//                for (int i = 0; i < arr.length; i++) {
//                    System.out.print(" " + arr[i]);
//                }
//                System.out.println("");
//                max++;
//            } else {
//                break;
//            }
//
//        }
//        
//    }
//
//    public static List getIncomeTotal(int[] st, int p, double incomeRate) {
//        double incomeTotal = 0;
//        double[] incomeSubTotal = new double[st.length];
//        int[] arr = new int[st.length];
//        for (int i = 0; i < st.length; i++) {
//            arr[i] = st[i];
//            incomeSubTotal[i] = (p * (getSpendingRateIncome(st, i)) * Math.pow(incomeRate, i + 1)) / Math.pow(100, i + 1);
//            //System.out.println(i + " incomeSubTotal " + incomeSubTotal[i]);
//            incomeSubTotal[i] = Math.round(incomeSubTotal[i] * 1000.0) / 1000.0;
//            incomeTotal += incomeSubTotal[i];
//        }
//        List lst = new ArrayList();
//        lst.add(incomeTotal);
//        lst.add(arr);
//        return lst;
//    }
//
//    public static void printCombination(int[] st) {
//        //System.out.println("----------------------------------------------");
//        for (int i = 0; i < st.length; i++) {
//            //System.out.print(st[i] + " ");
//        }
//        //System.out.println("");
//    }
//
//    public static int fact(int b) {
//        if (b <= 1) //if the number is 1 then return 1
//        {
//            return 1;
//        } else //else call the same function with the value - 1
//        {
//            return b * fact(b - 1);
//        }
//    }
//
//    public static int getSpendingRateIncome(int[] st, int count) {
//
//        int spendingRate = st[count--];
//        //System.out.println("spendingRate::" + spendingRate);
//        for (int i = count; i >= 0; i--) {
//            //System.out.println("i::" + i + " st " + st[i] + " ," + (100 - st[i]));
//            spendingRate = spendingRate * (100 - st[i]);
//        }
//        //System.out.println("spendingRate::" + spendingRate);
//        return spendingRate;
//    }
    
    public static void main(String[] args) {

   int arr1[] = { 0, 1, 2, 3, 4, 5 };
   int arr2[] = { 0, 10, 20, 30, 40, 50 };
    
   // copies an array from the specified source array
   System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.out.println(arr2.length);
   System.out.print("array2 = ");
   System.out.print(arr2[0] + " ");
   System.out.print(arr2[1] + " ");
   System.out.print(arr2[2] + " ");
   System.out.print(arr2[3] + " ");
   System.out.print(arr2[4] + " ");
   }
}
