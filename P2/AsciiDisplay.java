/* 
CSE 17 
Bartlomiej "Bart" Michalak 
Bpm215
P2      DEADLINE: October 22, 2012 
Program Description: Ascii Display 
*/

//import declarations
import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

/*
 * the class AsciiDisplay contains the controlling methods for the grid
 * as well as delete functions of the board and the main() method.
 */
public class AsciiDisplay{
  private char[][] grid;
  private java.util.ArrayList<Shape> shapes;
  
  //AsciiDisplays no-arg constructor, initializes grid, the boards array and shapes.
  public AsciiDisplay(){
    grid = new char[15][30];
    shapes = new ArrayList<Shape>();
  }
  
  //adds a Shape object to shapes. Does not alter the grid array.
  public void addShape(Shape s){
    shapes.add(s);
  }
  /*moveShape() moves the shape with the given id to newLoc and returns 0.
   * If the shape is not found within the arrayList of object type Shapes
   * it reutrns -1.
   */
  public int moveShape(String id, Coordinate newLoc){
    for(Iterator<Shape> i = shapes.iterator(); i.hasNext();){
      Shape temp = (Shape) i.next();
      if(temp.id.equals(id)){
        temp.location = newLoc;
        return 0;
      }
    }
    return -1;
  }
  
  /*print grid calls the updateGrid() and then prints the contents of grid
   * to System.out using print().
   */
  public void printGrid(){
    updateGrid();
    System.out.println("+------------------------------+");
    for(int i = 0; i < grid.length; i++){
      System.out.print("|");
      for(int j = 0; j < grid[i].length; j++){
        System.out.print(grid[i][j]);
      }
      System.out.print("|");
      System.out.println();
    }
    System.out.println("+------------------------------+");
  }
  
  //Deletes all objects from shapes. Does not directly alter grid.
  public void deleteAll(){
    shapes.clear();
  }
  
  /*Places a character c at a specific (x,y) location on the grid.
   */
  public void putCharAt(int x, int y, char c){
    grid[y][x] = c;
  }
  
  //Clears grid and "draws" each element of shapes in it.
  private void updateGrid(){
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        grid[i][j] = ' ';
      }
    }
    for(int i=0; i< shapes.size(); i++){
      Shape temp = (Shape) shapes.get(i);
      temp.draw(this);
    }
  }
  //parses text from the file and places in array to later parse commands in main().
    private List<String> readSmallTextFile(String aFileName) throws IOException{
      Path path = Paths.get(aFileName);
      return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
    
    public static void main(String[] args){
      AsciiDisplay obj = new AsciiDisplay();
      //closes the program in there are not arguments.
      if(args.length > 1){
        System.out.println("Usage: java AsciiDisplay filename");
        System.exit(0);
      }
      ArrayList<String> input = new ArrayList<String>();
      try{
      input = new ArrayList<String>(obj.readSmallTextFile("face.txt"));
      }
      catch(FileNotFoundException ex){
        System.out.println("ERROR: Couldn't open file: filename");
        System.exit(0);
      }
      catch(IOException ex){
        System.out.println("ERROR: Couldn't open file: filename");
        System.exit(0);
      }
      
      for (int i = 0; i < input.size(); i++){
        
        //logging input to console
        System.out.print(input.get(i));
        System.out.println();
        
        obj.parseCommand(input.get(i));
      }
      
    }
    
    private void parseCommand(String command) {
      String[] commands = command.split(" ");
      /*loop parses the commands and takes the appropriate action to places characters
       * into the grid.
       */
      if (commands[0].equals("P")) {
        System.out.print("Adding a new point");
        System.out.println();
        String id = commands[1];
        Coordinate loc = new Coordinate (Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
        Point point = new Point (id, loc);
        addShape(point);
      }
      else if(commands[0].equals("R")){
        System.out.println("Adding a new Rectangle");
        String id = commands[1];
        Coordinate loc = new Coordinate (Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
        int length = Integer.parseInt(commands[4]);
        int height = Integer.parseInt(commands[5]);
        Rectangle rectangle = new Rectangle(id, loc, length, height);
        addShape(rectangle);
      }
      else if(commands[0].equals("S")){
        System.out.println("Adding a new Square");
        String id = commands[1];
        Coordinate loc = new Coordinate (Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
        int size = Integer.parseInt(commands[4]);
        Square square = new Square(id, loc, size);
        addShape(square);
      }
      else if(commands[0].equals("M")){
        System.out.println("Moving the shape");
        String id = commands[1];
        Coordinate loc = new Coordinate (Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
        moveShape(id, loc);     
      }
      else if(commands[0].equals("E")){
        System.out.println("Deleting all shapes.");
        deleteAll();
      }
      else if(commands[0].equals("D")){
        System.out.println("Drawing current set of shapes.");
        printGrid();
      }
      else{
        System.out.println("Invalid command: " + commands[0]);
      }

    }
}
      