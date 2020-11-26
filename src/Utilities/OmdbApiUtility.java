package Utilities;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OmdbApiUtility {

    public static void getMovieFromSearch(String searchText) throws IOException, InterruptedException {
        String searchURL = "http://www.omdbapi.com/?apikey=4a1010ab&s=*"+searchText+"*";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(searchURL)).build();

        HttpResponse<Path> response =
                client.send(request, HttpResponse.BodyHandlers.ofFile(
                                    Paths.get("movieSearch.json")));
    }
}
