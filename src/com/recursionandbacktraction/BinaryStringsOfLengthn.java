package com.recursionandbacktraction;

import java.util.Scanner;

/**
 * Created by Aditya on 9/16/2015.
 * Prints out all binary strings of length n
 */
public class BinaryStringsOfLengthn {

    public static int[] array;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the bit string : ");
        int bitLength = in.nextInt();
        array = new int[bitLength];
        generateBitStrings(bitLength);
        in.close();
    }

    public static void generateBitStrings(int n){
        if (n < 1){
            printArray(array);
        }
        else{
            array[n - 1] = 0;
            generateBitStrings(n-1);
            array[n - 1] = 1;
            generateBitStrings(n-1);
        }
    }

    public static void printArray(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+"");
        }
        System.out.println();
    }
}
