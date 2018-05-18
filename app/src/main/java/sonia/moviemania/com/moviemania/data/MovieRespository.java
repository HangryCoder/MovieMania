package sonia.moviemania.com.moviemania.data;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import sonia.moviemania.com.moviemania.component.DaggerMovieComponent;
import sonia.moviemania.com.moviemania.component.MovieComponent;
import sonia.moviemania.com.moviemania.network.RestClient;
import sonia.moviemania.com.moviemania.utils.Utils;

/**
 * Created by soniawadji on 15/05/18.
 */

public class MovieRespository implements MovieDataSource {

    private static final String TAG = MovieRespository.class.getSimpleName();

    @Override
    public void getMovieData(final OnFinishedListener onFinishedListener) {
       /* getMovieObservable()
                .subscribeWith(getObserver(onFinishedListener));*/

        MovieComponent movieComponent = DaggerMovieComponent.builder()
                .build();

        DisposableObserver<Movie> disposableObserver =
                movieComponent.getMovieModule().fetchMovieDetails()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
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
                onFinishedListener.onSuccess(movie);
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
