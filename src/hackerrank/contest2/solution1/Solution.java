/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.contest2.solution1;

/**
 *
 * @author keyur
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        
        int A=0,B=0;
        
        if(a0>b0 ){
            A++;
        }else if(a0<b0){
            B++;
        }
        if(a1>b1){
            A++;
        }else if(a1<b1){
            B++;
        }
        
        if(a2>b2){
            A++;
        }else if(a2<b2){
            B++;
        }
        System.out.println(A+" "+B);
        
    }
    
}
