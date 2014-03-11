/* 
CSE 17 
Bart Michalak
bpm215 
Program #5     DEADLINE: December 15, 2012 
Program Description: MP3 Library with Linked Lists
*/
/*This is a generic 
method with generic type parameter T. This method uses the split and mergeSortedLists
methods above to implement a version of the merge sort algorithm that sorts the linked 
list list using the comparator comp. 
*/
import java.util.*;
public class LinkedMergeSort{
  public static <T> void mergeSort(MyLinkedList<T>  list, Comparator<T> comp){
    MyLinkedList<T> list2 =new MyLinkedList<T>();
      list2=list.split(list.size()/2);
    
    if(list.size()>1){
      
      mergeSort(list,comp);
      mergeSort(list2,comp);
      MyLinkedList.mergeSortedLists(list,list2,comp);
    }
  }
}