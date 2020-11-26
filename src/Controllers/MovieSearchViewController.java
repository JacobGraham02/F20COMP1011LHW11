package Controllers;

import Models.MovieInfo;
import Utilities.JSONFileUtility;
import Utilities.OmdbApiUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MovieSearchViewController implements Initializable {

    @FXML
    private ListView<MovieInfo> movieListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            OmdbApiUtility.getMovieFromSearch("Rudolph");
            movieListView.getItems().addAll(JSONFileUtility.getMovieList("./src/JSONFiles/movieSearch.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}