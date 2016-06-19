package hackerrank;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int minNumOfJumps=getMinNumOfJumps(c);
        System.out.println(minNumOfJumps);
    }
    
    public static int getMinNumOfJumps(int[] c) {
        int count = 0;
        int i;
        for (i = 0; i < c.length-2; i++) {
            if (c[i + 1] == 0 && c[i + 2] == 1) {
                int tmp = i + 1;
                count++;
            } else if ((c[i + 1] == 0 && c[i + 2] == 0)||(c[i + 1] == 1 && c[i + 2] == 0)) {
                count++;
                i = i+1;
            }
        }
        if(i!=c.length-1 && c[c.length-1]==0){
            count++;
        }
        return count;
    }
}
