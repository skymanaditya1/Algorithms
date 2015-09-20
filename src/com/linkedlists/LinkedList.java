package com.linkedlists;

import java.util.List;

/**
 * Created by Aditya on 9/20/2015.
 */

class ListNode{
    private int data;
    private ListNode next;

    public ListNode(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext(ListNode next){
        this.next = next;
    }
}

public class LinkedList {

    ListNode head;
    private int length = 0;

    public LinkedList(){
        length = 0;
    }

    // Return the first node in the list
    public synchronized ListNode getHead(){
        return head;
    }

    // Insert a node at the beginning of the list
    public synchronized void insertAtBegin(ListNode node){
        node.setNext(head);
        head = node;
        length++;
    }

    // Insert a node at the end of the list
    public synchronized void insertAtEnd(ListNode node){
        if (head == null){
            head = node;
        }
        else{
            ListNode temp = head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    // Add a new value to a list at a given position
    public synchronized void insert(int data, int position){
        ListNode node = new ListNode(data);
        // Correct the position
        if(position < 0)
            position = 0;
        if (position > length)
            position = length;
        // if the list is empty make it the only element
        if (head == null)
           head = node;

        // if adding the node to the front of the list
        else if (position == 0)
            insertAtBegin(node);

        /** insertAtBegin(node) can be replaced with the following method
         * ListNode temp = new ListNode(data);
         * temp.setNext(head);
         * head = temp;
         */

        // else find the correct position and insert the element
        else{ // takes care of even inserting the node at the last position
            ListNode temp = head;
            for(int i=1; i<position; i++){
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }

        length += 1; // the length of the linked list is 1 long
    }

    // Remove and return the node at the head of the list
    public synchronized ListNode removeFromBegin(){
        ListNode node = head;
        if(node!=null){
            head = node.getNext();
            node.setNext(null);
        }

        return node;
    }

    // Remove and return the node from the end of the list
    public synchronized ListNode removeFromEnd(){
        /**
         * Three cases possible
         * 1. The linked list is empty, return null in that case.
         * 2. The linked list has only one element (namely head), return head and remove it
         * 3. The linked list has many elements, remove and return the last element
          */
        if (head == null)
            return null;
        ListNode p = head, q = head.getNext(), next = null;
        if (q == null){
            head = null;
            return p;
        }

        else{
            // Return and remove the last element
            while((next=p.getNext())!=null){
                q = p;
                p = next;
            }
            q.setNext(null);
            return p;
        }
    }

    // Remove a node matching a specified node from the list
    public synchronized void removeMatched(ListNode node){
        if(head == null)
            return;
        // if the node matches the head node
        if (node.equals(head)){
            head = head.getNext();
            return;
        }

        // otherwise remove the node if found in the list, until the end of the list
        ListNode p = head, q= null;
        while((q=p.getNext())!=null){
            if(node.equals(q)){
                p.setNext(q.getNext());
                return;
            }
            p = q;
        }
    }

    // Removes the value at a given position in the list.
    // If the position is less than 0, remove the value at position 0
    // If the position is greater than the length of the list, remove the value at the last position
    // Else remove the value at the correct position
    public void removeAtPosition(int position){
        if (position < 0)
            position = 0;
        if (position >= length)
            position = length - 1;
        if (head == null)
            return;
        if (position == 0)
            head = head.getNext();
        else{
            // advance to the correct position , and remove the value from that position
            ListNode p = head;
            for(int i=1; i<position; i++){
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
        }
        // reduce the length of the linked list by 1
        length = length -1 ;
    }

    // Return a string representation of the collection, of the form ["str1", "str2", ...]
    // Implements the toString() method
    public String toString(){
        String result = "[";
        if (head == null){
            return result + "]";
        }
        result = result + head.getData();
        ListNode temp = head.getNext();
        while(temp!=null){
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        result = result + "]";
        return result;
    }

    // Return the current length of the list
    public int length(){
        return length;
    }

    // Find the position of the first value that is equal to a given value
    // The equals method can be used to determine the equality
    public int getPosition(int data){
        // returns the position of the first matched value with the given value in the linked list
        ListNode temp = head;
        int pos = 0;
        while(temp!=null){
            if (temp.getData()==data){
                return pos;
            }
            pos += 1;
            temp = temp.getNext();
        }
        // return -1 if the value was not found in the linked list
        return -1;
    }

    // Remove everything from the linked list / empty the linked list
    public void clearList(){
        // Assign a temp node to the current node, clear the current node, use the temp node
        // to get the following node, repeat the process
        ListNode temp = head;
        while(temp!=null){
            head = null;
            temp = temp.getNext();
            head = temp;
        }
        length = 0;
    }
}