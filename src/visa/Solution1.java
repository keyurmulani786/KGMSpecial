/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visa;

import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author keyur
 */
public class Solution1 {

    public static void main(String[] args) {
        String a = "abc";
        String b = "cba";
        Solution1 p = new Solution1();
        System.out.println(a + " and " + b + " are permutation of each other? " + p.isPermutation(a, b));
        a = "xyzab";
        b = "bayzxx";
        System.out.println(a + " and " + b + " are permutation of each other? " + p.isPermutation(a, b));
    }

    public boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Hashtable<Character, Integer> ht = new Hashtable();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (ht.containsKey(c)) {
                int val = ht.get(c) + 1;
                ht.put(c, val);
            } else {
                ht.put(c, 1);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (ht.containsKey(c)) {
                int val = ht.get(c);
                if (val == 0) {
                    return false;
                }
                val--;
                ht.put(c, val);
            } else {
                return false;
            }
        }
        Set<Character> keys = ht.keySet();
        for (Character k : keys) {
            if (ht.get(k) != 0) {
                return false;
            }
        }
        return true;
    }
}
