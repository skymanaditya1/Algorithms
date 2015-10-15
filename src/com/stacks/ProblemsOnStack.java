package com.stacks;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aditya on 9/28/2015.
 */
class StackImplementation {
    private node top;
    private int length;

    public StackImplementation() {
        top = null;
        length = 0;
    }

    // method to insert a node at the top of the stack
    public void push(int data) {
        node newNode = new node(data);
        newNode.setNext(top);
        top = newNode;
        length++;
    }

    // method to return the size of the stack
    public int size() {
        // return length will also do
        int stackSize = 0;
        node temp = top;
        while (temp != null) {
            stackSize++;
            temp = temp.getNext();
        }
        return stackSize;
    }

    // method to check if a stack is empty or not
    public boolean isEmpty() {
        return (top == null);
    }

    // method to pop the top of the stack
    public int pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        int data = top.getData();
        top = top.getNext();
        length--;
        return data;
    }

    // Method to return the top of the stack, without removing it
    public int peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return top.getData();
    }

    // method to check if the symbols in a string are balanced using stack
    public boolean checkSymbolsBalanced(String str) {
        Stack<Character> stk = new Stack<>();
        if (str == null || str.length() == 0)
            return true;
        // check till the end of the input
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                // after seeing a close parenthesis, if the stack is empty report an error, otherwise pop
                // if the popped symbol does not match the corresponding opening symbol, report an error
                if (!stk.isEmpty() && stk.peek() == '(')
                    stk.pop();
                else
                    return false;
            } else if (str.charAt(i) == ']') {
                if (!stk.isEmpty() && stk.peek() == '[')
                    stk.pop();
                else
                    return false;
            } else if (str.charAt(i) == '}') {
                if (!stk.isEmpty() && stk.peek() == '{')
                    stk.pop();
                else
                    return false;
            }
            // push the element into the stack, if it is an opening symbol, otherwise ignore
            else if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{')
                stk.push(str.charAt(i));

            // else ignore;
        }

        if (stk.isEmpty())
            return true;
        else
            return false;
    }

    // method for converting a given infix expression string to postfix expression string
    // code to be completed later, for converting an infix to postfix expression.
    public String convertInfixToPostfix(String infixString) {
        // Incomplete method
        return null;
    }

    // Method to evaluate a postfix expression
    public int evaluatePostfixExpression(String str) throws Exception {
        String[] tokens = str.split("");
        Stack<Integer> stk = new Stack<Integer>();
        // The second operand is the first element that is popped
        for (String token : tokens) {
            if (token.equals("+")) {
                int op1 = stk.pop();
                int op2 = stk.pop();
                int retVal = op1 + op2;
                stk.push(retVal);
            } else if (token.equals("-")) {
                int op1 = stk.pop();
                int op2 = stk.pop();
                int retVal = op2 - op1;
                stk.push(retVal);
            } else if (token.equals("*")) {
                int op1 = stk.pop();
                int op2 = stk.pop();
                int retVal = op1 * op2;
                stk.push(retVal);
            } else if (token.equals("/")) {
                int op1 = stk.pop();
                int op2 = stk.pop();
                if (op1 == 0)
                    throw new Exception("Cannot evaluate postfix expression ");
                int retVal = op2 / op1;
                stk.push(retVal);
            } else { // an operand
                stk.push(Integer.parseInt(token));
            }
        }
        // return the top of the stack as result when the entire input string (postfix expression) is scanned
        return stk.pop();
    }

    // Method to check if a string is a palindrome using a stack
    public void checkPalindromeUsingStack(String str){
        Stack<Character> stk = new Stack<>();
        int i = 0, j = str.length() - 1;
        while (str.charAt(i) != 'X'){
            stk.push(str.charAt(i));
            i++;
        }
        i++; // points to the character immediately after X
        boolean flag = true;
        while (flag && i < str.length()){
            if (str.charAt(i) != stk.peek())
                flag = false;
            i++;
            stk.pop();
        }
        if (flag)
            System.out.println("The string is a palindrome");
        else
            System.out.println("The string is not a palindrome");
    }

    // Method to return node at the top of the stack
    public node topStack(){
        return top;
    }

    // Method to reverse the contents of the stack using two stacks
    public node reverseStack(){
        // make a system stack
        StackImplementation sR = new StackImplementation();
        while (top!=null){
            sR.push(top.getData());
            top = top.getNext();
        }
        top = sR.topStack();
        return top;
    }

    // Method to traverse the contents of the stack, using the top as an argument
    public void traverse(node top){
        while (top!=null) {
            System.out.print(top.getData() + " ");
            top = top.getNext();
        }
        System.out.println();
    }

    // Method to create the intersecting node linked lists
    public node[] createIntersectingNodeLinkedList(){
        // create the first linked list
        node node1 = new node(1);
        node node2 = new node(2);
        node intersectingNode = new node(3); // The intersecting node
        node node4 = new node(4);
        node node5 = new node(5);
        node node6 = new node(6);
        node node7 = new node(7);
        node node8 = new node(8);

        node1.setNext(node2); // head of the first list
        node2.setNext(intersectingNode);
        intersectingNode.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);

        node6.setNext(node7); // head of the second list
        node7.setNext(node8);
        node8.setNext(intersectingNode);

        // return the head of the two lists
        node[] nArray = {node1, node6}; // returns the head of the two lists respectively
        // The value of the intersecting node is -> 3
        return nArray;
    }

    // Method to return the intersecting node in two linked lists
    public node findIntersectingNode(node[] arr){
        node head1 = arr[0]; // head of the first linked list
        node head2 = arr[1]; // head of the second linked list
        // Push the nodes of the linked lists inside the stack
        Stack<node> stk1 = new Stack<>(); // Stack of nodes of 1st linked list
        System.out.println("Head 1 : " + head1.getData());
        while (head1 != null){
            stk1.push(head1);
            System.out.println(head1 + " : " + head1.getData());
            head1 = head1.getNext();
        }

        Stack<node> stk2 = new Stack<>(); // Stack of nodes of 2nd linked list
        System.out.println("Head 2 : " + head2.getData());
        while (head2 != null){
            stk2.push(head2);
            System.out.println(head2 + " : " + head2.getData());
            head2 = head2.getNext();
        }

        // Pop the nodes of the stack and check if they have the same corresponding address
        node val = null; // The value of the intersecting node

        while (!stk1.empty() && !stk2.empty()){
            if (stk1.peek().equals(stk2.peek())){
                // a matching node has been found
                val = stk1.peek();
                stk1.pop();
                stk2.pop();
            }
            else{
                return val;
            }
        }
        return null;
    }

    // Method to accept an input and a permutation, it performs a series of push S() and pop X() operations, to check
    // if the given permutation can be obtained from the input
    public String checkPermutationPermitted(String input, String permutation){
        String[] str1 = input.split("");
        String[] str2 = permutation.split("");
        Stack<Integer> stk = new Stack<>();
        int i=0, j=0;
        String result = "";
        while (i < str1.length){
            if (Integer.parseInt(str1[i]) != Integer.parseInt(str2[j])){
                stk.push(Integer.parseInt(str1[i]));
                i += 1;
                result += "S";
            }
            else{
                stk.push(Integer.parseInt(str1[i]));
                i += 1;
                result += "S";
                while (j < str2.length && !stk.isEmpty() && stk.peek() == Integer.parseInt(str2[j])){
                    stk.pop();
                    j += 1;
                    result += "X";
                }
            }
        }

        System.out.println(result);

        if (j == str2.length){
            return result;
        }

        else
            return null;
    }

    // Method to sort the contents of the stack in ascending order
    public void sortAscendingOrder(){
        // The contents of the stack can be sorted using selection sort algorithm
        for (node i = top; i.getNext()!=null; i = i.getNext()){
            node pos = i;
            for (node j = i.getNext(); j!=null; j = j.getNext()){
                if (j.getData() < pos.getData())
                    pos = j;
            }
            int temp = i.getData();
            i.setData(pos.getData());
            pos.setData(temp);
        }
        traverse(top);
    }

    // Method to traverse the contents of the stack, implements the toString() method
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

    // Method to traverse the contents of the stack, using the top as the argument
}

