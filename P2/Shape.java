/*Shape is the class of all the objects that can
 * be drawn to the display
 */
public class Shape{

//The variables are protected.
  protected String id;
  protected Coordinate location;
  
  //Constructor for the Shape class.
  public Shape(String id, Coordinate location){
    this.id = id;
    this.location = location;
  }
  
  /*Method draws a question mark at the location designated on the
   display grid.
   */
  public void draw(AsciiDisplay dis){
    dis.putCharAt(location.getX(), location.getY(), '?');
  }
  
  //Changes the location of the object to newLoc.
  public void move(Coordinate newLoc){
    this.location = newLoc;
  }
  /*Returns true is the actual parameter is a Shape with the same ID.
   * It overrides the equals() method.
   */
  public boolean equals(Object obj){
    if(obj instanceof Shape){
      Shape temp = (Shape) obj;
      if(temp.getId().equals(id))
        return true;
    }
    return false;
  }
  //getter for String id.
  public String getId() {
    return id;
  }
  
}