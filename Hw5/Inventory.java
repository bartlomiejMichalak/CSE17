/*
CSE 17
Bartlomiej Michalak
bpm215
Homework #5 DEADLINE: November 30, 2012
Program Description: Generics Inventory
*/
import java.util.*;
/* Inventroy is a generic class that is parameterized with the class Item
 * as well as any subclass it may have.*/
public class Inventory<T extends Item>{
  /*Declaration of the ArrayList used in the Inventory class.*/
  private ArrayList<T> list;
  
  /* No-arg constructor for the Inventory class. */
  public Inventory(){
    list = new ArrayList<T>();
  }
  /* Returns the size of the arrayList.*/
  public int listLength(){
    return list.size();
  }
  /* This instance method takes a single parameter of the concrete type and adds it
   * to the ArrayList.*/
  public void addItem(T item){
    list.add(item);
  }
  /* This instance method takes an integer index and returns the item at that position
   * in the ArrayList. */
  public T getItem(int position){
    return list.get(position);
  }
  /* This instance method takes n integer index parameter and returns the number
   * of units. */
  public int getQuantity(int index){
    return list.get(index).getQuantity();
  }
  /* printInventory takes a parameterized Inventory object and invokes the toString()
   * method of each item, printing them one per line.*/
  public static <E extends Item> void printInventory(Inventory<E> inventory){
    for(int i=0; i < inventory.listLength(); i++){
      System.out.println(inventory.getItem(i).toString());
    }
  }
  /* Method takes a parameterized Inventory object and returns the oldest item in the 
   * inventory. */
  public static <E extends DatedItem> E getOldestItemFromInventory(Inventory<E> inventory){
    E oldest = inventory.getItem(0);
    for(int i=1; i < inventory.listLength()-1; i++){
      
      if(oldest.compareTo(inventory.getItem(i)) > 0)
        oldest = inventory.getItem(i);
    }
    return oldest;
  }
  /* This static method takes three parameters: a parameterized inventory object, a String
   * for an item's name, and an integer for an item's quantity. It creates an Orange item with
   * the given name and quantity, and with a package date of the current date. It then adds this
   * item to the given Inventory object.*/
  public static void addOrangesToInventory(Inventory<Fruit> inventory, String name, int quantity){
    Orange newOrange = new Orange(name, quantity, new Date());
    
    inventory.addItem((newOrange));
  }
}
    
    
  
  