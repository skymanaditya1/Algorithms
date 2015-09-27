package com.stacks;

import java.util.Scanner;

/**
 * Created by Aditya on 9/27/2015.
 */

// Exception thrown when pop() or top() operation is performed on an empty stack
class UnderflowException extends Exception {
    public UnderflowException() {
        System.out.println("Underflow Exception ");
    }

    public UnderflowException(String str) {
        System.out.println("Overflow Exception ");
    }
}

// Exception throws when push() operation is performed on a full stack
class OverflowException extends Exception {
    public OverflowException() {
        System.out.println("Overflow Exception ");
    }

    public OverflowException(String str) {
        System.out.println("Exception of type " + str);
    }
}

class ArrayStack {
    private static final int CAPACITY = 10; // default stack capacity
    protected int capacity;
    protected int top = -1;
    protected int[] stack; // the array stack

    public ArrayStack() {
        this(CAPACITY); // sets the default capacity
    }

    public ArrayStack(int cap) {
        capacity = cap;
        stack = new int[capacity];
    }

    // method that returns the size of the stack, O(1) time complexity
    public int getSize() {
        return (top + 1);
    }

    // method that returns boolean to indicate if stack is empty, O(1) time complexity
    public boolean isEmpty() {
        return (top < 0);
    }

    // method to push an element into a stack, throws Overflow if the stack is full, O(1) time complexity
    public void push(int data) throws Exception {
        if (getSize() == capacity)
            throw new Exception("Stack is full");
        // push the element into the stack
        stack[++top] = data;
    }

    // method to return the top of the stack without removing it, O(1) time complexity, throws UnderflowException if
    // stack is empty
    public int top() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return stack[top];
    }

    // method to remove and return the top of the stack, O(1) time complexity, throws UnderflowException if stack empty
    public int pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        int data = stack[top];
        stack[top--] = Integer.MIN_VALUE; // set some arbitrary value for the element removed
        return data;
    }

    // method to print a string representation of the elements of the stack, implements the toString() method,
    // printing starts from the top of the stack
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += stack[top];
            for (int i = top - 1; i >= 0; i--) {
                result += "," + stack[i];
            }
        }
        result += "]";
        return result;
    }
}

public class FixedArrayStackImplementation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many elements in the stack : "); // if left empty, default capacity 10 is taken
        int size = in.nextInt();
        int data;
        ArrayStack s = new ArrayStack(size);
        // ArrayStack s = new ArrayStack(); // takes the default capacity as specified by CAPACITY (10 in this case)
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
                    System.out.println("Insert the element to be pushed : ");
                    data = in.nextInt();
                    try {
                        s.push(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Popped element is : " + s.pop());
                    } catch (Exception e) {
                        e.printStackTrace();
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
                    System.out.println("The size of the stack is : "+s.getSize());
                    break;
                case 5:
                    System.out.println("The contents of the stack from top are ");
                    System.out.println(s.toString());
                    break;
                default:
                    System.out.println("Exit...");
                    System.exit(0);
                    break;
            }
        }
    }
}
