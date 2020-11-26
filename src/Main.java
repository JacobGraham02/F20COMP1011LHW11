import Utilities.OmdbApiUtility;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            OmdbApiUtility.getMovieFromSearch("Rudolph");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
