package com.recursionandbacktraction;

import java.util.Scanner;

/**
 * Created by Aditya on 9/16/2015.
 */
public class DecimalNumberToBinary {
        public static void main(String[] args){
                Scanner in = new Scanner(System.in);
                System.out.println("Enter the decimal number : ");
                int decimalNumber = in.nextInt();
                convertToBinary(decimalNumber);
                in.close();
        }

        public static void convertToBinary(int n){
                String binString = "";
                while(n > 0){
                        binString += n % 2;
                        n = n / 2;
                }
                System.out.println(reverseString(binString));
        }

        public static String reverseString(String str){
                return new StringBuilder(str).reverse().toString();
        }
}
