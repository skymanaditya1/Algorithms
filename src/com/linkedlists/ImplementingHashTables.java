package com.linkedlists;

import java.util.*;

/**
 * Created by Aditya on 9/24/2015.
 * Dictionaries in Java are implemented as HashTables
 * HashTables are different from HashMaps in that they provide
 * synchronized access to table, whereas HashMap does not
 */
public class ImplementingHashTables {
    public static void main(String[] args){
        // Creating a Hash Table
        Hashtable hash = new Hashtable();

        // Add items to the hash table
        hash.put("John", new Double(100)); // key value pair
        hash.put("Peter", new Double(200));
        hash.put("Clark", new Double(300));
        hash.put("Bruce", new Double(400));

        // Get a particular value
        double bal = (Double)hash.get("Aditya");
        System.out.println("Retrieving an entry ");
        System.out.println("Aditya's balance : "+bal);

        // Iterate through all the values inside the hash
        System.out.println("Printing the values of the hash");
        Enumeration val = hash.keys();
        while(val.hasMoreElements()){
            String str = (String) val.nextElement();
            System.out.println(str+" : "+hash.get(str));
        }

        // Changing the entry of the table
        System.out.println("Changing an entry of the table ");
        double changeBal = (Double) hash.get("Clark");
        hash.put("Clark", new Double(changeBal+300));

        // Iterate through all the values inside the hash
        Enumeration newValues = hash.keys();
        while(newValues.hasMoreElements()){
            String str = (String) newValues.nextElement();
            System.out.println(str +" : "+ hash.get(str));
        }
    }
}
