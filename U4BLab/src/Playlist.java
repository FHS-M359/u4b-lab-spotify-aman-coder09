import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    private ArrayList<Song> songs;

    public Playlist(){
        songs = new ArrayList<Song>();
    }

    public void readingSongs(String filename) throws Exception{

        Scanner inF = new Scanner(new File(filename));

        while (inF.hasNextLine()){

            String line = inF.nextLine();

            String[] dividing = line.split(",");

            String title = dividing[0];
            String artist = dividing[1];
            String album = dividing[2];
            int durationSeconds = Integer.parseInt(dividing[3]);
            int year = Integer.parseInt(dividing[4]);
            String genre = dividing[5];

            Song s = new Song(artist,title,album,durationSeconds,year,genre);

            songs.add(s);
        }
        inF.close();





    }
    public void genre(String targetGenre){
        boolean isThere = false;
        for (Song s : songs){
            if (s.getGenre().equalsIgnoreCase(targetGenre)) {
                System.out.println(s);
                isThere = true;
            }
        }
        if(!isThere){
            System.out.println("No songs found in genre " + targetGenre);
        }
    }

    public String toString(){

        String answer = "";
       for (Song s : songs){
           answer= answer+ s + "\n";
       }
        return answer;
    }


}
