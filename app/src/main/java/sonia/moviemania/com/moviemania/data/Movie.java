package sonia.moviemania.com.moviemania.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by soniawadji on 15/05/18.
 */

public class Movie {

    @SerializedName("title")
    private String movieName;
    @SerializedName("pgRating")
    private String movieRatings;
    @SerializedName("genre")
    private ArrayList<String> movieGenre;
    @SerializedName("releaseDate")
    private String movieReleaseDate;
    @SerializedName("duration")
    private String movieDuration;
    @SerializedName("longDescription")
    private String movieDescription;
    @SerializedName("playbackUrl")
    private String movieTrailerUrl;
    @SerializedName("potraitPoster")
    private ArrayList<String> moviePoster;

    public Movie(String movieName, String movieRatings,
                 ArrayList<String> movieGenre,
                 String movieReleaseDate, String movieDuration,
                 String movieDescription, String movieTrailerUrl,
                 ArrayList<String> moviePoster) {
        this.movieName = movieName;
        this.movieRatings = movieRatings;
        this.movieGenre = movieGenre;
        this.movieReleaseDate = movieReleaseDate;
        this.movieDuration = movieDuration;
        this.movieDescription = movieDescription;
        this.movieTrailerUrl = movieTrailerUrl;
        this.moviePoster = moviePoster;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieRatings() {
        return movieRatings;
    }

    public void setMovieRatings(String movieRatings) {
        this.movieRatings = movieRatings;
    }

    public ArrayList<String> getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(ArrayList<String> movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieTrailerUrl() {
        return movieTrailerUrl;
    }

    public void setMovieTrailerUrl(String movieTrailerUrl) {
        this.movieTrailerUrl = movieTrailerUrl;
    }

    public ArrayList<String> getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(ArrayList<String> moviePoster) {
        this.moviePoster = moviePoster;
    }
}
