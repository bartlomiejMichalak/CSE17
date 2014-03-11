/* 
CSE 17 
Bart Michalak
bpm215 
Program #5     DEADLINE: December 15, 2012 
Program Description: MP3 Library with Linked Lists
*/
import java.io.*;
import java.util.*;
public class Playlist{
  
  String name;
  MyLinkedList<Song> songs = new MyLinkedList<Song>();

  
  public Playlist(String name){
    this.name = name;
  }
  
  public String getName(){
    return name;
  }
  
  public Song getSong(int index){
    return songs.get(index);
  }
  
  public int getNumSongs(){
    return songs.size();
  }
  
  public void addSong(Song song){
    songs.add(song);
  }
  
  public void printList(){
    System.out.println(name);
    for(int i=1; i < songs.size(); i++){
      System.out.println(i+")\t");
      Song someSong = songs.get(i);
      someSong.printSongRow();
    }
  }
  public void sortByYear(){
    LinkedMergeSort.mergeSort(songs, Song.SongYearComparator);
  }
  public void sortByArtist(){
    LinkedMergeSort.mergeSort(songs, Song.SongArtistComparator);
  }
  public void sortByTitle(){
    LinkedMergeSort.mergeSort(songs, Song.SongTitleComparator);
  }
public static Playlist readPlayListFromFile(String filename){
    
    
    Playlist myPlaylist = new Playlist("");
    try{
      
      File someFile = new File(filename);
      Scanner data = new Scanner(someFile).useDelimiter("\n");;
      String name = data.nextLine();
      
      myPlaylist = new Playlist(name);
      
      while(data.hasNext()){
        
        Scanner params = new Scanner(data.next()).useDelimiter("\t");;
        
        String title = params.next();
        String artist = params.next();
        String album = params.next();
        int year = params.nextInt();
        String length = params.next();
        
        Song aNewSong = new Song(title, artist, album, year, length);
        
        myPlaylist.addSong(aNewSong);
      }
  }
    catch(FileNotFoundException ex){
      System.out.println("File has not been found. Exiting program...");
      System.exit(3);
    }
    return myPlaylist;
  }
  public static void main(String[] args){
    int i = 0;
    Playlist aPlaylist=new Playlist("");
    while(i < args.length){
       aPlaylist = readPlayListFromFile(args[i]);
      aPlaylist.printList();
      i++;
    }
    Playlist firstList = readPlayListFromFile(args[0]);
    Playlist lastList = readPlayListFromFile(args[args.length-1]);
    
    firstList.sortByArtist();
    System.out.println("Sorting first list...");
    firstList.printList();
    
    lastList.sortByYear();
    System.out.println("Sorting last list...");
    lastList.printList();
    
    System.out.println(firstList.getSong(1).toString());
    System.out.println(firstList.getSong(firstList.getNumSongs()-1).toString());

    
  }
}


