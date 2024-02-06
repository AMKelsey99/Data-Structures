/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlinkedlist;

import java.util.Random;

/**
 *
 * @author alana
 */
public class DLinkedList {
public node head;
public node tail;
public int size;

class node {
    int score;
    node next;
    node previous;
    
    public node(int s) {
        score = s;
        next = null;
        previous = null;
    }
    
    public node (int s, node nextLink, node previousLink ) {
        score = s;
        this.next = nextLink;
        this.previous = previousLink;
    }
    
    public void setNext(node n) {
        next = n;
    }
    
    public void setPrevious(node n) {
        previous = n;
    }
}

    public boolean isEmpty() {
        return head == null; 
    }
    
    public int getSize() {
        return size;
    }
    
    public void initialize(int s) {
        node newNode = new node(s);
        head = newNode;
        tail = newNode;
        head.next = tail;
        tail.previous = head;
        size++;
    }
    
    public void addToFront(int s) {
        node newNode = new node(s);
        node temp = head;
        temp.setPrevious(newNode);
        newNode.setNext(temp); //shift over 1
        head = newNode;
        size++;
    }
    
    
    public void addToEnd(int s) {
        node newNode = new node(s);
        tail.next = newNode;
        newNode.previous = tail; //link the nodes
        tail = newNode;
        tail.next = null;
        size++;
    }
    
    
    public void removeLast() {
        node temp = tail.previous;
        tail = temp;
        tail.next = null;
        size--;
    }
    

    public void addBetweenNodes(int s, node before, node after) {
        node newNode = new node(s, after, before);
        node temp = after;
        before.setNext(newNode);
        after.setPrevious(newNode);
        size++;
    }
    
    // After struggling on the singly linked list version of this project, 
    //I wanted to divide up the code into
    // their own methods, as above, and call them in this one :)
    public void addScore(int s) {
        node newNode = new node(s); //holder node
        node current = head;
       
        if (isEmpty()) {
            initialize(newNode.score);
        } else if (newNode.score >= head.score) {
            addToFront(newNode.score);
        } else if (newNode.score <= tail.score) {
            addToEnd(newNode.score);
        } else if (newNode.score < head.score && newNode.score > tail.score) {
            while (current.next != null && newNode.score < current.next.score) {
                current = current.next;
            }
            addBetweenNodes(newNode.score, current, current.next);
        }
        if (getSize()>10) {
            removeLast(); 
        } 
    }
    
    public void getList() {
        node view = this.head;
        
        while (view != null) {
            System.out.println(view.score);
            view = view.next;
        }
    }
    
    
    /**
     * @param args the command line arguments
     * Uses the random java.util to create 15 scores, then selects the top 10
     * using a doubly linked list and add/remove methods.
     */
    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();
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
