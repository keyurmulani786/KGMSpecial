/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author keyur
 */
public class Solution1 {
    
    public static void main(String[] args) {
        Order o=new Order();
        
        ArrayList<OrderDepepdency> orderDependceny=new ArrayList();
        validOrder(orderDependceny);
    }
    public static ArrayList<Order> validOrder(ArrayList<OrderDepepdency> orderDependceny){
        
        HashMap<Order,Order> map=new HashMap<>();
        
        ArrayList<Order> list=new ArrayList<>();
        int length=orderDependceny.size();
        System.out.println("len::"+length);
        Order dependency;
        for(int i=length-1;i>=0;i--){
            OrderDepepdency o=orderDependceny.get(i);
            dependency=o.dependceny;
            Order order=o.order;
            if(i==length-1){
                list.add(o.dependceny);
            }
            for(int j=length-1;j>=0;j--){
                dependency=o.dependceny;
                
                list.add(o.dependceny);
            }
            
            
        }
        
        return null;
    }
}
class Order{
    public String orderName;
}
class OrderDepepdency{
    public Order order;
    public Order dependceny;
}
