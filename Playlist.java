/*
   Name: Nina Matsukura Bernardino
   Date: 3/4/2024
   Program Purpose: act as doubly linked list in order to manage playlist
*/
class Playlist{
   private Song head; //blank song object to represent first song in playlist (dummy node = NOT ACTUAL SONG)
   private Song tail; //blank song object to represent last song in playlist (dummy node = NOT ACTUAL SONG) 
   private int size; //number of songs in playlist
      
   //no-arg constructor that initializes head, size, and tail  
   public Playlist(){
      head = new Song();
      tail = new Song();
      head.setNext(tail);//sets head pointer to tail = indicates list is empty
      tail.setPrevious(head);//sets tail pointer to head = indicates list is empty
      size = 0;
   }
   
   //Method that accepts a Song object and adds it to the end of the Playlist
   public void addSong(Song newSong){
      Song lastSong = tail.getPrevious(); //finds and initializes the last song in playlist (last song = node before tail)
      //inserts new song after the last song in playlist
      lastSong.setNext(newSong); //sets the newSong object as last song in playlist (^lastSongsong next pointer to new song)
      newSong.setPrevious(lastSong);//sets newSong object as last song in playlist (new song's previous pointer to lastSong)      
      newSong.setNext(tail);
      tail.setPrevious(newSong);
      size++;//adds to playlist song count
   }
   
   //Method that insert new Song into the playlist at the position directly after the Song that is currently playing
   public void addSongAfterCurrent(Song newSong, Song currentSong){
      Song nextSong = currentSong.getNext();//finds song after currentSong
      //inserts newSong between currentSong and nextSong
      currentSong.setNext(newSong);//(currentSong -> newSong)
      newSong.setNext(nextSong);//(newSong -> nextSong)
      newSong.setPrevious(currentSong);//(currentSong <- newSong)
      nextSong.setPrevious(newSong);//(newSong <- nextSong)
      size++; // adds to playlist count     
   }
   
   //Method removes song from playlist
   public void removeSong (Song song){
      //display error message if song is not found
      if (song.getPrevious() == null || song.getNext() == null){
         System.out.println("Song not found in playlist");
         return;
      }
      Song previousSong = song.getPrevious();
      Song nextSong = song.getNext();
      //removes song by linking previous & next song
      previousSong.setNext(nextSong);
      nextSong.setPrevious(previousSong);
      size--; //decrease playlist count
   }
   
   //Method to retrive first song of playlist (for menu option 4,6,7)
   public Song getFirstSong(){
      return head.getNext();
   }
   
   //Method to retrieve last song of playlist (for menu options 4,6,7)
   public Song getLastSong(){
      return tail.getPrevious();
   }
   
   //Method prints out contents of the playlist & calculates/displays number of songs and length of the playlist
   @Override
   public String toString(){
      String playlistString = "Playlist:\n"; //creates string representation of playlist
      Song current = head.getNext(); //starts at first song of playlist
      int totalDuration = 0; //playlist length in seconds
      int songNumber = 1; //tracks song spot while displaying playlist's song info
      
      //traverses through playlist
      while (current != tail){
         //adds song details to playlist info
         playlistString += "Song " + songNumber + ": " +
                           "\n   Name: " + current.getName() +
                           "\n   Artist: " + current.getArtist() +
                           "\n   Album: " + current.getAlbum() +
                           "\n   Duration: " + (current.getLength()/60) + ":" + (current.getLength() % 60)+"\n";
         totalDuration += current.getLength(); //add song's length to total playlist length (in seconds)
         //move to next song
         current = current.getNext();
         songNumber++;               
      }   
      //calculates total duration
      playlistString += "Number of songs: " + size +
                        "\nTotal duration: " + (totalDuration/60) + ":" + (totalDuration % 60);
                        
      return playlistString;                  
                    
   }
      
}
