/*
CSE 17
Bartlomiej Michalak
bpm215
Homework #5 DEADLINE: November 30, 2012
Program Description: Generics Inventory
*/
import java.util.*;
import java.lang.Comparable;
/* Dated item is an abstract class that implements the comparable interface.*/
abstract class DatedItem extends Item implements Comparable<DatedItem>{
  /* Variable declarations for the DatedItem class.*/
  protected Date packDate;
  /* Constructor for the DatedItem class.*/
  public DatedItem(String name, int quantity, Date packDate){
    super(name, quantity);
    this.packDate = packDate;
  }
  /* Getter for the protected Date packDate. */
  public Date getPackDate(){
    return packDate;
  }
  /* Overided compareTo() method. Returns a 0 if objects are identical, 1 if the compared
   * compared object is greater, and -1 if it is lesser. */
  public int compareTo(DatedItem item){
    /*switch(this.packDate.compareTo(item.getPackDate())){
      case -1: return -1;
      case 0: return 0;
      case 1: return 1;
      default: return ;
    }*/
    return this.packDate.compareTo(item.getPackDate());
  }
}