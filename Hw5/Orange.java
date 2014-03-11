/*
CSE 17
Bartlomiej Michalak
bpm215
Homework #5 DEADLINE: November 30, 2012
Program Description: Generics Inventory
*/
import java.util.*;
/* Class Orange extends Fruit and provides methods used by Orange objects.*/
public class Orange extends Fruit{
  /* Constructor for the Orange class.*/
  public Orange(String name, int quantity, Date packDate){
    super(name, quantity, packDate);
  }
  /* Overrided toString() method used for the Orange class objects.*/
  public String toString(){
    return this.getName()+" Orange, "+this.getQuantity()+" Fruits, Packaged: "+
      this.getPackDate();
  }
}