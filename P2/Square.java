//Class Square is a subclass of Rectangle.
public class Square extends Rectangle{
  
  //Constructor for square. Calls the constructor in its parent class.
  public Square(String id, Coordinate loc, int size){
    super(id, loc, size, size);
  }
  
}