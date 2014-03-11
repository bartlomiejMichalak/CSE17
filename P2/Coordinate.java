/*
 * The coordinate class represent an (x,y) coordinate
 * the display. The x position is the number of spaces
 * that the character is from the leftmost column. The 
 * y position represents the number of lines down the
 * character is from the top row.
 */
public class Coordinate{
  private int x;
  private int y;
  
  //constructor for the Coordinate class.
  public Coordinate(int x, int y){
    this.x = x;
    this.y = y;
  }
  
  //getter for integer value x.
  public int getX(){
    return x;
  }
  
  //getter for the integer value y.
  public int getY(){
    return y;
  }
  
}
  