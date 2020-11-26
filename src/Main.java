import Models.MovieInfo;
import Utilities.JSONFileUtility;
import Utilities.OmdbApiUtility;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
//        ArrayList<MovieInfo> movies = new ArrayList<>();
//        try {
//            OmdbApiUtility.getMovieFromSearch("Rudolph");
//            movies.addAll(JSONFileUtility.getMovieList("./src/JSONFiles/movieSearch.json"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./Views/movieSearchView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
