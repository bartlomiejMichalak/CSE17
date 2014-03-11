/**
 * Parent class for subclasses Bird and Dog.
 */
public abstract class Pet{
  /**
   * The variables for the Pet class are protected variables.
   */
  protected String name;
  protected String owner;
  protected double weight;
  /**
   * Constructor for the Pet class, initializes the fields used for the file.
   */
  public Pet(String name, String owner, double weight){
    this.name = name;
    this.owner = owner;
    this.weight = weight;
  }
  /**
   * getter for field name, returns name.
   */
  public String getName(){
    return name;
  }
  /**
   * getter for owner field, returns owner.
   */
  public String getOwner(){
    return owner;
  }
  /**
   * setter for weight.
   */
  public void setWeight(double weight){
    this.weight = weight;
  }
  
  public abstract String getSize();
  /**
   * overrided toString() method for Pet class.
   */
  public String toString(){
    return name + " owned by" + owner + ": " + getSize() + "Pet," + weight + "lbs";
  }
  /**
   * overrides Object's equals method. Returns true if o is a pet with the
   * same name and owner.
   */
  public boolean equals(Object o){
    boolean equals = false;
    if(o instanceof Pet){
      Pet temp = (Pet)o;
      if(temp.getName().equals(this.name)&&temp.getOwner().equals(this.owner))
        equals = true;
    }
    return equals;
  }
}