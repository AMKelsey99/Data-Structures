/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.Random;

/**
 *
 * @author alana
 */
public class LinkedList {
public node head;
public node tail;
node finalHead;
public int size;

class node {
    int score;
    node next;
    
    /**
    * @param s The integer to be added to the linked list; initializes the 
    * node's score
    **/
    public node(int s) {
        score = s;
        next = null;
    }
    
    /**
    * @param n The node to be linked as the successive node.
    **/
    public void setNext(node n) {
        next = n;
    }  
}
    /**
     * 
     * @return returns whether head is empty or not
     */
    public boolean isEmpty() {
        return head == null; //or size == 0
    }
    
    /**
     * 
     * @return returns the size parameter of the list
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Removes the last node of the linked list
     */
    public void removeLast() {
        node current = head;
       while (current.next != tail) {
           current = current.next;
       }
       tail = current;
       tail.next = null;
       size--;
    }
    
    /**
    * @param s The integer to be added to the linked list
    **/
    public void addScore(int s) {
        node newNode = new node(s);
        node current= head;
        
        
        
        if (isEmpty()) {
            head = newNode;
            tail = head; //link the list
            size++;
        } else if (newNode.score >= head.score) { //highest will be at head, shifts it rightward
            newNode.setNext(head); //shift head over 1
            head = newNode;
            size++;
        } else if (newNode.score < head.score && newNode.score > tail.score) {
            while (current.next != null && newNode.score < current.next.score) {
                current = current.next;
            }
            newNode.setNext(current.next);
            current.next = newNode;
            size++;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
            size++;
        }
        if (getSize() > 10) {
            removeLast();
        }
        }
    
    
    /**
     * Prints each score parameter of each node in the list
     */
    public void getList() { 
        node view = this.head; //start at the beginning
        
            while (view != null) {
                System.out.println(view.score);
                view = view.next;
            }
        }
    
    /**
     * @param args the command line arguments
     * Uses the random java.util to create 15 scores, then selects the top 10
     * using a singly linked list and add/remove methods.
     */
    public static void main(String[] args) {
      LinkedList list = new LinkedList();
        Random random = new Random();
        System.out.print("15 SCORES: ");
        for (int i = 0; i < 15; i++) {
            int toAdd = random.nextInt(30);
            list.addScore(toAdd);
            if (i != 14) {
            System.out.print(toAdd + ", ");
            } else {
                System.out.print(toAdd + "\n");
            }
        }
        System.out.println("\nTOP TEN:");
        list.getList();
        int size = list.getSize();
        System.out.println("LIST SIZE: " + size); //should return 10
    }
    
}
