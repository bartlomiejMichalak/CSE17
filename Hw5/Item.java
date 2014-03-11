/*
CSE 17
Bartlomiej Michalak
bpm215
Homework #5 DEADLINE: November 30, 2012
Program Description: Generics Inventory
*/
import java.util.*;
/* Item is an abstract class and the highest level. */ 
abstract class Item{
  /* variable declarations. Variable name and quantity are protected variables.*/
  protected String name;
  protected int quantity;
  
  /* Constructor for the item class. */
  public  Item(String name, int quantity){
    this.name = name;
    this.quantity = quantity;
  }
  /* Getter for the protected variable name. */
  public String getName(){
    return name;
  }
  /* Getter for the protected variable quantity. */
  public int getQuantity(){
    return quantity;
  }
  
}