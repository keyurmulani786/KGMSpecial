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
public class MergeSort {
//https://www.cs.usfca.edu/~galles/visualization/HeapSort.html
//http://www.code2learn.com/2011/09/heapsort-array-based-implementation-in.html

    private int[] array;
    private int[] tempMergArr;
    private int length;

    public static void main(String a[]) {

        int[] inputArr = {2, 4, 3, 9, 6, 5, 1, 8, 7};
        for (int k = 0; k < inputArr.length; k++) {
            System.out.print(inputArr[k] + " ");
        }
        System.out.println("");
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        System.out.println("low=" + lowerIndex + " , high=" + higherIndex);
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            System.out.println("low=" + lowerIndex + " , high=" + higherIndex + " ,middle=" + middle);
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        System.out.println("low=" + lowerIndex + " ,middle=" + middle + " , high=" + higherIndex);

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        System.out.println("1--i=" + i + " ,j=" + j + " ,k=" + k);
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        System.out.println("2---i=" + i + " ,j=" + j + " ,k=" + k);

        for (int h = 0; h < array.length; h++) {
            System.out.print(array[h] + " ");
        }
        System.out.println("\n");
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
        System.out.println("3---i=" + i + " ,j=" + j + " ,k=" + k);

        for (int h = 0; h < array.length; h++) {
            System.out.print(array[h] + " ");
        }
        System.out.println("--\n");

    }
}
