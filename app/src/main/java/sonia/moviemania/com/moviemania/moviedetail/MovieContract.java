package sonia.moviemania.com.moviemania.moviedetail;

import sonia.moviemania.com.moviemania.data.Movie;

/**
 * Created by soniawadji on 15/05/18.
 */

public interface MovieContract {

    interface View {

        void showProgress();

        void hideProgress();

        void displayMovieData(Movie movie);

        void displayError(String error);

    }

    interface Presenter {

        void fetchMovieData();
    }
}
