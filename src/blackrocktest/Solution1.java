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
public class Solution1 {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int numQuotes=scan.nextInt();
        double[] firstQuote=new double[numQuotes];
        double[] secondQuote=new double[numQuotes];
        double[] thirdQuote=new double[numQuotes];
        int[] profit=new int[numQuotes];
        double usd=100000;
        double eur=0;
        double gbp=0;
        for(int i=0;i<numQuotes;i++){
            firstQuote[i]=scan.nextDouble();
            secondQuote[i]=scan.nextDouble();
            thirdQuote[i]=scan.nextDouble();
            eur=usd/firstQuote[i];
            System.out.println("eur::"+eur);
            gbp=eur/secondQuote[i];
            System.out.println("gbp::"+gbp);
            double result=gbp/thirdQuote[i];
            System.out.println("result::"+result);
            profit[i]=(int) ((int) (result-usd)>0?(result-usd):0);
        }
        
        for(int i=0;i<numQuotes;i++){
            System.out.println(profit[i]);
        }
        
    }
}
