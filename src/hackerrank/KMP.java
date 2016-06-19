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
public class KMP {

    private static String maxString(String A, String B) {
        return 0 < A.compareTo(B) ? A : B;
    }

    private static String minString(String A, String B) {
        return 0 < A.compareTo(B) ? B : A;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int k = sc.nextInt();
//        String m, M;
//        m = M = s.substring(0, k);
//        for (int i = 1; i < s.length() - k + 1; ++i) {
//            m = minString(m, s.substring(i, i + k));
//            M = maxString(M, s.substring(i, i + k));
//        }
//        System.out.println(m);
//        System.out.println(M);

//        System.out.println("Testing KMP");
        test("abc", "a", 0);
        test("abc", "b", 1);
        test("abc", "c", 2);
        test("abc", "d", -1);
        test("catdog", "tdo", 2);
        test("ratatat", "at", 1);
        test("foo", "", 0);
//        test("", "bar", -1);
//        Scanner sc = new Scanner(System.in);
//        int[] n = new int[26];
//        for (int i = 0; i < n.length; i++) {
//            n[i]=sc.nextInt();
//        }
//        for (int i = 0; i < n.length; i++) {
//            System.out.println(n[i]);
//        }
//        getMinimalString(n);
    }

    public static String getMinimalString(int[] array) {
        char[] charArr={'a','b','c','d'};
        String str="";
        int charStart=97;
        for(int i=0;i<array.length;i++){
            int len=array[i];
            while(len>0){
                str=str+(char)charStart;
                len--;
            }
            charStart++;
        }
        System.out.println("str::"+str);
        return null;
    }
    
    public static int kmp1(char[] S, char[] W) {
        //s =text , w=word
        if (W.length == 0) // substr is empty string
        {
            return 0;
        }
        if (S.length == 0) // text is empty, can't be found
        {
            return -1;
        }
        int m = 0; // index of beg. of current match in S
        int i = 0; // pos. of cur char in W
        Integer[] T = createTable(S);

        while (m + i < S.length) {
            if (W[i] == S[m + i]) {
                if (i == W.length - 1) {
                    return m;
                }
                i += 1;
            } else {
                m = (m + i - T[i]);
                if (T[i] > -1) {
                    i = T[i];
                } else {
                    i = 0;
                }
            }
        }
        return -1;
    }

    public static void test(String text, String word, int exp) {
        char[] textC = text.toCharArray();
        char[] wordC = word.toCharArray();
        int result = kmp(textC, wordC);
        if (result == exp) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("\ttext: " + text);
            System.out.println("\tword: " + word);
            System.out.println("\texp: " + exp + ", res: " + result);
        }

    }

    // W := word
    public static Integer[] createTable(char[] W) {
        Integer[] table = new Integer[W.length];
        int pos = 2; // cur pos to compute in T
        int cnd = 0; // index of W of next character of cur candidate substr

        // first few values are fixed
        table[0] = -1;  // table[0] := -1
        table[1] = 0;   // table[1] := 0

        while (pos < W.length) {
            // first case: substring is still good
            if (W[pos - 1] == W[cnd]) {
                table[pos] = cnd;
                cnd += 1;
                pos += 1;
            } else if (cnd > 0) {
                cnd = table[cnd];
            } else {
                table[pos] = 0;
                pos += 1;
            }
        }
        
        return table;
    }

    // S := text string
    // W := word
    public static int kmp(char[] S, char[] W) {
        if (W.length == 0) // substr is empty string
        {
            return 0;
        }
        if (S.length == 0) // text is empty, can't be found
        {
            return -1;
        }
        int m = 0; // index of beg. of current match in S
        int i = 0; // pos. of cur char in W
        Integer[] T = createTable(S);
        
        while (m + i < S.length) {
            if (W[i] == S[m + i]) {
                if (i == W.length - 1) {
                    return m;
                }
                i += 1;
            } else {
                m = (m + i - T[i]);
                if (T[i] > -1) {
                    i = T[i];
                } else {
                    i = 0;
                }
            }
        }
        return -1;
    }
}
