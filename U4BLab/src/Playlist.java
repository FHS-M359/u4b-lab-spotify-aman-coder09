import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    private ArrayList<Song> songs;

    /**
     * makes a playlist object
     * @param - none
     */
    public Playlist(){
        songs = new ArrayList<Song>();
    }

    /**
     * will be dividing the line into diff categories .. into arraylist with the help of split()
     * @param - filename
     * @return returns a void
     */
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
    /**
     * function used to check if the genre that was enter by the user is in the txt file or not
     * @param - genre and isThere
     * @return weather the genre is there (isThere = true) or else prints astatemnts
     */
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

    /**
     * will be sorting the artist in A-Z USING SELECTION SORT
     * @param - cArtist, minArtist , minIndex
     * @return returns the sorted list
     * source - INclassroom coding example file
     * using ignoreCase so the input is not case sensivitve
     */
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

    /**
     * will be sorting the artist in Z-A USING SELECTION SORT
     * @param - cArtist, minArtist , minIndex
     * @return returns the sorted list
     * source - INclassroom coding example file
     * using ignoreCase so the input is not case sensivitve
     */
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

            //SWAP
            Song temp = songs.get(i);
            songs.set(i, songs.get(maxIndex));
            songs.set(maxIndex, temp);
        }
    }

    /**
     * will be sorting the LIST USING RELEASE YEAR USING INSERTION SORT
     * @param - tempValue, position ,
     * @return returns the sorted list by year
     * source - INclassroom coding example file GIVEN BY DeSteph
     */
    public void sortByRelease() {

        for (int i = 1; i < songs.size(); i++) {

            Song tempValue = songs.get(i);
            int position = i;

            while (position > 0 && songs.get(position-1).getReleaseYear() > tempValue.getReleaseYear()){

                songs.set(position , songs.get(position-1));
                position--;
            }

            songs.set(position,tempValue);
            }

    }

    /**
     * will be sorting the LIST USING RELEASE YEAR USING INSERTION SORT in reverse
     * @param - tempValue, position ,
     * @return returns the sorted list by year in reverse
     * source - INclassroom coding example file GIVEN BY DeSteph
     */
    public void sortByReleaseReverse() {

        for (int i = 1; i < songs.size(); i++) {

            Song tempValue = songs.get(i);
            int position = i;

            while (position > 0 && songs.get(position-1).getReleaseYear() < tempValue.getReleaseYear()){

                songs.set(position , songs.get(position-1));
                position--;
            }

            songs.set(position,tempValue);
        }
    }

    /**
     * returns string contatining all the songs
     * @param - answer,
     * @return retruns the answer string

     */
    public String toString(){

        String answer = "";
       for (Song s : songs){
           answer= answer+ s + "\n";
       }
        return answer;
    }


}
