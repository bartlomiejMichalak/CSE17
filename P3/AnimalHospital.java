/**
 * CSE 17
 * Bartlomiej (Bart) Michalak
 * bpm215
 * Progam #3     DEADLINE: November 2, 2012
 * Program Description: Veterinary Hospital
 */

/**
 * import declarations.
 */
import java.util.*;
import java.text.*;
import java.io.*;

public class AnimalHospital{
  /**
   * ArrayList<pet> pets stores all pets that are patients of the hospital
   * the <pet> limits the ArrayList to only objects of type pet.
   */
  ArrayList<Pet> pets;
  /**
   * Initializes a new pets array list.
   */
  public AnimalHospital(){
    pets = new ArrayList<Pet>();
  }
  /**
   * Adds a pet to the end of the pets array list.
   */
  public void addPet(Pet pet){
    pets.add(pet);
  }
  /**
   * Method readData reads a set of pet descriptions from the file specified by the parameter
   * and populates pets.
   */
  public void readData(String filename){
    String dateString = "";
    Date vaccineDate;
    int lineNumber = 1;
    /**
     * converts the date created into a date format that is readable
     * by the system.
     */
    SimpleDateFormat myDateFormat;
    /**
     * FileNotFoundException is thrown when trying to open a file that
     * does not exist. ParseException, thrown by SimpleDateFormat as shown
     * occurs when date-string is in incorrect format. NoSuchElementException
     * is used to discover a line that ends without specifying all the fields.
     */
    try{
      File newFile = new File(filename);
      newFile.exists();
      Scanner input = new Scanner(newFile);
    
    try{
      /**
       * The file is parsed line by line reading each word in between whitespaces.
       * If the first word parsed is "BIRD" then the if statement takes in the fields
       * using command and input2. Likewise if first word parsed is "DOG".
       */
      while(input.hasNext()){
        String command = input.nextLine();
        Scanner input2 = new Scanner(command);
        String name1 = input2.next();
        if(name1.equals("BIRD")){
          String name = input2.next();
          String owner = input2.next();
          double weight = input2.nextDouble();
          boolean clipped = input2.nextBoolean();
          addPet(new Bird(name, owner, weight, clipped));
        }

          else if(name1.equals("DOG")){
            String name = input2.next();
            String owner = input2.next();
            double weight = input2.nextDouble();
            dateString = input2.next();
            myDateFormat = new SimpleDateFormat("MM/dd/yy");
            vaccineDate = myDateFormat.parse(dateString);
            boolean fixed = input2.nextBoolean();
            addPet(new Dog(name, owner, weight, vaccineDate, fixed));
          }
          
          else{
            System.out.println("ERROR-" + input2.next() + " is not a valid animal! Skipping line " + lineNumber);
          }
          lineNumber++;
      }
    }
    
    catch(ParseException ex){
      System.out.println("ERROR- Vacccine date " + dateString + " is not in mm/dd/yy format! Skipping line " + lineNumber);
    }
    catch(NoSuchElementException ex){
      System.out.println("ERROR- missing fields at line number" + lineNumber);
      System.exit(1);
    }
    }
    
    catch(FileNotFoundException ex){
      System.out.println("ERROR- could not open the file" + filename);
    }
  }
  /**
   * Prints out the contents of pets using the toString method of each element.
   */
  public void printPetList(){
    for(int i = 0; i < pets.size(); i++){
      Pet pet = pets.get(i); 
      System.out.println(pet.toString());
    }
  }
  
  public int getPetIndex(Pet pet){
      for(int i = 0; i<pets.size(); i++){
        if(pet.equals(pets.get(i))){
          return i;
        }
      }
      return -1;
  }
  
  public Pet getPet(int index){
    return pets.get(index);
  }
  /**
   * main method makes calls to all the methods and initiates the read for the
   * file.
   */
  public static void main(String[] args){
    AnimalHospital newVet = new AnimalHospital();
    newVet.readData("pets.data");
    newVet.printPetList();
    
    System.out.println();
    System.out.println("Vaccinating Dick's Dog Spot...");
    System.out.println();
    
    Dog aDog = new Dog("Spot", "Dick", 1, new Date());
    Dog newDog = (Dog)newVet.getPet(newVet.getPetIndex(aDog));
    newDog.setVaccineDate(new Date());
    newVet.printPetList();
  }
}
  
    
          
         