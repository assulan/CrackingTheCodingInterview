package chapter8;
import java.util.Queue;
import java.util.List;
import java.util.Set;
/**
 * Created by asus on 8/26/17.
 * Design a musical jukebox using OOP.
 *
 * Assumptions:
 *  - computer simulation
 *  - free
 *  - Components: jukebox, CD, song, artist, playlist, display
 */

class Jukebox{
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private SongSelector ts;

    public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
        this.ts = ts;
    }

    public Song getCurrentSong(){
        return ts.getCurrentSong();
    }

    public void setUser(User u){
        user = u;
    }
}

class SongSelector{
    Song currentSong = null;

    public Song getCurrentSong(){
        return currentSong;
    }
}

class CDPlayer{
    private Playlist p;
    private CD c;

    public CDPlayer(Playlist p, CD c) {
        this.p = p;
        this.c = c;
    }

    public CDPlayer(Playlist p) {
        this.p = p;
    }

    public CDPlayer(CD c) {
        this.c = c;
    }

    public void playSong(Song s){

    }

    public Playlist getP() {
        return p;
    }

    public void setP(Playlist p) {
        this.p = p;
    }

    public CD getC() {
        return c;
    }

    public void setC(CD c) {
        this.c = c;
    }
}

class Playlist{
    private Song song;
    private Queue<Song> queue;

    public Playlist(Song song, Queue<Song> queue) {
        this.song = song;
        this.queue = queue;
    }

    public Song getNextSongToPlay(){
        return queue.peek();
    }

    public void queueUpSong(Song s){
        queue.add(s);
    }
}

class CD{
    private String id;
    private String artist;
    private List<Song> songs;
}

class Song{
    private String title;
    private double length;
    private String id;
}

class User {
    private String name;
    private long ID;

    public User(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public User getUser(){
        return this;
    }

    public static User addUser(String name, long id){
        return null;
    }
}

public class Challenge8_3 {

}
