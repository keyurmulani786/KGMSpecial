/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

/**
 *
 * @author keyur
 */
public class Solution3 {

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
        System.out.println(countWays(5));
        System.out.println(fib1(2));
    }

    public static int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int one = 1;
        int two = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = one + two;
            two = one;
            one = result;
        }
        return result;
    }

    public static int fib1(int n) {
        n=n+1;
        if (n <= 1) {
            return n;
        }
        System.out.println("n=="+n);
        return fib1(n -1 ) + fib1(n - 2);
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

// Returns number of ways to reach s'th stair
    public static int countWays(int s) {
        return fib(s + 1);
    }
}
