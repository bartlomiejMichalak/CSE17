/*  
CSE 17  
Bart Michalak  
bpm215  
Program Description: provide a description  
Homework #3      DEADLINE: September 15, 2012  
*/ 
public class Shark{
  
  private int id;
  private String name;
  private String species;
  private char sex;
  private int weight;
  private static int nextId =1;
  
  /** A constructor that creates a TvShow object with a given name,
    * channel and length. */
  public Shark(String aName, String aSpecies, char aSex, int aWeight) {
    name = aName;
    species = aSpecies;
    weight = aWeight;
    sex = aSex;
    id = nextId;
    Shark.nextId++;
  }
  
  public int getId(){
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getSpecies() {
    return this.species;
  }
  
  public char getSex() {
    return this.sex;
  }
  
  public int getWeight() {
    return this.weight;
  }
  
  public void setWeight(int aWeight) {
    this.weight = aWeight;
  }
  
  public int getNextId() {
    return this.nextId;
  }

  public void printShark(){
    System.out.println("Id: " + this.getId() + ", " + this.getName() + ", " + this.getSpecies() + " (" + this.getSex() + "), " + this.getWeight() + " lbs.");
  }
  
  public static Shark getLargestShark(Shark[] mySharks){
    Shark largestShark = mySharks[0];
    for(int index = 1; index < mySharks.length; index++){
      if(largestShark.getWeight() < mySharks[index].getWeight()){
        largestShark = mySharks[index];
      }
    }
    return largestShark;

  }
  
  public static void main(String[] args){
    boolean done = false;

    
    Shark[] mySharks = {new Shark("Tim","Hammerhead", 'M', 620), 
      new Shark("Edge","Lemmon",'M', 175), 
      new Shark("Sheila", "Great White", 'F', 2200),
      new Shark("Buster","Bull", 'F', 205)
    };
    
    for(int index = 0; index < mySharks.length; index++){
      mySharks[index].printShark();
    }
    
    System.out.println("\nThe biggest shark is: ");
    getLargestShark(mySharks).printShark();
    
    System.out.println("\nChanging Tim's weight...");
    
    int index = 0;
    while(!done){
      if(index > mySharks.length - 1){
        System.out.println("That shark does not exist!");
        done = true;
      }
      else{
        if(mySharks[index].getName() == "Tim"){
          mySharks[index].setWeight(660);
          mySharks[index].printShark();
          done = true;
        }
        index++;
      }
    }
    System.out.println("\nNext available id: " + nextId);
  }
}