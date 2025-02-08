/*
   Name: Nina Matsukura Bernardino
   Date: 3/14/2024
   Program Purpose: user interface for manipulating and displaying user's music playlist
*/
import java.util.Scanner;

public class songDemo{
   private static Song currentSong; //Variable to hold currently playing song
   
   public static void displayMenu(){
      System.out.println("\nMenu:");
      System.out.println("1. Add a Song to the Playlist");
      System.out.println("2. Insert a new Song after the Song that is currently playing ");
      System.out.println("3. Print the contents of the Playlist");      
      System.out.println("4. Display the current Song");
      System.out.println("5. Remove the current song");
      System.out.println("6. Skip to the next song");
      System.out.println("7. Return to the previous song");
      System.out.println("8. Exit");
   }
   
   public static void main(String[] args){
      Scanner scanner = new Scanner (System.in);
      Playlist playlist = new Playlist();
      int choice = 0;
   
      while (choice != 8){
         //display menu
         displayMenu();
         System.out.println("Choice: ");
         choice = scanner.nextInt();
  
         //validates choice option
         while (choice > 8 || choice < 1){
            System.out.println("Invalid menu option- please try again");
            System.out.println("Choice: ");
            choice = scanner.nextInt();
         }
        
      
         scanner.nextLine();
         //Corresponding menu choices
         if (choice == 1){ //Add song to playlist
            System.out.println("Enter Song Information: ");
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Artist: ");
            String artist = scanner.nextLine();
            System.out.println("Album: ");
            String album = scanner.nextLine();
            System.out.println("Length (in seconds): ");
            int length = scanner.nextInt();    
            Song newSong = new Song (name,artist,album,length);
                    
            playlist.addSong(newSong); //adds newSong to playlist
            if (currentSong == null){//checks if playlist is empty
               currentSong = newSong; //sets newSong to currently playing song if playlist empty
            }
         }
         
         //2. Insert a new Song after the Song that is currently playing
         else if (choice == 2){ 
            if (currentSong != null){//checks if a current song exists to add new song after
               System.out.println("Enter Song Information: ");
               System.out.println("Name: ");
               String name = scanner.nextLine();
               System.out.println("Artist: ");
               String artist = scanner.nextLine();
               System.out.println("Album: ");
               String album = scanner.nextLine();
               System.out.println("Length (in seconds): ");
               int length = scanner.nextInt();
               
               Song newSong = new Song(name, artist, album, length); //initializes newSong object 
               playlist.addSongAfterCurrent(newSong, currentSong); //insert new song after current song    
            } 
            else{//if playlist is empty & currentSong is null
               System.out.println("Enter Song Information: ");
               System.out.println("Name: ");
               String name = scanner.nextLine();
               System.out.println("Artist: ");
               String artist = scanner.nextLine();
               System.out.println("Album: ");
               String album = scanner.nextLine();
               System.out.println("Length (in seconds): ");
               int length = scanner.nextInt();
 
               Song newSong = new Song(name, artist, album, length); //initializes newSong object 
               playlist.addSong(newSong);//adds new song to the empty playlist
               currentSong = newSong;
            }                 
         }
         
         //3. Print the contents of the Playlist
         else if (choice == 3){ 
            System.out.println(playlist);
         }
         
         //4. Display current song
         else if (choice == 4){           
            Song firstSong = playlist.getFirstSong();
            if (firstSong != currentSong){ //if current song hasn't been displayed, first song in playlist must be displayed first?
               System.out.println("First Song: ");
               System.out.println("Name: " + firstSong.getName());
               System.out.println("Artist: " + firstSong.getArtist());
               System.out.println("Album: " + firstSong.getAlbum());
               System.out.println("Length (in seconds): " + firstSong.getLength());                                 
            }                                    
            if (currentSong != null){
               System.out.println("Current Song: ");
               System.out.println("Name: " + currentSong.getName());
               System.out.println("Artist: " + currentSong.getArtist());
               System.out.println("Album: " + currentSong.getAlbum());
               System.out.println("Length (in seconds): " + currentSong.getLength());                                 
            }
            else {
               System.out.println("There is no song in playlist to display");
            }
         }
                  
         //5. Remove current song
         else if (choice == 5){
            if (currentSong != null){//checks if there is a current song playing
               playlist.removeSong(currentSong);
               currentSong = currentSong.getNext();//set current song to next song
            }
            else{
               System.out.println("There is no current song to remove");
            }
         }
         
         //6. Skip to next song
         else if (choice == 6){ 
            if (currentSong != null){ //checks if there is current song playing
               currentSong = currentSong.getNext();//skips to next   
               if (currentSong == playlist.getLastSong()){//checks if current song is last in playlist                  
                  currentSong = playlist.getFirstSong(); //sets current song to first song in playlist if ^true
               }   
            }
            else{
               System.out.println("There is no current song to skip");
            }   
         }
         
         //7. Return to previous song
         else if (choice == 7){        
            if (currentSong != null){ //checks if there is a current song playing
               currentSong = currentSong.getPrevious(); // returns current song to previous 
               if (currentSong == playlist.getFirstSong()){ //checks if current song is first in playlist
                  currentSong = playlist.getLastSong(); //sets current song to last song in playlist if ^ = true
               }
            }
            else{
               System.out.println("There is no previous song to return to");
            }
         }
         
         //8. Exit
         else if (choice == 8){
            System.out.println("Exiting program now");
         }
      }//closes main while loop
      scanner.close();
   }//closes main   
}//closes demo class
     
         
      
      
      
      
