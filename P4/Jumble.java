/**
 * CSE 17
 * Bartlomiej (Bart) Michalak
 * bpm215
 * Progam #4     DEADLINE: November 20, 2012
 * Program Description: Dictionary
 */

/**
 * import declarations.
 */
import java.util.*;
import java.io.*;
public class Jumble{
  
  /* Helper method for the recursive method findPermutations(). Method takes in the scrambled word
   * and then finds all permutations of the word using recursion. It then adds all the words in an array that
   * is then checked individually against the dictionary. */
  public static String[] findPermutations(String s){
    ArrayList<String> permutations = new ArrayList<String>();
    findPermutations("", s, permutations);
    return permutations.toArray(new String[permutations.size()]);
  }
    
  public static void findPermutations(String s1, String s2, ArrayList<String> permutations) {
    if (s2.length() <= 1){
      if (!permutations.contains(s1 + s2)) {
        permutations.add(s1 + s2);
        //System.out.println(s1 + s2);
      }
    }
    else
      for (int i = 0; i < s2.length(); i++) {
      
      String newPermutation = s2.substring(0, i) + s2.substring(i + 1);
      //permutatuions.add(newPermutation);
      findPermutations(s1 + s2.charAt(i), newPermutation, permutations);
          
    }
  }

  
  
  public static void main(String[] args){
    //System.out.println(args.length);
    /* checks that there are either one or two arguments passed into the main() method. 
     * If there are not one or two arguments the user is notified and the program terminates.*/
    if(args.length != 1 && args.length != 2){
      System.out.println("Usage: java FileDemo filename");
      System.exit(0);
    }
    /* creates new dictionary. */
    Dictionary dictionary = new Dictionary();
    /* arguments for the case that only one argument is passed into the main. */
    if(args.length==1){
      
      String name = args[0];
      System.out.println(name);
      int count = 0;
      File file = new File(name);
      try{
      Scanner input = new Scanner(file);
      /*the dictionary is read at normal capacity since the default maxWordLength of 10 is used.
       * Each word is read off the file and placed in the dictionary object. Count records the number of words added
       * into the dictionary and then reads it off once the program is run. */
      while(input.hasNext()){
        String word = input.nextLine();
        dictionary.addEntry(word);
        count++;
      }
      System.out.println("Read in "+count+" words.");
      }
      catch (FileNotFoundException e){
        System.out.println("FILE NOT FOUND ERROR!");
      }
    }
    int arg = 10;
    try{
      /* this case is meant for the user specified maxWordLength. The arg is parsed into an integer from a string so that
       * it can then be used by the consstructor to specify word length. */
    if(args.length==2){
      arg = Integer.parseInt(args[0]);
      dictionary = new Dictionary(arg);
      String name = args[1];
      int count = 0;
      File file = new File(name);
      try{
      Scanner input = new Scanner(file);
      while(input.hasNext()){
        String word = input.nextLine(); 
        if(word.length()<= arg){
        dictionary.addEntry(word);
        count++;
        }
      }
      System.out.println("Read in "+count+" words.");
      }
      catch(FileNotFoundException e){
        System.out.println("FILE NOT FOUND ERROR!");
        System.exit(3);
      }
    }
    }
    catch(NumberFormatException e){
      System.out.println("First argument should be an integer.");
      System.exit(3);
    }
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a scrambled word: ");
    String scrambled = " ";
    while(scrambled.equals("")== false){
      scrambled = input.nextLine();
      
      if(scrambled.length() > arg){
        System.out.println("Word entered is greater than the default or specified max word length.");
        System.exit(3);
      }
      
      if(scrambled.equals("")== false){
      String[] permutation = findPermutations(scrambled);
      System.out.println("The words formed from " +"'"+scrambled+"'"+ " are:");
      /* performs the lookup for the permutations and checks them against the dictionary. */
      int counter = 0;
      for(int i=0; i< permutation.length; i++){
        if(dictionary.lookup(permutation[i])==true){
          System.out.println(permutation[i]);
          counter++;
        }
        
      }
      if(counter == 0)
        System.out.println("No words are formed from "+"'"+scrambled+"'");
      }
      if(scrambled.isEmpty())
        System.out.println("Goodbye!");
    }
  }
}
    
