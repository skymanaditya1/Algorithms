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
            System.out.println("4. Check for balancing of symbols in a String ");
            System.out.println("5. Convert an infix to postfix expression ");
            System.out.println("6. Evaluate a postfix expression ");
            System.out.println("7. Check if a given string is palindrome ");
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
                default:
                    System.out.println("Exit ...");
                    System.exit(0);
                    break;
            }
        }
    }
}
