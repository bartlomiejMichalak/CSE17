import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Dog is a subclass of Pet. Implements the Vaccinatable interafce.
 */
public class Dog extends Pet{
  private boolean fixed;
  private Date vaccineDate;
  /**
   * There are three different overloaded constructors for the Dog class.
   * All of them initialize fields using parameter values.
   */
  public Dog(String name, String owner, double weight, Date vaccineDate){
    super(name, owner, weight);
    this.fixed = false;
    this.vaccineDate = vaccineDate;
  }
  
  public Dog(String name, String owner, double weight, Date vaccineDate, boolean fixed){
    super(name, owner, weight);
    this.fixed = fixed;
    this.vaccineDate = vaccineDate;
  }
  
  public Dog(String name, String owner){
    super(name, owner, 1);
    this.fixed = false;
    this.vaccineDate = new Date();
  }
  /**
   * getSize() returns corresponding sizes depending on the weight read in
   * from the file.
   */
  public String getSize(){
    if(weight < 50){
      return "large";
    }
    else if(weight < 30){
      return "small";
    }
    else{
      return "medium";
    }
  }
  /**
   * Returns the date of last vaccination.
   */
  public Date getvaccineDate(){
    return vaccineDate;
  }
  /**
   * setFixed() is the setter for fixed.
   */
  public void setVaccineDate(Date vaccineDate){
    this.vaccineDate = vaccineDate;
  }
  
  public boolean isFixed(){
    return fixed;
  }
  
  public void setFixed(boolean fixed){
    this.fixed = fixed;
  }
  /**
   * Overrided toString() method for the Dog class.
   */
  public String toString(){
    SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
    if(fixed == false)
      return name + " owned by " + owner + ": " + getSize() + " Dog, " + weight + " lbs., not fixed last vaccine: " + stdDate.format(vaccineDate);
    else
      return name + " owned by " + owner + ": " + getSize() + " Dog, " + weight + " lbs., last vaccine: " + stdDate.format(vaccineDate);
  }
}