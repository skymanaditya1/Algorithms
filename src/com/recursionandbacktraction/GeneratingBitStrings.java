package com.recursionandbacktraction;

import java.util.Scanner;

/**
 * Created by Aditya on 9/16/2015.
 * Program generates all bit strings of size n
 */
public class GeneratingBitStrings {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of n : ");
        int bitStringSize = in.nextInt();
        generateBitStrings1(bitStringSize);
        in.close();
    }

    /**
     * Approach 1
     * First generate all numbers until size n
     * Then generate the binary number for the given number
     * Store the binary number inside the array of arrays
     * Does not involve recursion or backtracking
     * @param size
     */
    public static void generateBitStrings1(int size){
        int[][] numBinStrings = new int[(int) Math.pow(2, size)][size];
        for(int num=0; num<size; num++){
            convertToBinary(num);
        }
    }

    public static void convertToBinary(int n){
        String binEquivalent = "";
        while(n > 0){
            binEquivalent += n%2;
            n = n / 2;
        }
        System.out.println(new StringBuilder(binEquivalent).reverse().toString());
    }
}
