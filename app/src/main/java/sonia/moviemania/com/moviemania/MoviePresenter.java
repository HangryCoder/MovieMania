package sonia.moviemania.com.moviemania;

import sonia.moviemania.com.moviemania.data.Movie;
import sonia.moviemania.com.moviemania.data.MovieDataSource;

/**
 * Created by soniawadji on 15/05/18.
 */

public class MoviePresenter implements MovieContract.Presenter, MovieDataSource.OnFinishedListener {

    private MovieContract.View movieView;
    private MovieDataSource movieDataSource;

    public MoviePresenter(MovieContract.View movieView, MovieDataSource movieDataSource) {
        this.movieView = movieView;
        this.movieDataSource = movieDataSource;
    }

    @Override
    public void fetchMovieData() {
        if (movieView != null) {
            movieView.showProgress();
        }

        movieDataSource.getMovieData(this);
    }

    @Override
    public void watchTrailer() {
        //Do this later
    }

    @Override
    public void onSuccess(Movie movie) {
        if (movieView != null) {
            movieView.hideProgress();
            movieView.displayMovieData(movie);
        }
    }

    @Override
    public void onError(String error) {
        movieView.displayError(error);
    }
}
