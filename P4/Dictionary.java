import java.util.ArrayList;

public class Dictionary {
  private ArrayList<ArrayList<String>> dictionary;
  /* constructor for dictionary class. used when a specified maximum word length is assigned by user. */
  public Dictionary(int maxWordLength){
    dictionary = new ArrayList<ArrayList<String>>();
    /* adds words into dictionary. */
    for(int i = 0; i < maxWordLength; i++){
      //ArrayList temp = new ArrayList<String>();
      dictionary.add(new ArrayList<String>());
    }
  }
  /* no-arg constructor for default case of word length. */
  public Dictionary() {
    dictionary = new ArrayList<ArrayList<String>>();
    for(int i = 0; i < 10; i++){
      ArrayList<String> temp = new ArrayList<String>();
      dictionary.add(temp);
    }
  }
  /* adds entry to the dictionary. Takes in String word. */
  public void addEntry(String word){
    if(word.length() <= dictionary.size())  
      dictionary.get(word.length() -1).add(word);
    
  }
  /* Helper method for the recursive binary search lookup(). */
 public boolean lookup(String s){
   //System.out.println(s.length());
   
   return lookup(dictionary.get(s.length()-1),(dictionary.get(s.length()-1)).size()-1, 0, s);
 }
 
 /* recursive binary search that looks for the key String s within the sub array of ArrayList dictionary. */
 public boolean lookup(ArrayList<String> dict, int high, int low, String s){
   int mid = (high+low)/2;
   //System.out.println((dict.get(mid)));
   //System.out.println(mid);
   if(low>high)
     return false;
   if(s.compareTo(dict.get(mid))==0)
     return true;
   else if(s.compareTo(dict.get(mid))>0){
     return lookup(dict, high, (mid+1), s);
     
     /*if(low == mid){
       if(s.compareTo(dict.get(high))==0)
         return true;
       return false;}*/
   }
  
   
    
    else/* if(s.compareTo(dict.get(mid))<0)*/{
     /*if(low == mid)
       return false;*/
       return lookup(dict, (mid-1), low, s);
   }
 }
}
