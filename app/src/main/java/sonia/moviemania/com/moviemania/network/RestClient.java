package sonia.moviemania.com.moviemania.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import sonia.moviemania.com.moviemania.utils.Constants;

/**
 * Created by soniawadji on 16/05/18.
 */


/**
 * DELETE THIS LATER!!!
 * */
public class RestClient {

    private static Retrofit getRestClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static MovieAPI getMovieAPI() {
        return getRestClient().create(MovieAPI.class);
    }
}
