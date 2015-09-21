package com.linkedlists;

import java.util.Scanner;

/**
 * Created by Aditya on 9/21/2015.
 * Implementation of Circular Linked Lists in Java
 * Applications of Circular Linked Lists:
 * Used for management of resources in a computer system
 */

class CLLNode{
    private int data;
    private CLLNode next;

    public CLLNode(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(CLLNode next){
        this.next = next;
    }

    public CLLNode getNext(){
        return next;
    }
}

// Method implementation of the circular list
class CircularList{

    protected CLLNode head;
    protected int length;

    public CircularList(){
        length = 0;
        head = null;
    }

    // Method to insert an element at the head of the list
    public void addHead(int data){
        CLLNode node = new CLLNode(data);
        // If the list is empty
        if (head == null){
            head = node;
            head.setNext(head); // set the node to point to itself
        }

        else{
            node.setNext(head);
            CLLNode temp = head;
            while(temp.getNext()!=head)
                temp = temp.getNext();
            temp.setNext(node);
            head = node;
        }
        length = length + 1;
    }

    // Method to insert an element at the tail of the list
    public void addTail(int data){
        // if the list is empty
        CLLNode node = new CLLNode(data);
        if (head == null){
            head = node;
            head.setNext(head);
        }

        else{
            CLLNode temp = head;
            while(temp.getNext()!=head){
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setNext(head);
        }

        length = length + 1;
    }

    // Method to return the data at the head of the list
    public int getHead(){
        // check if the list is empty
        if (head == null)
            return Integer.MIN_VALUE; // return some arbitrarily small value
        else{
            return head.getData();
        }
    }

    // Method to return the data at the tail of the list
    public int getTail(){
        // check if the list is empty
        if (head == null)
            return Integer.MIN_VALUE; // return some arbitrarily small value
        else{
            CLLNode temp = head;
            while(temp.getNext()!=head){
                temp = temp.getNext();
            }
            return temp.getData();
        }
    }

    // Method to return and remove data from the head of the list
    public int removeFromHead(){
        // check if the list is empty
        if (head == null){
            System.out.println("The list is empty");
            return Integer.MIN_VALUE;
        }

        // check if the list has 1 node
        else if (head.getNext() == head){
            CLLNode temp = head;
            head = null;

            length = length - 1; // list size reduces by 1

            return temp.getData();

        }

        else{
            // traverse to the tail of the list
            CLLNode temp = head;
            int tempVal = head.getData();
            while(temp.getNext()!=head)
                temp = temp.getNext();
            head = head.getNext();
            temp.setNext(head);

            length = length - 1; // list size reduces by 1

            return tempVal;
        }
    }

    // Method to return and remove data from the tail of the list

    // Method that implements the toString() method , to print the elements of the list
    public String toString(){
        CLLNode temp = head;
        String result = "";
        if(head == null)
        {
            result = "";
        }
        else {
            // To traverse a circular list , print until the next reaches head
            while(temp.getNext()!=head){
                result = result + temp.getData() + "->";
                temp = temp.getNext();
            }
            result = result + temp.getData();
        }
        return result;
    }
}

public class CircularLinkedList {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int data;
        CircularList list = new CircularList();
        while(true){
            System.out.println("Menu. Choose an option?");
            System.out.println("1. Add an element to the head of the list ");
            System.out.println("2. Add en element to the tail of the list ");
            System.out.println("3. Peek data at the head of the list ");
            System.out.println("4. Peek data at the tail of the list ");
            System.out.println("5. Remove an element from the head of the list ");
            System.out.println("8. Traverse the list ");
            int choice = in.nextInt();
            switch(choice){
                case 1:System.out.println("Insert an element at the head of the list : ");
                    data = in.nextInt();
                    list.addHead(data);
                    break;

                case 2:System.out.println("Insert an element at the tail of the list : ");
                    data = in.nextInt();
                    list.addTail(data);
                    break;

                case 3:System.out.println("The data at the head of the list is "+list.getHead());
                    break;

                case 4:System.out.println("The data at the tail of the list is "+list.getTail());
                    break;

                case 5:System.out.println("Head removed from the list with value "+list.removeFromHead());
                    break;

                case 8:System.out.println();
                    System.out.println(list.toString());
                    break;

                default:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
            }
        }
    }
}
