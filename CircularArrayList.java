/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circulararraylist;

import java.util.Arrays;

/**
 *
 * @author alana
 */
public class CircularArrayList<E>{
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    
    public CircularArrayList() { this(CAPACITY); }
    public CircularArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int k=0; k<size; k++) {
            temp[k] = data[k];
        }
        data = temp;
    }
    
    public int size() { 
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return data[index];
    }
    
    public E set(int index,E e) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E temp = data[index];
        data[index] = e;
        return temp;
    }
    
    public void add(int index, E e) throws IndexOutOfBoundsException {
        checkIndex(index,size+1);
        if (size == data.length) {
            resize(2*data.length);
        }
        for (int k=size-1;k>=index;k--) {
            data[k+1] = data[k];
        }
        data[index] = e;
        size++;
    }
    

    public E remove() throws IndexOutOfBoundsException {
        //checkIndex(index, size);
        E temp = data[0];
        for (int k=0;k<size-1;k++) {
        data[k]=data[k+1];
        }
        data[size-1] = null;
        size--;
        return temp;
    }
    
    public void removeAndInsertToEnd() {
      E temp = data[0];
      for (int i=0;i<size;i++) {
          data[i] = data[i+1];
      }
      data[size-1] = temp;
    }
    
    public void insertToFront(E e) {
        size++;
        if (size == data.length) {
            resize(2*data.length);
        }
        if (!isEmpty()) {
        for (int i=size;i>0;i--) {
            data[i] = data[i-1];
        }
        }
        data[0] = e;
    }
    
        public void insertToEnd(E e) {
        size++;
        if (size == data.length) {
            resize(2*data.length);
        }
        if (!isEmpty()) {
        data[size-1] = e;
        } else {
        data[0] = e;
        }
    }
        
        public void insertToEndAndDeleteFromFront(E e) {
        if (size == data.length) {
            resize(2*data.length);
        }
        if (!isEmpty()) {
        data[size] = e;
        } else {
        data[0] = e;
        }
        
        for (int i=0;i<size;i++) {
           data[i] = data[i+1];
        }
    }
    
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i<0 || i>=n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }
    
    public void printList() {
        for (int i = 0; i<size;i++) {
            System.out.println(data[i]);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularArrayList list = new CircularArrayList(10);
        System.out.println("This is an extendable circular array.\nThe following methods will fill and extend an array, insert at front or back,\nand remove, or move from front to end, or end to front.\nOut of numbers 1-19, the following are removed at the end of the program: 8, 11, 12, 13\n");
                
        list.insertToFront(0);
        list.insertToFront(1);
        list.insertToFront(2);
        list.insertToFront(3);
        list.insertToFront(4);
        list.insertToFront(5);
        list.insertToFront(6);
        list.insertToFront(7);
        list.insertToFront(8);
        list.remove(); //remove 8
        list.insertToFront(9);
       

        list.printList();
        System.out.println("List size: " + list.size + "\nMax Capacity: " + list.data.length + "\nRemoved from front: 8\n");
        
        // Extend Array:
        list.insertToFront(10);
        list.insertToFront(11);
        list.insertToFront(12);
        list.insertToFront(13);
        list.insertToFront(14);
        list.insertToFront(15);
        list.removeAndInsertToEnd(); //remove 15 from front, insert to end
        list.removeAndInsertToEnd(); //remove 14 from front, insert to end
        list.insertToEnd(16);
        list.insertToEndAndDeleteFromFront(17); //insert 17 to end, shift array so current front is removed
        list.insertToEndAndDeleteFromFront(18); //insert 17 to end, shift array so current front is removed
        list.insertToEndAndDeleteFromFront(19); //insert 17 to end, shift array, so current front is removed
        list.printList();
        System.out.println("List size after resize to current capacity * 2: " + list.size + "\nMax Capacity: " + list.data.length + "\nRemoved from front, inserted to end: 15, 14\nRemoved from front when inserting to end with extending: 13, 12, 11");
    }
}
