package sonia.moviemania.com.moviemania.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import sonia.moviemania.com.moviemania.data.Movie;
import sonia.moviemania.com.moviemania.utils.Constants;

public interface MovieAPI {
    @GET(Constants.URL_EXT)
    Observable<Movie> fetchMovieDetails();
}