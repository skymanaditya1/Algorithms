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
    }
}
