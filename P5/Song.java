/* 
CSE 17 
Bart Michalak
bpm215 
Program #5     DEADLINE: December 15, 2012 
Program Description: MP3 Library with Linked Lists
*/
import java.lang.*;
import java.util.*;
public class Song{
  String title;
  String artist;
  String album;
  int time;
  int year;
  
  public Song(String title, String artist, String album, int year, int time){
    this.title = title;
    this.artist = artist;
    this.album = album;
    this.year = year;
    this.time = time;
  }
  
  public Song(String title, String artst, String album, int year, String timeString){
    this.title = title;
    this.artist = artist;
    this.album = album;
    this.year = year;
    this.time = timeStringToSecs(timeString);
  }
  
  public String getTitle(){
    return title;
  }
      
  public String getArtist(){
    return artist;
  }
  
  public String getAlbum(){
    return album;
  }
  
  public int getYear(){
    return year;
  }
  
  public int getTime(){
    return time;
  }
  
  public String getTimeAsFormattedString(){
    int min = (time / 60);
    
    int sec = (time % 60);
    
    return (Integer.toString(min) +":"+Integer.toString(sec));
  }
  
  public void printSongRow(){
    System.out.printf("%-25s\t%-25s\t%-30s\t%4d\t%-4s\n", title, artist, album, year, getTimeAsFormattedString());
  }
  
  public String toString(){
    return title+" by artist "+artist+"("+year+")";
  }
  
  /*public static int timeStringToSecs(String timeString){
    String[] time = timeString.split(":");
    int mins = 60*Integer.parseInt(time[0]);
    int secs = Integer.parseInt(time[1]);
    
    return mins+secs;
  }*/
  public static int timeStringToSecs(String timeString){
    String[] time=timeString.split(":");
    return 60*Integer.parseInt(time[0].trim())+Integer.parseInt(time[1].trim());
    
  }
  public static final Comparator<Song> SongTitleComparator = new Comparator<Song>(){
    public int compare(Song song1, Song song2){
      String title1=song1.getTitle().toLowerCase();
      String title2=song2.getTitle().toLowerCase();
      
      if((title1.compareTo(title2)) < 0){
        return -1;
      }
      else if(title1.compareTo(title2) > 0){
        return 1;
    }
      else return 0;
    }
  };
  public static final Comparator<Song> SongArtistComparator = new Comparator<Song>(){
    public int compare(Song song1, Song song2){
     String artist1=song1.getArtist().toLowerCase();
     String artist2=song2.getArtist().toLowerCase();
      
      if((artist1.compareTo(artist2)) < 0){
        return -1;
      }
      else if(artist1.compareTo(artist2) > 0){
        return 1;
    }
      else return 0;
    }
  };
  public static final Comparator<Song> SongYearComparator = new Comparator<Song>(){
    public int compare(Song song1, Song song2){
      if(song1.getYear() < song2.getYear()){
        return -1;
      }
      else if(song1.getYear() > song2.getYear()){
        return 1;
      }
      else
        return 0;
  }
  };
}       