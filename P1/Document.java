/*  
CSE 17  
Bart Michalak 
bpm215
Program #1      DEADLINE: September 30, 2012  
Program Description: Search Engine Basics 
*/ 
import java.lang.Math;
import java.util.Scanner;
import java.io.File;

public class Document{
  public static final int MAX_WORDS = 1000;
  private String[] terms;
  private String fileName;
  private int[] freqs;
  private double magnitude;
  
  public Document(){
    magnitude = 1;
  }
  
  public String[] getTerms(){
    return terms;
  }
  
  private void sort(String[] inputArray){
    String key;
    int index;
    int index2;
    String temp;
    for(index = 1; (index < inputArray.length) && (inputArray[index] != null); index++){
      index2 = index;
      while((index2 > 0) && (inputArray[index2].compareTo(inputArray[index2-1]) < 0)){
        temp = inputArray[index2];
        inputArray[index2] = inputArray[index2-1];
        inputArray[index2-1] = temp;
        index2--;
      }
    }
  }
  
  //Input array should be sorted
  private int countDistinctStrings(String[] sortedArray){
    int count = 1;
    for(int index = 1; (index < sortedArray.length) && (sortedArray[index] != null); index++){
      if(!(sortedArray[index].equalsIgnoreCase(sortedArray[index-1]))){
        count++;
      }
    }
    return count;
  }
  
  public void indexContent(String[] wordArray){
    sort(wordArray);
    int arraySize = countDistinctStrings(wordArray);
    terms = new String[arraySize];
    freqs = new int[arraySize];
    loadTerms(wordArray);
    for(int index = 0; index < terms.length - 1; index++){
      magnitude += Math.pow(freqs[index],2);
    }
    magnitude = Math.sqrt(magnitude);
  }
  
  public void printTermFreqs(){
    System.out.print("The frequency list for " + fileName + ":");
    for(int index = 0; index < terms.length; index++){
      if((index % 4) == 0){
        System.out.println("");
      }
      System.out.printf("%-15s%3d\t\t",terms[index],freqs[index]);
    }
  }
  
  private int binarySearch(String[] sortedArray, String key){
    int low = 0;
    int high = sortedArray.length - 1;
    while(low <= high){
      int middle = (high + low)/2;
      if(sortedArray[middle].equalsIgnoreCase(key)){
        return middle;
      }
      if(key.compareTo(sortedArray[middle]) > 0){
        low = middle + 1;
      }
      else{
        if(key.compareTo(sortedArray[middle]) < 0){
          high = middle - 1;
        }
      }
    }
    return -1;
  }
  
  public int getFrequency(String key){
    int freq = 0;
    int index = binarySearch(terms, key);
    if(index != -1){
      return freqs[index];
    }
    return freq;
  }
  
  public double getSimilarity(String[] query){
    double similarity = 0;
    double numerator = 0;
    double denominator;
    for(int index = 0; index < query.length; index++){
      numerator += getFrequency(query[index]);
    }
    denominator = magnitude * Math.sqrt(query.length);
    similarity = numerator / denominator;
    return similarity;
  }
  
  public void indexFromFile(String sourceFile) throws Exception{
    this.fileName = sourceFile;
    String[] inputArray = new String[MAX_WORDS];
    File file = new File(sourceFile);
    Scanner input = new Scanner(file);
    int index = 0;
    while(input.hasNext()){
      if(index + 1 < MAX_WORDS){ // Check for space in the array.
        inputArray[index] = input.next().toLowerCase();
        index++;
      }
      else{
        System.out.println("File too large...program ending.");
        System.exit(-1);
      }
    }
    indexContent(inputArray);
  }
  
  private void loadTerms(String[] wordArray){
    int frequency = 1;
    int termsIndex = 0;
    for(int index = 1; (index < wordArray.length) && (wordArray[index] != null); index++){
      if(wordArray[index].equalsIgnoreCase(wordArray[index-1])){
        wordArray[index-1] = null;
        frequency++;
      }
      else{ // New word found.
        freqs[termsIndex] = frequency;
        frequency = 1;
        termsIndex++;
      }
      freqs[termsIndex] = frequency;
    }
    termsIndex = 0;
    for(int index = 0; index < wordArray.length; index++){
      if(wordArray[index] != null){
        terms[termsIndex] = wordArray[index];
        termsIndex++;
      }
    }
  }
  
  public static void main(String args[]) throws Exception{
    if(((args.length == 0) || (args.length > 1))){
      System.out.println("Usage: java Document filename.");
      System.exit(-1);
    }
    String query = "";
    Scanner input = new Scanner(System.in);
    Document doc = new Document();
    doc.indexFromFile(args[0]);
    doc.printTermFreqs();
    String again = "Y";
    do{
      System.out.print("\n\nEnter a query: ");
      query = input.nextLine();
      System.out.printf("%s%.3f","\nSimiliarity: ",doc.getSimilarity(query.split(" ")));
      System.out.print("\n\nCompare to another query? (Y/N) ");
      again = input.nextLine();
    }while(!(again.equalsIgnoreCase("N")));
  }
}