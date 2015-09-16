package com.recursionandbacktraction;

import java.util.Scanner;

/**
 * Created by Aditya on 9/16/2015.
 * Program to check whether a given array is sorted using recursion
 */
public class SortedArrayCheckRecursion {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int arraySize = in.nextInt();
        int[] arr = new int[arraySize];
        System.out.println("Enter the elements of the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }
        if(checkIsArraySorted(arr, 0)==1) {
            System.out.println("The array is in sorted order");
        }
        else {
            System.out.println("The array is not sorted");
        }
        in.close();
    }

    public static int checkIsArraySorted(int[] arr, int index){
        if ( index == arr.length - 1){
            return 1;
        }
        return (arr[index] < arr[index+1]?checkIsArraySorted(arr, index+1):0);
    }
}
