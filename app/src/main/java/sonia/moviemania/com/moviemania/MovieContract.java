package sonia.moviemania.com.moviemania;

import sonia.moviemania.com.moviemania.data.Movie;

/**
 * Created by soniawadji on 15/05/18.
 */

public interface MovieContract {

    interface View{

        void showProgress();

        void hideProgress();

        void displayMovieData(Movie movie);
    }

    interface Presenter{

        void fetchMovieData();

        void watchTrailer();
    }
}
