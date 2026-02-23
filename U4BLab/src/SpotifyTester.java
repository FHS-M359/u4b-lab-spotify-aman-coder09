import java.util.Scanner;

public class SpotifyTester {

    //HI
    public static void main(String[] args) throws Exception {
        Playlist playlist1 = new Playlist();
        playlist1.readingSongs("C:\\APCSA\\M359-WORKREPO\\u4b-lab-spotify-aman-coder09\\U4BLab\\spotify_unique_years_artists.txt");

        System.out.println(playlist1);

        Scanner test = new Scanner(System.in);


        System.out.println("Enter genre");
        String genres = test.nextLine();

        playlist1.genre(genres);

        test.close();
    }
}
