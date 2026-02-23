import java.util.Scanner;

public class SpotifyTester {

    //HI
    public static void main(String[] args) throws Exception {
        Playlist playlist1 = new Playlist();
        playlist1.readingSongs("H:\\M359 SINGH\\SPOTIFY-REPO\\SPOTIFY\\u4b-lab-spotify-aman-coder09\\U4BLab\\spotify_unique_years_artists.txt");

        System.out.println(playlist1);

        Scanner test = new Scanner(System.in);


// Sort by artist
        playlist1.sortByArtist();



        System.out.println("--------##- Playlist AFTER Sorting by Artist (A-Z) -------");
        System.out.println(playlist1);


        playlist1.sortByArtistReverse();

        System.out.println("--------##- Playlist AFTER Sorting by Artist in reverse( Z-A) -------");
        System.out.println(playlist1);


        System.out.println("Enter genre");
        String genres = test.nextLine();

        playlist1.genre(genres);

        test.close();

    }
}
