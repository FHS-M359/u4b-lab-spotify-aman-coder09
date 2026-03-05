public class Song {

    private String title;
    private String album;
    private int durationSeconds;
    private int releaseYear;
    private String genre;
    private String artist;

    public Song(String artist ,String title , String album,int durationSeconds,int releaseYear,String genre){
        this.title = title;
        this.album=album;
        this.releaseYear=releaseYear;
        this.genre=genre;
        this.durationSeconds = durationSeconds;
        this.artist=artist;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String toString(){
        return String.format("%-25s %-20s %-25s %-8d %-8d %-15s",title, artist, album, durationSeconds, releaseYear, genre);
    }
}
