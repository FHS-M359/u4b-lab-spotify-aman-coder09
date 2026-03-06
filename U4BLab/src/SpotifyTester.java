import java.util.Scanner;

public class SpotifyTester {

    public static final int ARTIST_ATOZ = 1;
    public static final int ARTIST_ZTOA =2;
    public static final int YEAR_OLDTONEW = 3;
    public static final int YEAR_NEWTOOLD=4;
    public static final int SEARCH_GENRE = 5;
    public static final int DISPLAY_ALL =6;
    public static final int QUITTING = 7;


    public static void main(String[] args) throws Exception {
        Playlist playlist1 = new Playlist();
        playlist1.readingSongs("C:\\APCSA\\M359-WORKREPO\\u4b-lab-spotify-aman-coder09\\U4BLab\\spotify_unique_years_artists.txt");

        Scanner test = new Scanner(System.in);

        //var that is gonna be the thing we type to get the info
        int connect = 0;
        while (connect != QUITTING) {
            //printins the menu
            tablePrint();

            //use try/catch method to see if the input is valid or no .....
            connect = connectNumChecker(test);
            if (connect == ARTIST_ATOZ) {
                playlist1.Artist();
                System.out.println("--------##- Playlist AFTER Sorting by Artist (A-Z) -------");
                System.out.println(playlist1);
            } else if (connect == ARTIST_ZTOA) {
                playlist1.ArtistReverse();
                System.out.println("--------##- Playlist AFTER Sorting by Artist in reverse( Z-A) -------");
                System.out.println(playlist1);
            } else if (connect == YEAR_OLDTONEW) {
                playlist1.sortByRelease();

                System.out.println("---- AFTER SORT BY YEAR (Old  to New) ----");
                System.out.println(playlist1);
            } else if (connect == YEAR_NEWTOOLD) {
                playlist1.sortByReleaseReverse();

                System.out.println("---- AFTER SORT BY YEAR (New  to old) ----");
                System.out.println(playlist1);
            } else if (connect ==SEARCH_GENRE) {
                System.out.println("Enter genre");
                String genres = test.nextLine();

                playlist1.genre(genres);
            }

            else if (connect ==DISPLAY_ALL){
                System.out.println(playlist1);
            }
            else if(connect == QUITTING){
                System.out.println("Byeeee and Rock&Roll🤘🤘🤘");
            }




        }
        test.close();
    }
    /**
     * A function that will be called in the main() printing the meneu
     * @param--  no parameters
     * @return returns the diffrence choices availaible to you
     */
    public static void tablePrint(){
        System.out.println("===== Spotify Menu ====");
        System.out.println("1 - Sort by Artist(A -> Z)");
        System.out.println("2 - Sort by Artist(Z -> A)");
        System.out.println("3 - Sort by year(OLD -> NEW)");
        System.out.println("4 - Sort by year(NEW -> OLD)");
        System.out.println("5 - Search by genre");
        System.out.println("6 - Display all songs");
        System.out.println("7 - quit");
        System.out.println("Enter choice (1-7)");







    }
    /**
     * Returns a int which is valid .
     * @param - Scanner is the parameter
     * @return returns the connect/ the int
     */
    public static int connectNumChecker(Scanner input){
        int connect = 0 ;
        boolean isCorrect = false;

        while(!isCorrect){
            try{
                //parseInt line from the web
                connect = Integer.parseInt(input.nextLine());

                if(connect>= 1 && connect< 8){
                    isCorrect = true;
                }
                else {
                    System.out.println("Not a Valid choice: Enter a number between 1-7");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid Choice . Enter Number 1-7 ");
            }
        }
        return connect;
    }
}
