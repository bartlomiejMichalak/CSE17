/*
CSE 17
Bartlomiej Michalak
bpm215
Homework #5 DEADLINE: November 30, 2012
Program Description: Generics Inventory
*/
import java.util.Date;
/* Abstract class Fruit extends DatedItem and provides methods for Fruit objects. */
abstract class Fruit extends DatedItem{
  /*Constructor for the Fruit class.*/
  public Fruit(String name, int quantity, Date packDate){
    super(name, quantity, packDate);
  }
}
  