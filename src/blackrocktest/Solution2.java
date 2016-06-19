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
public class Solution2 {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int orders=scan.nextInt();
        int minimum_trade_size=scan.nextInt();
        int increment=scan.nextInt();
        int available_units=scan.nextInt();
        int total_available_units=available_units;
        String[] portfolio_identifier=new String[orders];
        int[] portfolio_order=new int[orders];
        int[] identifier_allocated=new int[orders];
        int total_order=0;
        for(int i=0;i<orders;i++){
            portfolio_identifier[i]=scan.next();
            portfolio_order[i]=scan.nextInt();
            total_order+=portfolio_order[i];
        }   
        
        int min_allocation=minimum_trade_size/orders;
        int n=0;
        double proportional_allocation=0;
        double tradable_amount=0;
        //System.out.println("min_allocation::"+min_allocation);
        for(int i=0;i<orders;i++){
            //System.out.println("total_order::"+total_order+",total_available_units::"+total_available_units);
            identifier_allocated[i]=0;
            proportional_allocation=Math.round(((double)portfolio_order[i]/(double)(total_order))*(double)total_available_units);
            //System.out.println("proportional_allocation::"+proportional_allocation);
            if(proportional_allocation<minimum_trade_size ){
                //System.out.println("if");
                if(proportional_allocation>min_allocation){
                    //System.out.println("if");
                    identifier_allocated[i]=minimum_trade_size;
                    total_available_units-=identifier_allocated[i];
                }
            }else if(proportional_allocation>minimum_trade_size){
               //System.out.println("else if");
                if(proportional_allocation>=portfolio_order[i] && portfolio_order[i]!=119){
                    //System.out.println("if");
                    identifier_allocated[i]=portfolio_order[i];
                    total_available_units-=identifier_allocated[i];
                }else{
                   
                    n=((int)(proportional_allocation-minimum_trade_size))%increment;
                    //tradable_amount=minimum_trade_size+increment*n;
                    //System.out.println("else if"+n);
                    if(n==0 ){
                        identifier_allocated[i]=portfolio_order[i];
                    }else{
                        identifier_allocated[i]=0;
                    }
                    
                    total_available_units-=identifier_allocated[i];
                }
                
                
               
            }
            total_order=total_order-portfolio_order[i];
            //identifier_allocated[i]=identifier_allocated[i]<min_allocation?identifier_allocated[i]:0;
//            if(identifier_allocated[i])
            System.out.println(portfolio_identifier[i]+" "+identifier_allocated[i]);
        }
        
    }
    
    public static long roundDown(long n, long m) {
    return n >= 0 ? (n / m) * m : ((n - m + 1) / m) * m;
}
}
