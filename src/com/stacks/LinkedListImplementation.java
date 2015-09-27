package com.stacks;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Created by Aditya on 9/27/2015.
 */

class node {
    private int data;
    private node next;

    public node() {
        data = 0;
        next = null;
    }

    public node(int data) {
        this.data = data;
        next = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(node next) {
        this.next = next;
    }

    public node getNext() {
        return next;
    }
}

class ListStack {
    private int length;
    private node top;

    public ListStack() {
        length = 0;
        top = null;
    }

    // method to push an element at the top of the stack
    public void push(int data) {
        node newNode = new node(data);
        newNode.setNext(top);
        top = newNode;
        length++;
    }

    // method to return and remove the top of the stack
    public int pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        int data = top.getData();
        top = top.getNext();
        length--;
        return data;
    }

    // method to generate the size of the list, length is also a variable to maintain the count of the list
    public int size() {
        node temp = top;
        int count = 0;
        while (temp != null) {
            temp = temp.getNext();
            count = count + 1;
        }
        return count; // return length; // also returns the length of the list
    }

    // method to check whether a given stack is empty or not
    public boolean isEmpty() {
        return (top == null);
    }

    // method that returns the top of the stack, without removing it
    public int top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return top.getData();
    }

    // method to print the contents of the stack, implements the toString() method
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += top.getData();
            node temp = top.getNext();
            while (temp != null) {
                result += "," + temp.getData();
                temp = temp.getNext();
            }
        }
        result += "]";
        return result;
    }
}

public class LinkedListImplementation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int data;
        ListStack s = new ListStack();
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
                    s.push(data);
                    break;
                case 2:
                    try {
                        System.out.println("The popped element is : " + s.pop());
                    } catch (Exception e) {
                        System.out.println("Exception of type : " + e.toString());
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
                    System.out.println("The size of the stack is : " + s.size());
                    break;
                case 5:
                    System.out.println("The contents of the stack are ");
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
