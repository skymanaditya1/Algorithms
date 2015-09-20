package com.LinkedList1s;

import java.util.Scanner;

/**
 * Linked List Complete Implementation
 * @author Aditya
 *
 */

class ListNode1{
    private int data;
    private ListNode1 next;

    public ListNode1(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(ListNode1 next){
        this.next = next;
    }

    public ListNode1 getNext(){
        return next;
    }
}

class LinkedList1{
    ListNode1 head;
    private int length = 0; // length of the linked list

    public LinkedList1(){
        length = 0;
    }

    public ListNode1 getHead(){
        return head;
    }

    // Inserts an element at the beginning of the list
    public synchronized void insertAtBegin(ListNode1 node){
        node.setNext(head);
        head = node;
        length = length + 1;
    }

    // Inserts an element at the end of the list
    public synchronized void insertAtEnd(ListNode1 node){
        if (head == null){
            head = node;
        }
        else{
            ListNode1 temp = head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    // Inserts an element at a given position in the list
    public synchronized void insert(int data, int position){
        ListNode1 node = new ListNode1(data);
        // Set the position
        if (position < 0){
            position = 0;
        }
        if (position > length){
            position = length;
        }
        // If the head is null
        if(head == null)
            head = node;

        else if (position == 0){
            node.setNext(head);
            head = node;
        }

        else{
            ListNode1 temp = head;
            for(int i=1; i<position; i++){
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        length = length + 1;
    }

    // Removes an element from the beginning of the list
    public synchronized ListNode1 removeFromBegin(){

        ListNode1 q = head;
        if (q!=null){
            head = q.getNext();
            q.setNext(null);

        }

        return q;
    }

    // Remove an element from the end of the list
    public synchronized ListNode1 removeFromEnd(){

        ListNode1 p = head, q = null, next = head.getNext();

        if (head == null)
            return null;

        else if (next == null){
            head = null;
            return p;
        }

        else{
            while((next=p.getNext())!=null){
                q = p;
                p = next;
            }
            q.setNext(null);
            return p;
        }
    }

    // Remove matched, removes the first occurrence of a matched value
    // with a specific value in a linked list
    public void removeMatched(ListNode1 node){
        if ( head == null)
            return;
        else if (node.equals(head)){
            head = head.getNext();
            return;
        }
        else{
            // Traverse through all the elements until a matching value is found
            ListNode1 p = head, q = null;
            while((q=p.getNext())!=null){
                if (node.equals(q)){
                    p.setNext(q.getNext());
                    return;
                }
                p = q;
            }

            if (q==null){
                System.out.println("Given element not found in the list ");
            }
        }
    }

    // Removes an element / item from a given position
    public void remove(int position){
        // fix the position
        if (position < 0){
            position = 0;
        }
        if (position >= length){
            position = length - 1;
        }

        // If the head of the list is empty
        if (head == null)
            return;
        else if (position == 0){
            // remove the head of the list
            head = head.getNext();
            return;
        }

        else{
            // find the position to remove the element from
            ListNode1 p = head;
            for(int i=1; i<position; i++){
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
        }

        // reduce the length of the list by 1
        length = length - 1;
    }

    // Prints out a string representation of the elements in the list
    public String toString(){
        String result = "[";
        if(head == null){
            return result + "]";
        }
        result = result + head.getData();
        ListNode1 temp = head.getNext();
        while(temp!=null){
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }
}

public class SinglyLinkedList {

    @SuppressWarnings("resource")
    public static void main(String[] args){
        int data;
        ListNode1 node;
        LinkedList1 list = new LinkedList1();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Menu");
            System.out.println("1. Insert an element at the beginning ");
            System.out.println("2. Insert an element at the end ");
            System.out.println("3. Insert an element ");
            System.out.println("4. Remove an element from the beginning ");
            System.out.println("5. Remove an element from the end ");
            System.out.println("6. Remove a matched item from the list ");
            System.out.println("7. Remove an element from a specific position  ");
            System.out.println("8. Traverse the list ");

            switch(in.nextInt()){

                case 1:System.out.println("Enter the element to be inserted : ");
                    data = in.nextInt();
                    node = new ListNode1(data);
                    list.insertAtBegin(node);
                    break;

                case 2:System.out.println("Enter the element to be inserted : ");
                    data = in.nextInt();
                    node = new ListNode1(data);
                    list.insertAtEnd(node);
                    break;

                case 3:System.out.println("Enter an element to insert : ");
                    data = in.nextInt();
                    System.out.println("Enter the position of the element to be inserted : ");
                    int position = in.nextInt();
                    list.insert(data, position);
                    break;

                case 4:System.out.println("The element removed is "+list.removeFromBegin().getData());
                    break;

                case 5:System.out.println("The element removed is "+list.removeFromEnd().getData());
                    break;

                case 6:System.out.println("Enter the element to be removed : ");
                    data = in.nextInt();
                    node = new ListNode1(data);
                    list.removeMatched(node);
                    break;

                case 7:System.out.println("Enter the position : ");
                    int pos = in.nextInt();
                    list.remove(pos);
                    break;

                case 8:System.out.println("Traversing the list : ");
                    System.out.println(list.toString());
                    break;

                default:
                    System.out.println("Good Bye");
                    System.exit(0);
            }
        }
    }
}
