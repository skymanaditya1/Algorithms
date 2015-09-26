package com.linkedlists;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Aditya on 9/26/2015.
 * How to check if a string of arrays has duplicate entries using hash table
 */

public class CheckDuplicateUsingHash {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements ");
        int num = in.nextInt();
        in.nextLine();
        String[] str = new String[num];
        System.out.println("Enter the elements of the array ");
        for(int i=0; i<str.length; i++){
            str[i] = in.nextLine();
        }
        // display(str);

        checkDuplicate(str);

        in.close();
    }

    private static void checkDuplicate(String[] str) {

        if(str.length == 0)
            return;

        boolean flag = true;

        // Create a hash table
        Hashtable hashtable = new Hashtable();

        // Add the first entry to the hash table , assuming the string array is not null
        hashtable.put(str[0], 0);

        // Create an enumeration for the entries of the hash table
        Enumeration values = hashtable.keys();

        for(int i=1; i<str.length; i++){
            while(values.hasMoreElements()){
                String str1 = (String) values.nextElement();
                if (str1.equals(str[i])){
                    flag = false;
                    System.out.println("First duplicate entry found at index "+i);
                    return;
                }
            }
            hashtable.put(str[i], i);
            values = hashtable.keys();
        }

        if(flag)
            System.out.println("Duplicate entries not found ");
    }

    public static void display(String[] str){
        for(int i=0; i<str.length; i++){
            System.out.println(str[i]+" ");
        }
    }
}
