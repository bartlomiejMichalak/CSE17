/* 
CSE 17 
Bart Michalak
bpm215 
Program #5     DEADLINE: December 15, 2012 
Program Description: MP3 Library with Linked Lists
*/
import java.util.*;
  public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;
    
    /** Create a default list */
    public MyLinkedList() {
    }
    
    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
      super(objects);
    }
    
    /** Return the head element in the list */
    public E getFirst() {
      if (size == 0) {
        return null;
      }
      else {
        return head.element;
      }
    }
    
    /** Return the last element in the list */
    public E getLast() {
      if (size == 0) {
        return null;
      }
      else {
        return tail.element;
      }
    }
    
    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
      Node<E> newNode = new Node<E>(e); // Create a new node
      newNode.next = head; // link the new node with the head
      head = newNode; // head points to the new node
      size++; // Increase list size
      
      if (tail == null) // the new node is the only node in list
        tail = head;
    }
    
    /** Add an element to the end of the list */
    public void addLast(E e) {
      Node<E> newNode = new Node<E>(e); // Create a new for element e
      
      if (tail == null) {
        head = tail = newNode; // The new node is the only node in list
      }
      else {
        tail.next = newNode; // Link the new with the last node
        tail = tail.next; // tail now points to the last node
      }
      
      size++; // Increase size
    }
    
    
    /** Add a new element at the specified index in this list
      * The index of the head element is 0 */
    public void add(int index, E e) {
      if (index == 0) {
        addFirst(e);
      }
      else if (index >= size) {
        addLast(e);
      }
      else {
        Node<E> current = head;
        for (int i = 1; i < index; i++) {
          current = current.next;
        }
        Node<E> temp = current.next;
        current.next = new Node<E>(e);
        (current.next).next = temp;
        size++;
      }
    }
    
    /** Remove the head node and
      *  return the object that is contained in the removed node. */
    public E removeFirst() {
      if (size == 0) {
        return null;
      }
      else {
        Node<E> temp = head;
        head = head.next;
        size--;
        if (head == null) {
          tail = null;
        }
        return temp.element;
      }
    }
    
    /** Remove the last node and
      * return the object that is contained in the removed node. */
    public E removeLast() {
      if (size == 0) {
        return null;
      }
      else if (size == 1) {
        Node<E> temp = head;
        head = tail = null;
        size = 0;
        return temp.element;
      }
      else {
        Node<E> current = head;
        
        for (int i = 0; i < size - 2; i++) {
          current = current.next;
        }
        
        Node<E> temp = tail;
        tail = current;
        tail.next = null;
        size--;
        return temp.element;
      }
    }
    
    /** Remove the element at the specified position in this list.
      *  Return the element that was removed from the list. */
    public E remove(int index) {
      if (index < 0 || index >= size) {
        return null;
      }
      else if (index == 0) {
        return removeFirst();
      }
      else if (index == size - 1) {
        return removeLast();
      }
      else {
        Node<E> previous = head;
        
        for (int i = 1; i < index; i++) {
          previous = previous.next;
        }
        
        Node<E> current = previous.next;
        previous.next = current.next;
        size--;
        return current.element;
      }
    }
    
    /** Override toString() to return elements in the list */
    public String toString() {
      StringBuilder result = new StringBuilder("[");
      
      Node<E> current = head;
      for (int i = 0; i < size; i++) {
        result.append(current.element);
        current = current.next;
        if (current != null) {
          result.append(", "); // Separate two elements with a comma
        }
        else {
          result.append("]"); // Insert the closing ] in the string
        }
      }
      
      return result.toString();
    }
    
    /** Clear the list */
    public void clear() {
      head = tail = null;
      size = 0;       // this is missing from the 8th edition of the book!
    }
    
    /** Return true if this list contains the element e */
    public boolean contains(E e) {
      System.out.println("Implementation left as an exercise");
      return true;
    }
    
    /** Return the element from this list at the specified index */
   public E get(int index) {
      
      if (index >= size())
        return null;
      
      Node<E> current=head;
      E newElement;
        
      for(int i=0;i<index;i++){
        current=current.next;
      }
      
      newElement=current.element;
      return newElement;

    }

    
    
    /** Return the index of the head matching element in this list.
      *  Return -1 if no match. */
    public int indexOf(E e) {
      System.out.println("Implementation left as an exercise");
      return 0;
    }
    
    /** Return the index of the last matching element in this list
      *  Return -1 if no match. */
    public int lastIndexOf(E e) {
      System.out.println("Implementation left as an exercise");
      return 0;
    }
    
    /** Replace the element at the specified position in this list
      *  with the specified element. */
    public E set(int index, E e) {
      System.out.println("Implementation left as an exercise");
      return null;
    }
    
    private static class Node<E> {
      E element;
      Node<E> next;
      
      public Node(E element) {
        this.element = element;
      }
    }
    public MyLinkedList<E> split(int index){
      MyLinkedList<E> myList = new MyLinkedList<E>();
      myList.addFirst(this.remove(index++));
      while(myList.getLast()!=null){
        myList.addLast(this.remove(index++));
      }
      myList.removeLast();
      return myList;
    }
  public static <T> MyLinkedList<T> mergeSortedLists(MyLinkedList<T> list1, MyLinkedList<T> list2, Comparator<T> comp){
    
    MyLinkedList<T> list3 = new MyLinkedList<T>();
    
    while(list1.head!=null){
      if(comp.compare(list1.getFirst(), list2.getFirst()) <= 0){
        if(list3.head!=null){
          Node<T> temp = list3.head;
          Node<T> temp2 = list2.head;
          list2.head = list2.head.next;
          while(temp.next!=null)
            temp=temp.next;
          temp.next = temp2;
          temp.next.next = null;
          list3.tail = temp.next;
        }
        else{
          Node<T> temp = list2.head;
          list2.head = list2.head.next;
          list3.head = temp;
          list3.tail = list3.head;
          list3.head.next = null;
        }
      }
      if(comp.compare(list1.getFirst(),list2.getFirst()) > 0){
        if(list3.head!=null){
          Node<T> temp2 = list1.head;
          Node<T> temp = list3.head;
          list1.head = list1.head.next;
          while(temp.next!=null)
            temp = temp.next;
          temp.next = temp2;
          temp.next.next = null;
          list3.tail = temp.next;
        }
        else{
          Node<T> temp = list1.head;
          list1.head = list1.head.next;
          list3.head = temp;
          list3.tail = list3.head;
          list3.head.next = null;
        }
      }
    }
    //after the first list is empty this runs. and appends the second list list3.
    list3.tail.next=list2.head;
    list3.tail=list2.tail;
    list2.tail=null;
    list2.head = list2.tail;
  return list3;
  }

}
