package com.recursionandbacktraction;

import java.util.Scanner;

/**
 * Created by aditya on 13/10/15.
 * Generates the nth fibonacci numbers
 */
public class FibonacciNumbers {

    public static int gen_fibo(int n){
        if ( n == 0 )
            return 0;
        else if ( n == 1)
            return 1;
        else return gen_fibo( n - 1) + gen_fibo( n - 2);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of n : ");
        int n = in.nextInt();
        System.out.println(gen_fibo(n));
        in.close();
    }
}
