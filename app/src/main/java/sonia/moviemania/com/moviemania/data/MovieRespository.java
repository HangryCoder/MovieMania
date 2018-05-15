package sonia.moviemania.com.moviemania.data;

import android.os.Handler;

/**
 * Created by soniawadji on 15/05/18.
 */

public class MovieRespository implements MovieDataSource {

    @Override
    public void getMovieData(final OnFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Movie movie = new Movie("Harry Potter", "9.7",
                        "Adventure", "Year 2007",
                        "130 Minutes", "Awesome Movie",
                        "blah blah blah", "Zzzzzzzz");
                onFinishedListener.onFinished(movie);
            }
        }, 1500);
    }
}
