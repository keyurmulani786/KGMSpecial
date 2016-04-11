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
//import java.util.Scanner;
// 
///* Class HeapSort */
//public class HeapSort 
//{    
//    private static int N;
//    /* Sort Function */
//    public static void sort(int arr[])
//    {       
//        heapify(arr);        
//        for (int i = N; i > 0; i--)
//        {
//            swap(arr,0, i);
//            N = N-1;
//            maxheap(arr, 0);
//        }
//    }     
//    /* Function to build a heap */   
//    public static void heapify(int arr[])
//    {
//        N = arr.length-1;
//        for (int i = N/2; i >= 0; i--)
//            maxheap(arr, i);        
//    }
//    /* Function to swap largest element in heap */        
//    public static void maxheap(int arr[], int i)
//    { 
//        int left = 2*i ;
//        int right = 2*i + 1;
//        int max = i;
//        if (left <= N && arr[left] > arr[i])
//            max = left;
//        if (right <= N && arr[right] > arr[max])        
//            max = right;
// 
//        if (max != i)
//        {
//            swap(arr, i, max);
//            maxheap(arr, max);
//        }
//    }    
//    /* Function to swap two numbers in an array */
//    public static void swap(int arr[], int i, int j)
//    {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//        for(int k=0;k<arr.length;k++){
//            System.out.print(arr[k]+" ");
//        }
//        System.out.println("");
//        System.out.println("");
//    }    
//    /* Main method */
//    public static void main(String[] args) 
//    {
//        Scanner scan = new Scanner( System.in );        
//        System.out.println("Heap Sort Test\n");
//        int n, i;    
//        /* Accept number of elements */
//        System.out.println("Enter number of integer elements");
//        n = scan.nextInt();    
//        /* Make array of n elements */
//        int arr[] = new int[ n ];
//        /* Accept elements */
//        System.out.println("\nEnter "+ n +" integer elements");
//        for (i = 0; i < n; i++)
//            arr[i] = scan.nextInt();
//        /* Call method sort */
//        sort(arr);
//        /* Print sorted Array */
//        System.out.println("\nElements after sorting ");        
//        for (i = 0; i < n; i++)
//            System.out.print(arr[i]+" ");            
//        System.out.println();            
//    }    
//}
public class HeapSort {
//https://www.cs.usfca.edu/~galles/visualization/HeapSort.html
//http://www.code2learn.com/2011/09/heapsort-array-based-implementation-in.html
//https://en.wikipedia.org/wiki/Heapsort
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    public static void buildheap(int[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxheap(a, i);
        }
    }

    public static void maxheap(int[] a, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println("");
        System.out.println("");
    }

    public static void sort(int[] a0) {
        a = a0;
        buildheap(a);
        System.out.println("=============================");
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println("");
        System.out.println("=============================");
        for (int i = n; i > 0; i--) {
            exchange(0, i);
            n = n - 1;
            maxheap(a, 0);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {2, 4, 3, 9, 6, 5, 1, 8, 7, 15, 14, 13, 10, 12,16};
        System.out.println("Length:"+a1.length);
        for (int k = 0; k < a1.length; k++) {
            System.out.print(a1[k] + " ");
        }
        System.out.println("");
        System.out.println("");
        sort(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
    }
}
