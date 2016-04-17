/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon;

/**
 *
 * @author keyur
 */
public class MergeArraySortedOrder {
    public static void main(String[] args) {
    int[] arrayA = { 23, 47, 81, 95 };
    int[] arrayB = { 7, 14, 39, 55, 62, 74 };
    int[] arrayC = new int[10];

    merge(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
    for (int i : arrayC) {
      System.out.println(i);

    }
    System.out.println("----End-----");
    int[] arrayA1={1,5,7,7};
    int[] arrayB1={0,1,2,3};
    int[] arrayC1 = new int[8];

    merge(arrayA1, arrayA1.length, arrayB1, arrayB1.length, arrayC1);
    for (int i : arrayC1) {
      System.out.println(i);

    }
    System.out.println("----End-----");
    
    int[] arrayA2 = { 2,4,5,9,9 };
    int[] arrayB2 = { 0,1,2,3,4};
    int[] arrayC2 = new int[10];

    merge(arrayA2, arrayA2.length, arrayB2, arrayB2.length, arrayC2);
    for (int i : arrayC2) {
      System.out.println(i);

    }
    
    System.out.println("----End-----");
  }

  public static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
    int arrayAIndex = 0, arrayBIndex = 0, arrayCIndex = 0;

    while (arrayAIndex < sizeA && arrayBIndex < sizeB)
      if (arrayA[arrayAIndex] < arrayB[arrayBIndex])
        arrayC[arrayCIndex++] = arrayA[arrayAIndex++];
      else
        arrayC[arrayCIndex++] = arrayB[arrayBIndex++];

    while (arrayAIndex < sizeA)
      arrayC[arrayCIndex++] = arrayA[arrayAIndex++];

    while (arrayBIndex < sizeB)
      arrayC[arrayCIndex++] = arrayB[arrayBIndex++];
  }
}
