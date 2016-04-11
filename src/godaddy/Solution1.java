/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package godaddy;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.security.sasl.Sasl;

/**
 *
 * @author keyur
 */
public class Solution1 {

//    static int i, j, k, c = 0, w;
    public static void main(String[] args) {

//        int[] f = {7000, 7000, 12000, 13000, 6900};
//        int[] m = {6910, 7010, 7000, 12000, 18000, 15000, 10450};
        int[] f = {10670, 11057, 16111, 17203, 10390, 8500, 7551, 11517, 12848, 6988, 17875, 11751, 8500};
        int[] m = {14376, 17203, 16797, 8350, 8500, 7155, 12365, 16111, 16111, 17875, 13115, 10048, 8500};

        intersection(f, m);
    }

    static void intersection(int f[], int m[]) {

//        List<Integer> xList = new ArrayList<Integer>();
//        for (int index = 0; index < f.length; index++) {
//            xList.add(f[index]);
//        }
//        List<Integer> yList = new CopyOnWriteArrayList<Integer>();
//        for (int index = 0; index < m.length; index++) {
//            yList.add(m[index]);
//        }
//
//        Set<Integer> canAdd = new HashSet<Integer>(xList);
//    List<Integer> result = new ArrayList<Integer>();
//
//    for (int n: xList) {
//        if(yList.contains(n)) {
//            result.add(n);
//            // we wish to add only one n
//            yList.remove(n);
//        }
//    }
//        System.out.println("result::"+result);
//    return result;
        int i, j, k, c = 0, w;

        Map<Integer, Integer> hm = new HashMap();
        for (j = 0; j < m.length; j++) {
            if (hm.isEmpty() || hm.get(m[j]) == null) {
                hm.put(m[j], 1);
            } else {
                int count = hm.get(m[j]);
                hm.put(m[j], ++count);
            }
        }
        List<Integer> list = new ArrayList();
        System.out.println("hm::" + hm);
        for (i = 0; i < (f.length); i++) {
            for (j = 0; j < m.length; j++) {

                if (f[i] == m[j]) {
                    System.out.println(f[i]+"--"+hm.get(f[i]));
                    if (hm.get(f[i]) != null && !hm.get(f[i]).equals(0)) {
                        int count = hm.get(f[i]);
                        hm.put(f[i], --count);
                        System.out.println("---"+f[i]);
                        list.add(f[i]);
                        break;
//                        z[c] = f[i];
//
//                        c++;
                    }
                } else {
                    continue;
                }

            }
        }

        int[] z = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            z[i] = Integer.valueOf(list.get(i));
        }

        int n = z.length;
        int temp = 0;

        for (i = 0; i < n; i++) {
            for (j = 1; j < (n - i); j++) {

                if (z[j - 1] < z[j]) {
                    //swap the elements!
                    temp = z[j - 1];
                    z[j - 1] = z[j];
                    z[j] = temp;
                }

            }
        }
        for (i = 0; i < list.size(); i++) {
            System.out.println(" "+z[i]);
        }
    }
}
