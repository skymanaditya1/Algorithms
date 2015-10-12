package com.recursionandbacktraction;

import java.util.Scanner;

/**
 * Created by aditya on 12/10/15.
 */
public class Factorial {

    public static int factorial (int n){
        if (n == 0 || n == 1)
            return 1;
        return n * factorial (n - 1);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number whose factorial is to be found : ");
        int n = in.nextInt();
        System.out.println("The factorial of the number is : "+factorial(n));
        in.close();
    }
}
