package com.stacks;

import java.util.Scanner;

/**
 * Created by Aditya on 9/27/2015.
 */

// Dynamic Array Stack Implementation using Repeated Doubling Operations

class DynamicStack {
    protected int capacity; // capacity of the stack
    public static final int CAPACITY = 16; // default capacity of the stack, power of 2
    protected int top = -1; // top of the stack
    public static final int MIN_CAPACITY = 1; // power of 2
    protected int[] stack;

    public DynamicStack() {
        this(CAPACITY); // sets the stack with the default capacity
    }

    public DynamicStack(int cap) {
        capacity = cap;
        stack = new int[capacity];
    }

    // method for returning the size of the stack, O(1) implementation
    public int size() {
        return (top + 1);
    }

    // method to check if a stack is empty or not
    public boolean isEmpty() {
        return (top < 0);
    }

    // method to push an element at the top of the stack
    public int push(int data) throws Exception {
        if (size() == capacity) {
            expand(); // Method to expand the array by doubling it.
            System.out.println("Stack expanded ");
        }
        return stack[++top] = data;
    }

    // method for doubling the size of the array and copying the contents from the original array
    public void expand() {
        int length = size(); // size of the current array
        int[] newStack = new int[length << 1]; // new array with twice the size
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
    }

    // method to peek at the top of the stack and return it
    public int top() throws Exception {
        if (isEmpty())
            throw new Exception("Stack empty");
        return stack[top];
    }

    // method to return and remove the top of the stack
    public int pop() throws Exception{
        if(isEmpty())
                throw new Exception("Stack empty");
        int popped = stack[top];
        stack[top--] = Integer.MIN_VALUE; // dereference the previous top of stack for garbage collection
        return popped;
    }

    // method for traversing the contents of the stack, from the top of the stack, implements the toString() method
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += stack[top]; // append the top of the stack
            for (int i = top - 1; i >= 0; i--) {
                result += "," + stack[i];
            }
        }
        result += "]";
        return result;
    }
}

public class DynamicArrayStackImplementation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the initial capacity of the stack : ");
        int size = in.nextInt();
        int data;
        DynamicStack s = new DynamicStack(size);
        // DynamicStack s = new DynamicStack(); // initiates the default constructor, with the size value as 16 (default)
        while (true) {
            System.out.println("Menu. Enter your choice ");
            System.out.println("1. Push an element into the stack ");
            System.out.println("2. Pop an element from the stack ");
            System.out.println("3. Return the top of the stack (Peek) ");
            System.out.println("4. Return the size of the stack ");
            System.out.println("5. Print the contents of the stack ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Insert the element to be pushed ");
                    data = in.nextInt();
                    try {
                        s.push(data);
                    } catch (Exception e) {
                        // e.printStackTrace();
                        System.out.println("Exception of type : "+e.toString());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("The popped element is : " + s.pop());
                    } catch (Exception e) {
                        // e.printStackTrace();
                        System.out.println("Exception of type : "+e.toString());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("The top of the stack is : " + s.top());
                    } catch (Exception e) {
                        System.out.println("Exception of type : " + e.toString());
                    }
                    break;
                case 4:
                    System.out.println("The size of the stack is : "+s.size());
                    break;
                case 5:
                    System.out.println("The contents of the stack are ");
                    System.out.println(s.toString());
                    break;
                default:
                    System.out.println("Exit ...");
                    System.exit(0);
                    break;
            }
        }
    }
}
