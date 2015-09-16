package com.recursionandbacktraction;

import java.util.Scanner;

/**
 * Created by Aditya on 9/16/2015.
 */
public class TowerOfHanoiProblen {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of disks : ");
        int numberOfDisks = in.nextInt();
        TowersOfHanoi(numberOfDisks, 'A', 'B', 'C');
        in.close();
    }

    public static void TowersOfHanoi(int n, char frompeg, char topeg, char auxpeg){
        if (n == 1){
            System.out.println("Move disk 1 from peg "+frompeg+" to peg "+topeg);
            return; // Return statement to avoid infinite recursion
        }
        /* Move the first n-1 disks from frompeg to auxpeg*/
        TowersOfHanoi(n-1, frompeg, auxpeg, topeg);

        /* Move the nth disk from frompeg to topeg*/
        System.out.println("Move disk from peg "+frompeg+" to peg "+topeg);

        /* Move the n-1 disks from auxpeg to topeg*/
        TowersOfHanoi(n-1, auxpeg, topeg, frompeg);
    }
}
