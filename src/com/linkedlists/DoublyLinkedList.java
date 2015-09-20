package com.linkedlists;

import java.util.Scanner;

/**
 * Created by Aditya on 9/20/2015.
 */

class DLLNode{

    private int data;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(int data){
        this.data = data;
        prev = null;
        next = null;
    }

    public DLLNode(int data, DLLNode prev, DLLNode next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setPrev(DLLNode prev){
        this.prev = prev;
    }

    public DLLNode getPrev(){
        return prev;
    }

    public void setNext(DLLNode next){
        this.next = next;
    }

    public DLLNode getNext(){
        return next;
    }
}

class DLLList{
    private DLLNode head;
    private DLLNode tail;
    private int length; // length of the doubly linked list

    public DLLList(){
        /**head = new DLLNode(Integer.MIN_VALUE, null, null);
        tail = new DLLNode(Integer.MIN_VALUE, head, null);
        head.setNext(tail);*/
        length = 0;
    }

    // Insert an element to the beginning of the list
    public void insertBegin(int data){
        if ( head == null){
            head = new DLLNode(data);
        }
        else{
            DLLNode node = new DLLNode(data, null, head);
            head.setPrev(node);
            head = node;
        }
    }

    // Insert an element at the end of the list
    public void insertEnd(int data){
        DLLNode node = new DLLNode(data);

        if (head == null){
            head = node;
            return;
        }

        DLLNode temp = head;

        while(temp.getNext()!=null){
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPrev(temp);

        length = length + 1;
    }

    // Insert an element in the middle of the list, determined by the position
    public void insert(int data, int position){
        // Fix the position
        if (position < 0)
            position = 0;
        if (position > length)
            position = length;
        if (head == null){
            // make this element the head of the list
            head = new DLLNode(data);
        }

        else if (position == 0){
            // insert the element at the head of the list
            DLLNode node = new DLLNode(data, null, head);
            head.setPrev(node);
            head = node;
        }

        else{
            // insert the node at the correct position
            DLLNode node = new DLLNode(data);
            DLLNode temp = head;
            for(int i=1; i<position; i++){
                temp = temp.getNext();
            }
            temp.getNext().setPrev(node);
            node.setNext(temp.getNext());
            temp.setNext(node);
            node.setPrev(temp);
        }
    }

    // Remove the first node of the list
    public DLLNode removeBegin(){
        if (head == null){
            System.out.println("The list is empty ");
            return new DLLNode(-1);
        }
        else if (head.getNext() == null){
            // Only one node in the list, namely the head
            DLLNode temp = head;
            /**head.setPrev(null);
            head.setNext(null);*/
            head = null;
            return temp;
        }
        else{
            // Remove the head of the list
            DLLNode temp = head;
            head = head.getNext();
            head.setPrev(null);
            return temp;
        }
    }

    // Remove the last node of the list
    public DLLNode removeEnd(){
        if (head == null){
            System.out.println("The list is emtpy ");
            return new DLLNode(-1);
        }

        else if (head.getNext() == null){
            DLLNode temp = head;
            head = null;
            return temp;
        }

        else{
            DLLNode temp = head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            DLLNode node = temp;
            temp.getPrev().setNext(null);
            return node;
        }
    }

    // Returns the length of the list at any instant
    public int getSize(){
        if (head == null)
            return 0;
        int listSize = 0;
        DLLNode node = head;
        while(node!=null){
            listSize += 1;
            node = node.getNext();
        }
        return listSize;
    }

    // Remove an intermediate node of the list given by the position
    public DLLNode remove(int position){
        // Fix the position
        if (position < 0)
            position = 0;
        if (position >= getSize())
            position = getSize() - 1;
        // Check if the head is empty
        if (head == null){
            System.out.println("The list is empty ");
            return new DLLNode(-1);
        }
        // Check if the position is 0, i.e the head is to be removed
        else if (position == 0){
            DLLNode temp = head;
            head = head.getNext();
            if (head != null){
                // remove the prev reference if head is not null
                head.setPrev(null);
            }
            return temp;
        }

        else{
            // remove the appropriate element from the list
            DLLNode node = head;
            for(int i=1; i<position; i++){

            }
        }
    }

    // Traverse the elements of the list
    public String toString(){
        String result = "[";
        if( head == null)
            return result + "]";
        result = result + head.getData();
        DLLNode temp = head.getNext();
        while(temp!=null){
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }


    // Search for an element in a list and return the position if found

}

public class DoublyLinkedList {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int data;
        DLLList list = new DLLList();
        DLLNode node;
        while(true){
            System.out.println("Menu. Enter your choice?");
            System.out.println("1. Insert element at the beginning ");
            System.out.println("2. Insert element at the end ");
            System.out.println("3. Insert an element ");
            System.out.println("4. Remove the element from the beginning ");
            System.out.println("5. Remove the element from the end ");
            System.out.println("8. Traverse the list ");
            switch(in.nextInt()){
                case 1:System.out.println("Enter an element to insert : ");
                    data = in.nextInt();
                    list.insertBegin(data);
                    break;
                case 2:System.out.println("Enter an element to insert : ");
                    data = in.nextInt();
                    list.insertEnd(data);
                    break;
                case 3:System.out.println("Enter an element to insert : ");
                    data = in.nextInt();
                    System.out.println("Enter the position of the element to be inserted : ");
                    int position = in.nextInt();
                    list.insert(data, position);
                    break;
                case 4:System.out.println("The elemenet removed is "+list.removeBegin().getData());
                    break;
                case 5:System.out.println("The element removed is "+list.removeEnd().getData());
                    break;
                case 8:System.out.println(list.toString());
                    break;
                default:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
            }
        }
    }
}
