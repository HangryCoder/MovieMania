package sonia.moviemania.com.moviemania.data;

/**
 * Created by soniawadji on 15/05/18.
 */

public class Movie {

    private String movieName, movieRatings,
            movieGenre, movieReleaseDate,
            movieDuration, movieDescription,
            movieTrailerUrl, moviePoster;

    public Movie(String movieName, String movieRatings, String movieGenre,
                 String movieReleaseDate, String movieDuration,
                 String movieDescription, String movieTrailerUrl,
                 String moviePoster) {
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

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
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

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
}
