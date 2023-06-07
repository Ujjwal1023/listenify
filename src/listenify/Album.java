package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    public String albumName;

    public String artistName;

    public List<Song>songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList=new ArrayList<>();
    }

   public boolean FindSongInAlbum(String title){
        for(Song song:songList){
            if((song.title).equals(title)){
                return true;
            }
        }
        return false;
     }
     public String addSongToAlbum(String title,double duration){
        //check if the song is already present then we will not add

        if(FindSongInAlbum(title)==true) {
            return "song is already present";
        }
        else {
            // i need to create a Song object then add it to SongList
            Song newSong=new Song(title,duration);
            songList.add(newSong);
            return "New Song has been added Successfully";
        }
     }

     public String addSongToPlayList(int trackNo, LinkedList<Song>playList){

        int index=trackNo-1;

        if(index>=0 && index<this.songList.size()){

            Song song=this.songList.get(index);
            playList.add(song);
            return "Song added to the playList";
        }
        return "Invalid track No";
     }
     public String addSongToPlayList(String title,LinkedList<Song>playList){

        for(Song song:songList){
            if(song.title==title){
                playList.add(song);
                return "Song has been added successfully";
            }
        }
        return "Song does not exist";
     }

}






