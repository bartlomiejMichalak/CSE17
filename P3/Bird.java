/**
 * Bird is a subclass of Pet and holds all the controlling methods for all
 * objects of pet that are bird.
 */
public class Bird extends Pet{
  private boolean clipped;
  /**
   * constructor for bird.
   */
  public Bird(String name, String owner, double weight, boolean clipped){
    super(name, owner, weight);
    this.clipped = clipped;
  }
  /**
   * getter for clipped.
   */
  public boolean isClipped(){
    return clipped;
  }
  /**
   * Setter for clipped.
   */
  public void setClipped(boolean clipped){
    this.clipped = clipped;
  }
  /**
   * getSize() returns corresponding sizes depending on the weight read in
   * from the file.
   */
  public String getSize(){
    if(weight > 2){
      return "large";
    }
    else if (weight < 0.1){
        return "small";
    }
    else{
        return "medium";
    }
  }
  
  public String toString(){
    if(clipped == false)
      return name + " owned by " + owner + ": " + getSize() + " Bird, " + weight + " lbs., not clipped.";
    else
      return name + " owned by " + owner + ": " + getSize() + " Bird, " + weight + " lbs";
  }  
}