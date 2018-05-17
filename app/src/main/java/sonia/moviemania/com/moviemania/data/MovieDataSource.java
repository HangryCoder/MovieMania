package sonia.moviemania.com.moviemania.data;

/**
 * Created by soniawadji on 15/05/18.
 */

public interface MovieDataSource {

    interface OnFinishedListener{
        void onFinished(Movie movie);

        void onError(String error);
    }

    void getMovieData(OnFinishedListener onFinishedListener);
}
