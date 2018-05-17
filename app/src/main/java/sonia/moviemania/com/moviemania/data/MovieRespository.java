package sonia.moviemania.com.moviemania.data;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import sonia.moviemania.com.moviemania.network.RestClient;
import sonia.moviemania.com.moviemania.utils.Utils;

/**
 * Created by soniawadji on 15/05/18.
 */

public class MovieRespository implements MovieDataSource {

    private static final String TAG = MovieRespository.class.getSimpleName();

    @Override
    public void getMovieData(final OnFinishedListener onFinishedListener) {
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Movie movie = new Movie("Harry Potter", "9.7",
                        "Adventure", "Year 2007",
                        "130 Minutes", "Awesome Movie",
                        "blah blah blah", "Zzzzzzzz");
                onFinishedListener.onFinished(movie);
            }
        }, 1500);*/

        getMovieObservable()
                .subscribeWith(getObserver(onFinishedListener));
    }

    private Observable<Movie> getMovieObservable() {
        return RestClient.getMovieAPI().fetchMovieDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<Movie> getObserver(final OnFinishedListener onFinishedListener) {
        return new DisposableObserver<Movie>() {
            @Override
            public void onNext(Movie movie) {
                Utils.myLog(TAG, "onNext " + movie.getMovieName());
                onFinishedListener.onFinished(movie);
            }

            @Override
            public void onError(Throwable e) {
                Utils.myLog(TAG, "onError " + e.getLocalizedMessage());
                onFinishedListener.onError(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                Utils.myLog(TAG, "onComplete");
            }
        };
    }
}
