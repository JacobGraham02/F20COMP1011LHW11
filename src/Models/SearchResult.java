package Models;

import com.google.gson.annotations.SerializedName;

public class SearchResult {
    @SerializedName("Search")
    private MovieInfo[] movies;

    private String totalResults;

    public SearchResult(MovieInfo[] movies, String totalResults) {
        setMovies(movies);
        setTotalResults(totalResults);
    }

    public MovieInfo[] getMovies() {
        return movies;
    }

    public void setMovies(MovieInfo[] movies) {
        this.movies = movies;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
