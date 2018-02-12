/**
 * Name: John Leonardo
 * Date: 12 February 2018
 * Class: CSC 130
 * File: ListStack.java
 */

public class ListStack implements DStack {
    
    private int n; //size of stack
    private Node head; //top of stack
    
    //node class
    private class Node {
        double item;
        Node next;
    }
    
    //initializes an empty stack
    public ListStack() {
        head = null;
        n = 0;
    }
    
    public boolean isEmpty() {
        return (head == null); //if head is null, it's empty
    }
    
    public void push(double d) {
        Node oldHead = head;
        head = new Node();
        
        //assign the pushed data, to the new head's item
        head.item = d;
        
        //point head.next to the old head
        head.next = oldHead;
        
        //increment stack size
        n++;
    }
    
    public double pop() {
        double item = head.item;
        
        //move the 2nd item, to head
        head = head.next;
        
        //decrement stack size
        n--;
        
        //return the item that was popped
        return item;
    }
    
    public double peek() {
        return head.item; //return the head of stack
    }

}
