/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 *
 * @author keyur
 */
public class Solution2 {

//    public static void main(String[] args) {
//
//        System.out.println(solution(223336226));
//    }
    public static void main(String[] args) {
        String s = "DEEP";
        String result = addAsterisk(s, 0);
        System.out.println(s);
        System.out.println(result);
    }

    public static String addAsterisk(String x, int i) {
        if ((x.length() - 1) == i) {
            return String.valueOf(x.charAt(i));
        } else {
            System.out.println("i::" + i);
            String tmp = String.valueOf(x.charAt(i)) + "*";
            tmp = tmp + addAsterisk(x, ++i);

            System.out.println("tmp::" + tmp);

            return tmp;

        }

    }

//    public static void main(String[] args) {
//        int[] x = {7, 4, 7, 6, 16, 8};
//        int sum = 0;
//        int sum1 = 0;
//        if (x.length == 1) {
//            System.out.println("Not a valid value");
//        }
//
//        for (int i = 0; i < x.length; i++) {
//            sum = sum + x[i];
//            System.out.println(sum);
//            for (int j = i + 1; j < x.length; j++) {
//                sum1 = sum1 + x[j];
//                System.out.println("SUm1:" + sum1);
//
//            }
//
//            if (sum == sum1) {
//                System.out.println("split possible");
//                System.out.println("Sum:" + sum + "Sum1:" + sum1);
//                break;
//            } else {
//                System.out.println("Split not possible");
//            }
//
//            sum1 = 0;
//        }
}

//private static int solution(int no) {
//
//        String strNum = String.valueOf(no);
//        String mainStr = strNum;
//        HashMap<Integer, Integer> hm = new HashMap();
//        boolean flag = false;
//        int indexNo = 0;
//        for (int i = 0; i < strNum.length(); i++) {
//            int val = Integer.valueOf(strNum.charAt(i));
//            if (hm.isEmpty() || hm.get(val) != null) {
//
//                hm.put(val, 1);
//            } else {
//                flag = true;
//                System.out.println("--" + i);
//                indexNo = i;
//                break;
//            }
//        }
//        if (flag) {
//            strNum = mainStr.substring(0, indexNo - 1);
//            System.out.println("sstr::" + strNum);
//            System.out.println("sstr::" + mainStr.substring(indexNo + 1, mainStr.length()));
//            strNum = strNum + mainStr.substring(indexNo + 1, mainStr.length());
//        }
//        return Integer.valueOf(strNum);
//    
//
//}


//}

class solution2_2 extends Solution2 {

    public static void main(String a[]) {
        System.out.println("2222");
    }

    static void g() {
    }
}
