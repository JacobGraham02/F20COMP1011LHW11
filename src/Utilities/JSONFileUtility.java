package Utilities;

import Models.MovieInfo;
import Models.SearchResult;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONFileUtility {

    /**
     * This method will return an ArrayList of MovieInfo objects
     * derived from the specified JSON file
     */
    public static ArrayList<MovieInfo> getMovieList(String jsonFileName)
    {
        ArrayList<MovieInfo> movies = new ArrayList<>();
        Gson gson = new Gson();

        //this is a try with resources...for objects that have a .close() method, this will
        //automatically close them, removing the need to have a finally block
        try (
                FileReader fileReader = new FileReader(jsonFileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            //this is the high level object in the JSON file
            SearchResult searchResult = gson.fromJson(jsonReader, SearchResult.class);
            movies.addAll(Arrays.asList(searchResult.getMovies()));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return movies;
    }
}
