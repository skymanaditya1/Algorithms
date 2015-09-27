package com.linkedlists;

import java.util.Enumeration;
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

    // Method for finding the value of the nth node from the end of the linked list in one pass O(n)
    public int NthNodeFromEndOnePass(int position){
        // Keep two pointers , both pointing to the head of the list
        node ptemp = head, pnthnode = null;
        for(int i=1; i<position; i++){
            if(ptemp!=null)
                ptemp = ptemp.getNext();
        }

        while(ptemp!=null){
            if(pnthnode == null)
                pnthnode = head;
            else{
                pnthnode = pnthnode.getNext();
            }
            ptemp = ptemp.getNext();
        }

        if (pnthnode != null)
            return pnthnode.getData();
        else{
            System.out.println("Fewer than n nodes ");
            return Integer.MIN_VALUE ; // return some arbitrary value
        }
    }

    // Method for creating a cyclic or null terminated list
    public void createCyclicOrNullTerminatedList(){
        // Creating a linked list with a cycle
       //  1-> 2-> 3-> 4-> 5-> 6-> 3-> 4-> 5-> 6-> 3-> ...
/**
        head = new node(1);
        node temp1 = new node(2);
        head.setNext(temp1);
        node temp2 = new node(3);
        temp1.setNext(temp2);
        node temp3 = new node(4);
        temp2.setNext(temp3);
        node temp4 = new node(5);
        temp3.setNext(temp4);
        node temp5 = new node(6);
        temp4.setNext(temp5);
        temp5.setNext(temp2); // denotes a cycle
*/
        // Creating a linked list without a cycle
        // 1-> 2-> 3-> 4-> 5-> null


        head = new node(1);
        node temp1 = new node(2);
        head.setNext(temp1);
        node temp2 = new node(3);
        temp1.setNext(temp2);
        node temp3 = new node(4);
        temp2.setNext(temp3);
        node temp4 = new node(5);
        temp3.setNext(temp4); // denotes a null terminate list

    }

    // Method for checking whether a linked list is cyclic using Hash Table
    public void checkCyclicUsingHash() {
        Hashtable hashtable = new Hashtable();
        // add the head of the ll to the hash table
        if (head == null)
            return;
        hashtable.put(head, head.getData());

        boolean flag = true;

        // Create an enumeration for the entries of the hash table
        Enumeration val = hashtable.keys();

        node temp = head.getNext();
        // traverse the linked list nodes one by one

        int count = 0;

        while(flag && temp!=null){
            while(val.hasMoreElements()){
                node check = (node) val.nextElement();
                if (check.equals(temp)){
                    flag = false;
                    System.out.println("List is cyclic");
                }
            }
            hashtable.put(temp, temp.getData());
            val = hashtable.keys();
            temp = temp.getNext();
            count ++;
        }

        // the list is not cyclic
        if(flag)
            System.out.println("List is null terminated");
        else{
            System.out.println("Cycle found after node "+count); // denotes the number of nodes without cycle
        }
    }

    // Method for checking whether a linked list has a cycle using Floyd's Method
    public void checkCyclicUsingFloyd(){
        if (head == null)
            return;

        // Keep two pointers, fast pointer, slow pointer, if they meet before the list gets terminated, then there is a cycle
        node fastPtr = head;
        node slowPtr = head;
        boolean flag = true;
        while (fastPtr!=null && fastPtr.getNext()!=null && flag){
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if(fastPtr == slowPtr){
                flag = false;
            }
        }
        if (flag){
            System.out.println("The list is null terminated ");
        }
        else
            System.out.println("The list has a cycle ");
    }

    // Method to return the start of the loop if the linked list contains a cycle
    public void returnPositionOfCycle(){
        // find if the list has a cycle using Floyd Algorithm
        if (head == null)
            return;

        boolean isCyclic = false;

        node slowPtr = head;
        node fastPtr = head;
        while(fastPtr != null && fastPtr.getNext()!=null && !isCyclic){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
            if(slowPtr == fastPtr){
                isCyclic = true;
            }
        }

        int countFromStart = 0;

        if (isCyclic){
            // find the position of the start of the cycle
            slowPtr = head;
            while(slowPtr!=fastPtr){
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
                countFromStart += 1;
            }
        }

        // return appropriate messages
        if (isCyclic){
            System.out.println("The list is cyclic at node "+fastPtr.getData()+" with position "+countFromStart+" from start");
        }
        else{
            System.out.println("The list is null terminated ");
        }
    }

    // Method for finding the length of the cycle if it exists in a linked list
    public void findCycleLength(){
        // find if the list has a cycle using Floyd Algorithm
        if (head == null)
            return;

        boolean isCyclic = false;
        int loopLength = 0; // counts the length of the loop

        node slowPtr = head;
        node fastPtr = head;
        while(fastPtr!=null && fastPtr.getNext()!=null && !isCyclic){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
            if (slowPtr == fastPtr){
                isCyclic = true;
            }
        }

        // if there is cycle, find the length of the cycle
        // keep the slowPtr at meeting place and increment fastPtr in the loop until is equals slowPtr
        if (isCyclic){
            do{
                fastPtr = fastPtr.getNext();
                loopLength += 1;
            }while(fastPtr != slowPtr);
        }

        // Display appropriate messages
        if (isCyclic){
            System.out.println("The list is cyclic with cycle length "+loopLength);
        }
        else{
            System.out.println("The list is null terminated ");
        }
    }

    // Method to sort the elements of a linked list using selection sort
    public void sortUsingSelectionSort(){
        // Typical Selection Sort Algorithm
        /**int[] a = {5, 2, 1, 8, 5};
        for(int i=0; i<a.length-1; i++){
            int pos = i;
            for(int j=i+1; j<a.length; j++){
                if (a[j] < a[pos])
                    pos = j;
            }
            int temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
        }*/
        if (head == null)
            return;

        for(node i = head; i.getNext()!=null; i = i.getNext()){
            node pos = i;
            for (node j = i.getNext(); j!=null; j = j.getNext()){
                if (j.getData() < pos.getData())
                    pos = j;
            }
            int temp = i.getData();
            i.setData(pos.getData());
            pos.setData(temp);
        }
    }

    // Method for inserting the node in a sorted list
    public void insertNodeSorted(int data){
        // Works in a similar way to insertion sort
        // if the list is empty

        node newNode = new node(data);

        if (head == null){
            head = newNode;
            return;
        }

        // Check if the node to be inserted is less than the head node in the sorted list
        if (newNode.getData() < head.getData()){
            // insert before the head of the list
            newNode.setNext(head);
            head = newNode;
        }

        else{
            // Insert at the appropriate position
            node current = head;
            node previous = null;
            while ( current != null && current.getData() < newNode.getData()){
                previous = current;
                current = current.getNext();
            }
            newNode.setNext(current);
            previous.setNext(newNode);
        }
    }

    // Method to traverse the list
    public void reverseListBruteForce(){
        // check if the list is empty
        if (head == null)
            return;

        // if the list has one node, return
        if (head.getNext()==null)
            return;

        // reverse the list

        // keep the tail in a temporary variable to be made the new head
        node tempTail = head;
        while(tempTail.getNext()!=null)
            tempTail = tempTail.getNext();

        while(head.getNext()!=null){
            node current = head;
            node previous = null;
            while(current.getNext()!=null){
                previous = current;
                current = current.getNext();
            }
            current.setNext(previous);
            previous.setNext(null);
        }

        // set the head as the tail of the original list
        head = tempTail;
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
            System.out.println("9. Problem 3 : Find the nth node from the end of the linked list in one scan ");
            System.out.println("10.Problem 4 : Find whether a linked list has a cycle or is null terminated ");
            System.out.println("11.Problem 5 : Finding a cyclic linked list using Floyd's Algorithm ");
            System.out.println("12.Problem 6 : Cyclic or null terminated, if cyclic return start of cycle ");
            System.out.println("13.Problem 7 : Cyclic or null terminated, if cyclic return the length of the cycle ");
            System.out.println("14.Problem 8 : Sort the linked list ");
            System.out.println("15.Problem 9 : Insert a node in a sorted linked list ");
            System.out.println("16.Problem 10: Reverse the list ");
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
                case 9:System.out.println("Enter the value of n : ");
                    n = in.nextInt();
                    System.out.println("The value of the nth node from the end in single pass is : "+
                    list.NthNodeFromEndOnePass(n));
                    break;
                case 10:// Method for first creating a linked list which may be null terminated or has a cycle
                    ListClass listCyclic = new ListClass();
                    listCyclic.createCyclicOrNullTerminatedList();
                    // listCyclic.traverse(); // generates an infinitely long linked list, since a loop is present
                    // Using hash table to check if the linked list is cyclic or not
                    listCyclic.checkCyclicUsingHash();
                    // list.checkCyclicUsingHash();
                    break;
                case 11:// Method for finding whether a linked list is cyclic or is null terminated
                    // Method for first creating a linked list which may be null terminated or has a cycle
                    ListClass lcFloyd = new ListClass();
                    lcFloyd.createCyclicOrNullTerminatedList();
                    // lcFloyd.traverse(); // generates an infinitely long linked list for a cyclic linked list
                    lcFloyd.checkCyclicUsingFloyd();
                    break;
                case 12: // Method to check if the linked list is null terminated or not, if there is a cycle find the
                    // start node of the cycle
                    // Method for creating a linked list which may be null terminated or has a cycle
                    ListClass cycleStart = new ListClass();
                    cycleStart.createCyclicOrNullTerminatedList();
                    // cycleStart.traverse(); // Method to generate an infinitely long list for a cyclic list
                    cycleStart.returnPositionOfCycle();
                    break;
                case 13: //Method to check if the linked list is null terminated or cyclic, if there is a cycle find the
                    // length of the cycle / loop
                    // Method for creating a linked list which may be null terminated or has a cycle
                    ListClass cycleLength = new ListClass();
                    cycleLength.createCyclicOrNullTerminatedList();
                    // cycleLength.traverse(); // Method to generate an infinitely long list for a cyclic list
                    cycleLength.findCycleLength();
                    break;
                case 14: // Method to sort the elements of a linked list using selection sort
                    list.sortUsingSelectionSort();
                    break;
                case 15: // Method to insert a node in a sorted linked list in a way similar to insertion sort
                    // before inserting the node in a sorted list, the list has to be sorted
                    list.sortUsingSelectionSort();
                    System.out.println("Enter the node to be inserted into the sorted list : ");
                    data = in.nextInt();
                    list.insertNodeSorted(data);
                    break;
                case 16: // Method to reverse the nodes of the singly linked list
                    list.reverseListBruteForce(); // This is an O(n^2) approach
                    break;
                default:
                    System.out.println("Exit...");
                    System.exit(0);
                    break;
            }
        }
    }
}
