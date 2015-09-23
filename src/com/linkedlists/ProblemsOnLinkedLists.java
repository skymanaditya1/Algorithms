package com.linkedlists;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Aditya on 9/23/2015.
 * Some problems on Linked Lists
 */

class node{
    private int data;
    private node next;

    public node(){
        data = 0;
    }

    public node(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(node next){
        this.next = next;
    }

    public node getNext(){
        return next;
    }
}

class ListClass{
    protected node head;

    public ListClass(){
        head = null;
    }

    // method for calculating the length / number of elements in the list
    public int getLength(){
        node temp = head;
        int count = 0;
        while(temp!=null){
            count ++;
            temp = temp.getNext();
        }
        return count;
    }

    // method for inserting a node at the beginning of the list
    public void insertAtBegin(int data){
        node temp = new node(data);
        // Check if the list is empty
        if (head == null)
            head = temp;

        // at least 1 element in the list
        else{
            temp.setNext(head);
            head = temp;
        }
    }

    // method for inserting a node at the end of the list
    public void insertAtEnd(int data){
        node temp = new node(data);
        // check if the list is empty
        if(head == null)
            head = temp;

        // insert the node at the end of the list
        else{
            node trav = head;
            while(trav.getNext()!=null){
                trav = trav.getNext();
            }
            trav.setNext(temp);
        }
    }

    // method for removing the node from the beginning of the list
    public int removeFromBegin(){
        // check if the list is empty
        if (head == null)
        {
            System.out.println("List is empty");
            return Integer.MIN_VALUE; // returns an arbitrary value
        }

        // check if the list has more than one node
        else{
            node temp = head;
            head = head.getNext();
            return temp.getData();
        }
    }

    // method for removing the node from the end of the list
    public int removeFromEnd(){
        // check if the list is empty
        if (head == null){
            System.out.println("List is empty");
            return Integer.MIN_VALUE; // returns an arbitrary value
        }

        // check if the list has exactly one node
        else if (head.getNext() == null){
            int temp = head.getData();
            head = null;
            return temp;
        }

        // remove the node from the end of the list
        else{
            node p = head, q = null, next;
            // two pointers have to be maintained , one previous pointer, one pointing to the node to be removed
            while((next = p.getNext())!=null){
                q = p;
                p = next;
            }
            int temp = p.getData();
            q.setNext(null);
            return temp;
        }
    }

    // method to count the number of nodes in the list starting from a given node
    public int getLengthNode(node temp){
        int countAfter = 0;

        while(temp!=null){
            countAfter ++;
            temp = temp.getNext();
        }
        return countAfter;
    }

    // method to find the nth node from the end
    public int findNthNodeFromEnd(int n){
        // check if the list is empty
        /**if (head == null){
            System.out.println("Fewer than n nodes ");
            return Integer.MIN_VALUE;
        }*/
        if (getLength() < n){
            System.out.println("Fewer than n nodes ");
            return Integer.MIN_VALUE; // return some arbitrary value
        }

        // the case of n = 1 was not being handled by else clause for some reason
        else if (n == 1){
            // return the last node of the list
            node temp = head;
            while(temp.getNext()!=null)
                temp = temp.getNext();
            return temp.getData();
        }

        // return the nth node from the end
        else{
            node temp = head;
            while (temp.getNext() != null){
                node next = temp.getNext();
                if (getLengthNode(next) == n - 1){
                    return temp.getData();
                }
                else{
                    temp = temp.getNext();
                }
            }
        }

        return Integer.MAX_VALUE; // return some arbitrarily huge value
    }

    // Method for finding the nth node from the end using a hash table
    public int findNthNodeFromEndHash(int n){
        // check if the list is emtpy
        if (getLength() < n){
            System.out.println("Fewer than n nodes ");
            return Integer.MIN_VALUE; // return some arbitrary value
        }

        // create a hash table of the form <position of the node, address of the node>
        // hash table will be of the form <key, value of the node>
        else{
            Hashtable listHash = createHashTable(); // creates hash table of the entries of the linked list
            // Finding the nth element from the end is similar to finding the length() - n + 1 th element from beginning
            int position = getLength() - n + 1;
            node temp1 = (node) listHash.get(position);
            return temp1.getData();
        }
    }

    // method to create the hash table of the entries of the linked list of the form
    // <position of the node in the list, address of the node>
    public Hashtable createHashTable(){
        Hashtable hash = new Hashtable();
        // add the elements of the list to the hash table
        int position = 1;
        node temp = head;
        while(temp!=null){
            hash.put(position, temp);
            temp = temp.getNext();
            position ++ ;
        }
        return hash;
    }

    // method for traversing the contents of the list
    public void traverse(){
        node temp = head;
        while(temp!=null){
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}

public class ProblemsOnLinkedLists {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int data;
        int n;
        ListClass list = new ListClass();
        while(true){
            System.out.println("Menu. Enter your choice ");
            System.out.println("1. Insert node at the beginning of the list ");
            System.out.println("2. Insert node at the end of the list ");
            System.out.println("3. Remove node at the beginning of the list ");
            System.out.println("4. Remove node at the end of the list ");
            System.out.println("5. Traverse the list ");
            System.out.println("6. Find the length of the list ");
            System.out.println("7. Problem 1 : Find the nth node from the end of the linked list O(n2)");
            System.out.println("8. Problem 2 : Find the nth node from the end of the linked list O(n), HashTable ");
            int choice = in.nextInt();
            switch(choice){
                case 1:System.out.println("Enter the element to be inserted : ");
                    data = in.nextInt();
                    list.insertAtBegin(data);
                    break;
                case 2:System.out.println("Enter the element to be inserted : ");
                    data = in.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:System.out.println("The element removed from the head is : " + list.removeFromBegin());
                    break;
                case 4:
                    System.out.println("The element removed from the end is : " + list.removeFromEnd());
                    break;
                case 5:list.traverse();
                    break;
                case 6:System.out.println("The length of the list is : " + list.getLength());
                    break;
                case 7:System.out.println("Enter the value of n : ");
                    n = in.nextInt();
                    System.out.println("The value of the nth node from the end is : "+list.findNthNodeFromEnd(n));
                    break;
                case 8:System.out.println("Enter the value of n : ");
                    n = in.nextInt();
                    System.out.println("The value of the nth node from the end using hashtable is : "+
                    list.findNthNodeFromEndHash(n));
                    break;
                default:
                    System.out.println("Exit...");
                    System.exit(0);
                    break;
            }
        }
    }
}
