/*
Nina Matsukura Bernardino
March 4, 2023
Purpose of program is to represent individual songs within playlist 
*/
class Song{
   //Fields
   private String name;
   private String artist;
   private String album;
   private int length; //in seconds
   private Song next;
   private Song previous;
   
   //no-arg constructor
   public Song(){     
   }
   
   public Song(String name, String artist, String album, int length){
      this.name = name;
      this.artist = artist;
      this.album = album;
      this.length = length;
   }
   
   //Getters & Setters
   //getters have type
   //setters have parameter
   public String getName(){
      return name; 
   }
   public void setName(String name){
      this.name = name;
   }
   
   public String getArtist(){
      return artist;
   }
   public void setArtist(String artist){
      this.artist = artist;
   }
   
   public String getAlbum(){
      return album;
   }
   public void setAlbum(String album){
      this.album = album;
   }
   
   public int getLength(){
      return length;
   }
   public void setLength(int length){
      this.length = length;
   }
   
   public Song getNext(){
      return next;
   }
   public void setNext(Song next){
      this.next = next;
   }
   
   public Song getPrevious(){
      return previous;
   }
   public void setPrevious(Song previous){
      this.previous = previous;
   }
   
   
}   