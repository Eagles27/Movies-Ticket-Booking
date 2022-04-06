package Back;

import bdd.mySQL;

import java.util.ArrayList;

public class ListMovies {
    private ArrayList<String> listMoviesName;
    private ArrayList<String> listMoviesGenre;
    private ArrayList<String> listMoviesDuration;
    private ArrayList<String> listMoviesReleased;


    public ListMovies(){
        bdd.mySQL bdd = new mySQL();
        listMoviesName = bdd.multipleSelect("SELECT name FROM movie");
        listMoviesGenre = bdd.multipleSelect("SELECT genre FROM movie");
        listMoviesDuration = bdd.multipleSelect("SELECT duration FROM movie");
        listMoviesReleased = bdd.multipleSelect("SELECT released FROM movie");
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

    public String getMovieName(int index){
        return listMoviesName.get(index);
    }
}
