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
    public void genre(String Genre){
        boolean isThere = false;
        for (Song s : songs){
            if (s.getGenre().equalsIgnoreCase(Genre)) {
                System.out.println(s);
                isThere = true;
            }
        }
        if(!isThere){
            System.out.println("No songs found in genre " + Genre);
        }
    }

    public void Artist() {

        for (int i = 0; i < songs.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < songs.size(); j++) {

                String cArtist = songs.get(j).getArtist();
                String minArtist = songs.get(minIndex).getArtist();
                if (cArtist.compareToIgnoreCase(minArtist) < 0 ) {

                    minIndex = j;
                }
            }

            // swap
            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }
    }

    public void ArtistReverse() {

        for (int i = 0; i < songs.size() - 1; i++) {

            int maxIndex = i;

            for (int j = i + 1; j < songs.size(); j++) {
                String cArtist = songs.get(j).getArtist();
                String minArtist = songs.get(maxIndex).getArtist();

                if (cArtist.compareToIgnoreCase(minArtist) > 0) {
                    maxIndex = j;
                }
            }


            Song temp = songs.get(i);
            songs.set(i, songs.get(maxIndex));
            songs.set(maxIndex, temp);
        }
    }

    public void sortByRelease() {

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

    public void sortByReleaseReverse() {

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
