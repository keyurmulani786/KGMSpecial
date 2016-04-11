/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author keyur
 */

class BusinessInfo {
 int id;
 List<String> categories;

 public BusinessInfo(int id, List<String> categories){
   this.id = id;
   this.categories = categories;
 }
}

class Solution1 {

 public static final List<String> CATEGORIES_TO_MATCH = Arrays.asList("restaurants", "japanese");

 /**
  *  Return all business ids whose categories include both
  * 'restaurants' and 'japanese'. (available in global list CATEGORIES_TO_MATCH)
  *
  * @param businessInfoList List of business info objects where BusinessInfo
  *     is a class containing id and categories.
  *
  * @return List of business ids matching
  */
 public static List<Integer> categorySearch(List<BusinessInfo> businessInfoList) {
   //TODO: COMPLETE ME
     List<Integer> list=new ArrayList<>();
     for(BusinessInfo bi:businessInfoList){
         int id=bi.id;
         List<String> categories=bi.categories;
         int i=0;
         for(String category:categories){
             
             if(CATEGORIES_TO_MATCH.contains(category)){
                 i++;
             }
         
         }
         System.out.println("i::"+i);
         if(i>=2){
            list.add(id);
         }        
         
     }
     return list;
 }

 public static void main(String[] args) {
   String line;
   List<BusinessInfo> businessInfoList = new ArrayList<BusinessInfo>();
   
     List<Integer> matching_business_ids = categorySearch(businessInfoList);
     Collections.sort(matching_business_ids);
     for(int business_id : matching_business_ids)
       System.out.println(business_id);
   
 }
}