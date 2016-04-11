/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

import java.util.Random;

/**
 *
 * @author keyur
 */
public class Summation extends Thread {

    public static void main(String[] args) {
        Random rand = new Random();

        int[] arr = new int[100000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101) + 1; // 1..100
        }

        long start = System.currentTimeMillis();

        int total = Summation.sum(arr);

        System.out.println("total::" + total);
        System.out.println("Single: " + (System.currentTimeMillis() - start)); // Single: 44

        start = System.currentTimeMillis();

        total = Summation.parallelSum(arr);
        System.out.println("total::" + total);
        System.out.println("Parallel: " + (System.currentTimeMillis() - start)); // Parallel: 25
    }
    private int[] arr;

    private int low, high, partial;

    public Summation(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }

    public int getPartialSum() {
        return partial;
    }

    public void run() {
        partial = sum(arr, low, high);
    }

    public static int sum(int[] arr) {
        return sum(arr, 0, arr.length);
    }

    public static int sum(int[] arr, int low, int high) {
        int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }

        return total;
    }

    public static int parallelSum(int[] arr) {
        int threads=Runtime.getRuntime().availableProcessors();
        System.out.println("threads::"+threads);
        return parallelSum(arr,threads);
    }

    public static int parallelSum(int[] arr, int threads) {
        int size = (int) Math.ceil(arr.length * 1.0 / threads);
        System.out.println("size::"+size);
        Summation[] sums = new Summation[threads];

        for (int i = 0; i < threads; i++) {
            System.out.println("Low::"+(i*size)+" ,High::"+((i+1)*size));
            sums[i] = new Summation(arr, i * size, (i + 1) * size);
            sums[i].start();
        }

        try {
            for (Summation sum : sums) {
                sum.join();
            }
        } catch (InterruptedException e) {
        }

        int total = 0;

        for (Summation sum : sums) {
            total += sum.getPartialSum();
        }

        return total;
    }

}
