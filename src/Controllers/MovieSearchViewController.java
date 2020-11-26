package Controllers;

import Models.MovieInfo;
import Utilities.JSONFileUtility;
import Utilities.OmdbApiUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MovieSearchViewController implements Initializable {

    @FXML
    private ListView<MovieInfo> movieListView;

    @FXML
    private TextField textField;

    @FXML
    private Label rowsReturnedLabel;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //add a listener to the ListView so that when a Movie is selected, the
        //imageView is updated with the poster for that movie
        movieListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, movieSelected) -> {
                    try{
                        imageView.setImage(new Image(movieSelected.getPoster()));
                    } catch (Exception e)
                    {
                        imageView.setImage(new Image("./Views/default-movie.png"));
                    }
                }
        );

        updateLabels();
    }

    private void updateLabels()
    {
        rowsReturnedLabel.setText("Rows Returned: "+movieListView.getItems().size());
    }

    @FXML
    private void getMovies()
    {
        movieListView.getItems().clear();
        try {
            //replace the space character with %20 so it will work with HTTP
            String movieName = textField.getText();
            movieName = movieName.replace(" ", "%20");

            OmdbApiUtility.getMovieFromSearch(movieName);
            movieListView.getItems().addAll(JSONFileUtility.getMovieList("./src/JSONFiles/movieSearch.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateLabels();
    }
}