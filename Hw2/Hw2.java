/*
 * CSE 17
 * Bartlomiej (Bart) Michalak
 * Bpm215
 * Intro program(???)
 * Homework #2      DEADLINE: September 8, 2012
 */
import java.util.Scanner;
public class Hw2{
  public static void main(String[] args){
    //sets up the scanner class for user input.
    Scanner input = new Scanner (System.in);
    
    System.out.println("Enter the number of students: ");
    int students = input.nextInt();
    
    //allocate memory for the number of students entered by user.
    int[] listArray = new int[students];
    System.out.println("Enter " + students + " scores:");
    
    //fills the array with the grades assigned to individual students
    for(int i = 0; i<listArray.length; i++){
      listArray[i] = input.nextInt();
      //System.out.println(listArray[i]);
    }
    
    //Line 27 assigns a double value onto the variable average returned from meth ClassAverage 
    double average = ClassAverage(listArray);
    System.out.println("The class average is :" + average);
    
    grade(listArray, average);
    
  }
    /*Method ClassAverage takes in listArray as a parameter and adds up all the elements within it
     * and takes the average of it. It then returns the value of the calculated average.
     */
    public static double ClassAverage(int[] list){
      double temp = 0;
      double average = 0;
      for(int i =0; i<list.length; i++){
        temp+= list[i];
      }
      average = (temp/(list.length));
      return average;
    }
    /*The method grade takes in the parameters of array listArray and the double average and uses it
     * via nested if statements to assign a grade to the score. The nested if statements also print out the
     * result of the method.
     */
    public static void grade(int [] list, double average){
      for(int i = 0; i<list.length; i++){
        if((list[i]/average) >= 1.2)
          System.out.println("Student " + i + " score is " + list[i] + " and grade is A.");
        else if((list[i]/average) >= 1.1)
          System.out.println("Student " + i + " score is " + list[i] + " and grade is B.");
        else if((list[i]/average) >= .9)
          System.out.println("Student " + i + " score is " + list[i] + " and grade is C.");
        else if((list[i]/average) >= .8)
          System.out.println("Student " + i + " score is " + list[i] + " and grade is D.");
          else
            System.out.println("Student " + i + " score is " + list[i] + " and grade is F.");
      }
    }
}