/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author keyur
 */
public class SplitIntegerArray {

    public static void main(String[] args) throws InvalidInputException {

        SplitIntegerArray sia = new SplitIntegerArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter main array size::");
        int arrSize = sc.nextInt();
        int[] mainArr = new int[arrSize];
        int splitArr = arrSize / 2;
        int[] arr1 = new int[splitArr];
        int[] arr2 = new int[arrSize - splitArr];
        for (int i = 0; i < arrSize; i++) {
            mainArr[i] = sc.nextInt();
        }
        System.out.println("mainArr::");
        for (int i = 0; i < arrSize; i++) {
            System.out.print(" " + mainArr[i]);
        }
        System.out.println("");

        sia.splitEvenly(mainArr);

    }

    public int[][] splitEvenly(int[] integerList) throws InvalidInputException {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        Arrays.sort(integerList);
        System.out.println("SortedArr::");
        for (int i = 0; i < integerList.length; i++) {
            System.out.print(" " + integerList[i]);
        }
        System.out.println("");

        boolean flag1, flag2;
        int arr1Sum = 0, arr2Sum = 0;
        for (int i = integerList.length - 1; i >= 0; i--) {
            flag1 = false;
            flag2 = false;
            if (arr1Sum == arr2Sum || arr1Sum < arr2Sum) {
                flag1 = true;
            } else if (arr1Sum > arr2Sum) {
                flag2 = true;
            }
            if (flag1) {
                arrayList1.add(integerList[i]);
                arr1Sum += integerList[i];
            }
            if (flag2) {
                arrayList2.add(integerList[i]);
                arr2Sum += integerList[i];
            }

        }
        System.out.println("arr1::" + arrayList1 + " arr2::" + arrayList2);
        if(arrayList1.size()==0){
            throw new InvalidInputException("list size should be more thenb one.");
        }else if(arrayList2.size()==0){
            throw new InvalidInputException("list size should be more thenb one.");
        }
        int[][] array = new int[2][];
        array[0] = new int[arrayList1.size()];
        array[1] = new int[arrayList2.size()];
        for (int i = 0; i < arrayList1.size(); i++) {
            array[0][i] = arrayList1.get(i);
            System.out.println("array[0][" + i + "]-->" + array[0][i]);
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            array[1][i] = arrayList2.get(i);
            System.out.println("array[1][" + i + "]-->" + array[1][i]);
        }


        return array;
    }

    public Integer[][] splitEvenlyInteger(int[] integerList) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        Arrays.sort(integerList);
        System.out.println("SortedArr::");
        for (int i = 0; i < integerList.length; i++) {
            System.out.print(" " + integerList[i]);
        }
        System.out.println("");
        boolean flag1, flag2;
        int arr1Sum = 0, arr2Sum = 0;
        for (int i = integerList.length - 1; i >= 0; i--) {
            flag1 = false;
            flag2 = false;
            if (arr1Sum == arr2Sum || arr1Sum < arr2Sum) {
                flag1 = true;
            } else if (arr1Sum > arr2Sum) {
                flag2 = true;
            }
            if (flag1) {
                arrayList1.add(integerList[i]);
                arr1Sum += integerList[i];
            }
            if (flag2) {
                arrayList2.add(integerList[i]);
                arr2Sum += integerList[i];
            }

        }
        System.out.println("arr1::" + arrayList1 + " arr2::" + arrayList2);
        arrayList.add(arrayList1);
        arrayList.add(arrayList2);
        Integer[][] array = new Integer[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Integer> row = arrayList.get(i);
            array[i] = row.toArray(new Integer[row.size()]);
        }

        return array;
    }

    public static int[] counting_sort(int[] arrayToSort) {
        int maxValue = getMaxVal(arrayToSort);
        int[] finalSortedArray = new int[arrayToSort.length];
        int[] tempArray = new int[maxValue + 1];

        for (int i = 0; i < arrayToSort.length; i++) {
            tempArray[arrayToSort[i]] = tempArray[arrayToSort[i]] + 1;
        }

        for (int i = 1; i < maxValue + 1; i++) {
            tempArray[i] = tempArray[i] + tempArray[i - 1];
        }

        for (int i = (arrayToSort.length - 1); i >= 0; i--) {
            finalSortedArray[tempArray[arrayToSort[i]] - 1] = arrayToSort[i];
            tempArray[arrayToSort[i]] = tempArray[arrayToSort[i]] - 1;
        }
        return finalSortedArray;
    }

    private static int getMaxVal(int[] arrayToSort) {
        int maxVal = Integer.MIN_VALUE;
        for (int i : arrayToSort) {
            if (i > maxVal) {
                maxVal = i;
            }
        }
        return maxVal;
    }
}

class InvalidInputException extends Throwable {

    private static final long serialVersionUID = 1997753363232807009L;

    public InvalidInputException(String message) {

        super(message);

    }

}
