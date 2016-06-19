/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackrocktest;

import java.util.Scanner;

/**
 *
 * @author keyur
 */
public class Solution4 {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int numEmp=scan.nextInt();
        int[] rate=new int[numEmp];
        int[] minShare=new int[numEmp] ;
        for(int i=0;i<numEmp;i++){
            rate[i]=scan.nextInt();
        }
        for(int i=0;i<numEmp;i++){
            minShare[i]=scan.nextInt();
        }
        int previosRange=0, nextRange=0;
        for(int i=0;i<numEmp;i++){
            previosRange=i-10>0?i-10:0;
            nextRange=i+10>numEmp?numEmp:i+10;
            minShare[i]=getMinShare(rate, minShare, i, previosRange, nextRange);
            
        }
        
            
    }
    public static int getMinShare(int[] rate,int[] share,int index,int previosRange,int nextRange){
        int inShare=share[index];
        int inRate=rate[index];
        System.out.println("prev::"+previosRange+",next::"+nextRange);
        for(int i=previosRange;i<nextRange;i++){
            if(i!=index && inRate>rate[i] && inShare<=share[i]){
                inShare++;
            }
        }
        return inShare;
    }
}