public class ProblemsOnStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StackImplementation s = new StackImplementation();
        int data;
        while (true) {
            System.out.println("Menu. Enter your choice ");
            System.out.println("1. Push an element into the stack ");
            System.out.println("2. Pop an element from the stack ");
            System.out.println("3. Print the contents of the stack ");
            System.out.println("4. Problem 1: Check for balancing of symbols in a String ");
            System.out.println("5. Problem 2: Convert an infix to postfix expression ");
            System.out.println("6. Problem 3: Evaluate a postfix expression ");
            System.out.println("7. Problem 4: Check if a given string is palindrome ");
            System.out.println("8. Problem 5: Reverse the contents of the stack using two stacks ");
            System.out.println("9. Problem 6: Find out the intersecting node in two linked lists using stacks ");
            System.out.println("10.Problem 7: Check if a given string can be permuted ");
            System.out.println("11.Problem 8: Sort the contents of the stack in ascending order ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Insert an element to be pushed : ");
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
                    System.out.println("The contents of the stack are ");
                    System.out.println(s.toString());
                    break;
                case 4:
                    System.out.println("Enter the string to be checked for balancing ");
                    in.nextLine();
                    String checkBal = in.nextLine();
                    // System.out.println(checkBal);
                    // method to check if the symbols in the string are balanced
                    if (s.checkSymbolsBalanced(checkBal))
                        System.out.println("The string is valid / has balanced symbols ");
                    else
                        System.out.println("The string is invalid / symbols are unbalanced ");
                    break;
                case 5:
                    System.out.println("Enter the infix expression string : ");
                    String infixString = in.nextLine();
                    System.out.println("The postfix string is : " + s.convertInfixToPostfix(infixString));
                    break;
                case 6:
                    System.out.println("Enter a postfix expression : ");
                    in.nextLine();
                    String postfix = in.nextLine();
                    try {
                        System.out.println("The result of the postfix expression is : " + s.evaluatePostfixExpression(postfix));
                    } catch (Exception e) {
                        System.out.println("Exception of type : " + e.toString());
                    }
                    break;
                case 7:
                    System.out.println("Enter the string to check if it is palindrome : ");
                    in.nextLine();
                    String palindromeCheck = in.nextLine();
                    s.checkPalindromeUsingStack(palindromeCheck);
                    break;
                case 8:
                    System.out.println("Reverse the contents of the stack ");
                    node tempTop = s.reverseStack();
                    s.traverse(tempTop);
                    break;
                case 9:
                    // method to create the linked lists as given in the question
                    StackImplementation ll = new StackImplementation();
                    node[] arr = ll.createIntersectingNodeLinkedList();
                    // Method to display the lists
                    ll.traverse(arr[0]);
                    ll.traverse(arr[1]);
                    // Return the node address and value of the intersecting node
                    node intersectingNode = ll.findIntersectingNode(arr);
                    System.out.println("The address of the intersecting node is : "+intersectingNode+" and value is : "
                            + intersectingNode.getData());
                    break;
                case 10:System.out.println("Enter the input string (array of integers) : ");
                    in.nextLine();
                    String input = in.nextLine();
                    System.out.println("Enter the permutation to match the string of integers : ");
                    String permutation = in.nextLine();
                    StackImplementation cp = new StackImplementation();
                    String checkPermitted = cp.checkPermutationPermitted(input, permutation);
                    if (checkPermitted!=null){
                        System.out.println("The Permutation of the String is possible and the order of operations is : "+
                        checkPermitted);
                    }else{
                        System.out.println("The given string cannot be permuted in the said order ");
                    }
                    break;
                case 11:System.out.println("The contents of the stack in ascending order are : (Implemented Using " +
                        "Selection Sort");
                    s.sortAscendingOrder();
                    // s.toString();
                    break;
                default:
                    System.out.println("Exit ...");
                    System.exit(0);
                    break;
            }
        }
    }
}
