/*
 Rectangle is a subclass of class Shape. The Rectangle
 class.
 */
public class Rectangle extends Shape{
  
  /*Variable declarations. The variables length are height
   are encapsilated. Length is the horizontal demension and
   vertical dimension of the rectangle.
   */
  private int length;
  private int height;
  
  //Constructor, initializes object
  public Rectangle(String id, Coordinate loc, int length, int height){
    super(id, loc);
    this.length = length;
    this.height = height;
  }
  
  /*The draw() method draw an '*' on the grid of dis. It does not
   actually change anything on screen meaning it does not print.
   */
  public void draw(AsciiDisplay dis){
    for(int i =location.getX(); i < (location.getX() + length); i++){
      for(int j = location.getY(); j < (location.getY() + height); j++){
        dis.putCharAt(i, j, '#');
      }
    }
  }
}
  