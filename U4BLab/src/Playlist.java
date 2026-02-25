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

    public void sortByArtist() {

        for (int i = 0; i < songs.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < songs.size(); j++) {

                if (songs.get(j).getArtist()
                        .compareToIgnoreCase(songs.get(minIndex).getArtist()) < 0) {

                    minIndex = j;
                }
            }

            // swap
            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }
    }

    public void sortByArtistReverse() {

        for (int i = 0; i < songs.size() - 1; i++) {

            int maxIndex = i;

            for (int j = i + 1; j < songs.size(); j++) {


                if (songs.get(j).getArtist()
                        .compareToIgnoreCase(songs.get(maxIndex).getArtist()) > 0) {
                    maxIndex = j;
                }
            }


            Song temp = songs.get(i);
            songs.set(i, songs.get(maxIndex));
            songs.set(maxIndex, temp);
        }
    }

    public void sortByReleaseYear() {

        for (int i = 1; i < songs.size(); i++) {

            Song key = songs.get(i);
            int j = i - 1;

            while (j >= 0 && songs.get(j).getReleaseYear() > key.getReleaseYear()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }

            songs.set(j + 1, key);
        }
    }

    public void sortByReleaseYearReverse() {

        for (int i = 1; i < songs.size(); i++) {

            Song key = songs.get(i);
            int j = i - 1;

            // notice the < instead of >
            while (j >= 0 && songs.get(j).getReleaseYear() < key.getReleaseYear()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }

            songs.set(j + 1, key);
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
