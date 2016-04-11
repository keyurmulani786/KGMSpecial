package sortexample;

/*
 // * To change this license header, choose License Headers in Project Properties.
 // * To change this template file, choose Tools | Templates
 // * and open the template in the editor.
 // */
//package sortexample;
//
///**
// *
// * @author keyur
// */
//public class QuickSort {
//
//    public void quickSort(int arr[], int left, int right) {
//        System.out.println("left=" + left + " ,right=" + right);
//        int i = left, j = right;
//        int tmp;
//        int pivot = arr[(left + (right - left)) / 2];
//        System.out.println("i=" + i + " ,j=" + j + " ,p=" + pivot);
//        while (i <= j) {
//            while (arr[i] < pivot) {
//                i++;
//            }
//            while (arr[j] > pivot) {
//                j--;
//            }
//            if (i <= j) {
//                tmp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = tmp;
//                i++;
//                j--;
//            }
//
//        }
//        System.out.println("i=" + i + " ,j=" + j + " ,p=" + pivot);
//        for (int k = 0; k < arr.length; k++) {
//            System.out.print(arr[k] + " ");
//        }
//        System.out.println("");
//
//        if (left < j) {
//            System.out.println("left=" + left + " ,j=" + j);
//            quickSort(arr, left, j);
//        }
//        if (i < right) {
//            System.out.println("right=" + right + " ,i=" + i);
//            quickSort(arr, i, right);
//        }
//    }
//
//    public static void main(String[] args) {
//        QuickSort sort = new QuickSort();
//        int[] arr = {2, 4, 3, 9, 6, 5, 1, 8, 7};
//        for (int k = 0; k < arr.length; k++) {
//            System.out.print(arr[k] + " ");
//        }
//        System.out.println("");
//        sort.quickSort(arr, 0, arr.length - 1);
//
//    }
//}
public class MyQuickSort {

    private int array[];
    private int length;

    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {
        System.out.println("lowerIndex=" + lowerIndex + " ,higherIndex=" + higherIndex);
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        System.out.println("i=" + i + " ,j=" + j + " ,p=" + pivot);
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a
             * number from right side which is less then the pivot value. Once
             * the search is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        System.out.println("i=" + i + " ,j=" + j + " ,p=" + pivot);
        // call quickSort() method recursively
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }
        System.out.println("");
        if (lowerIndex < j) {
         System.out.println("lowerIndex=" + lowerIndex + " ,j=" + j);
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            System.out.println("i=" + i + " ,higherIndex=" + higherIndex);
            quickSort(i, higherIndex);
        }
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String a[]) {

        MyQuickSort sorter = new MyQuickSort();
        int[] input = {7, 8, 3, 9, 6, 5, 1, 4,2};
        for (int k = 0; k < input.length; k++) {
            System.out.print(input[k] + " ");
        }
        System.out.println("");
        sorter.sort(input);
        for (int i : input) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
