/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructure.map;

/**
 *
 * @author keyur
 */
public class MyMapTest {

    public static void main(String[] args) {
        MyMap map = new MyMap();
        map.put("Keyur", "No1");
        map.put("Punya", "Name");
        map.put("Goal", "Definate");
        
        System.out.println("val::" + map.get("Keyur"));
        System.out.println("val::" + map.size());
        
        map.remove("Goal");
        System.out.println("val::" + map.size());
        map.put("Punya", "Passion");
        System.out.println("Val::" + map.get("Punya"));
    }
}
