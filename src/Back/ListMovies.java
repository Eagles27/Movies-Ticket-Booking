package Back;

import bdd.mySQL;

import java.util.ArrayList;

public class ListMovies {
    private ArrayList<String> listMoviesName;
    private ArrayList<String> listMoviesGenre;
    private ArrayList<String> listMoviesDuration;
    private ArrayList<String> listMoviesReleased;
    private ArrayList<String> listMoviesImages;


    public ListMovies() {
        bdd.mySQL bdd = new mySQL();
        listMoviesName = bdd.multipleSelect("SELECT name FROM movie");
        listMoviesGenre = bdd.multipleSelect("SELECT genre FROM movie");
        listMoviesDuration = bdd.multipleSelect("SELECT duration FROM movie");
        listMoviesReleased = bdd.multipleSelect("SELECT released FROM movie");
        listMoviesImages = bdd.multipleSelect("SELECT images FROM movie");
    }

    public ListMovies(boolean foreground) {
        bdd.mySQL bdd = new mySQL();
        listMoviesName = bdd.multipleSelect("SELECT name FROM movie WHERE presentation = 'true'");
        listMoviesGenre = bdd.multipleSelect("SELECT genre FROM movie WHERE presentation = 'true'");
        listMoviesDuration = bdd.multipleSelect("SELECT duration FROM movie WHERE presentation = 'true'");
        listMoviesReleased = bdd.multipleSelect("SELECT released FROM movie WHERE presentation = 'true'");
        listMoviesImages = bdd.multipleSelect("SELECT images FROM movie WHERE presentation = 'true'");
    }


    public ArrayList<String> getListMoviesDuration() {
        return listMoviesDuration;
    }

    public ArrayList<String> getListMoviesGenre() {
        return listMoviesGenre;
    }

    public ArrayList<String> getListMoviesName() {
        return listMoviesName;
    }

    public ArrayList<String> getListMoviesReleased() {
        return listMoviesReleased;
    }

    public ArrayList<String> getListMoviesImages() {
        return listMoviesImages;
    }

    public String getMovieName(int index) {
        return listMoviesName.get(index);
    }
}
