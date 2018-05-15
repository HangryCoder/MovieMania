package sonia.moviemania.com.moviemania.data;

/**
 * Created by soniawadji on 15/05/18.
 */

public interface MovieDataSource {

    interface OnFinishedListener{
        void onFinished(Movie movie);
    }

    void getMovieData(OnFinishedListener onFinishedListener);
}
