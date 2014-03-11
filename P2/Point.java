/*
 The Point class extends class Shape. Point produces a
 single point on the array that is the coordinate grid.
 */
public class Point extends Shape{
  
  /* 
   Point() is the constructor for class Point. The super()
   instruction utilizes its parent class's constructor.
   */
  public Point(String id, Coordinate loc){
    super(id, loc);
  }
  
  /*
   Draws a ‘*’ at location on the grid of dis. Note, this does not 
   print anything to the screen; AsciiDisplay’s printGrid() will be 
   used to do that.
   */
  public void draw(AsciiDisplay dis){
    dis.putCharAt(location.getX(), location.getY(), '*');
  }
}