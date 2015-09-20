package com.linkedlists;

import java.util.Scanner;

/**
 * Created by Aditya on 9/20/2015.
 */
public class ListImplementation {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int data;
        ListNode node;
        while(true){
            System.out.println("Menu");
            System.out.println("1. Insert an element at the beginning");
            System.out.println("2. Insert an element at the end");
            System.out.println("3. Insert an element in the list");
            System.out.println("4. Remove a node from the beginning");
            System.out.println("5. Remove a node from the end");
            System.out.println("6. Remove a node");
            System.out.println("7. Remove a value at a given position");
            System.out.println("8. Traverse the elements of the list");
            System.out.println("9. Get the first matched position of a given value from the list");
            System.out.println("10. Clear the list");
            System.out.println("Enter your choice : ");
            switch(in.nextInt()){
                case 1:System.out.println("Enter the element to be inserted : ");
                    data = in.nextInt();
                    node = new ListNode(data);
                    list.insertAtBegin(node);
                    break;
                case 2:System.out.println("Enter the element to be inserted : ");
                    data = in.nextInt();
                    node = new ListNode(data);
                    list.insertAtEnd(node);
                    break;
                case 3:System.out.println("Enter the element to be inserted : ");
                    data = in.nextInt();
                    System.out.println("Enter the position to insert the element : ");
                    int position = in.nextInt();
                    node = new ListNode(data);
                    list.insert(data, position);
                    break;
                case 4:System.out.println("The node removed from the beginning is : "+list.removeFromBegin());
                    break;
                case 5:System.out.println("The node removed from the end is : "+list.removeFromEnd());
                    break;
                case 6:System.out.println("Enter the node to remove from list : ");
                    data = in.nextInt();
                    node = new ListNode(data);
                    list.removeMatched(node);
                    break;
                case 7:System.out.println("Enter the position to remove the node : ");
                    int pos = in.nextInt();
                    list.removeAtPosition(pos);
                    break;
                case 8:System.out.println("Traversing the elements of the given list : ");
                    System.out.println(list.toString());
                    break;
                case 9:System.out.println("Return the position of the first element matched from the list : ");
                    data = in.nextInt();
                    System.out.println("The position of the item removed from the list is : "+list.getPosition(data));
                    break;
                case 10:System.out.println("Clearing the list ");
                    list.clearList();
                    break;
            }
        }
    }
}
