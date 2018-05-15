package sonia.moviemania.com.moviemania.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import sonia.moviemania.com.moviemania.data.Movie;
import sonia.moviemania.com.moviemania.utils.Constants;

/**
 * Created by soniawadji on 16/05/18.
 */

public class RestClient {

    private static Retrofit getRestClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static MovieAPI getMovieAPI() {
        return getRestClient().create(MovieAPI.class);
    }


    public interface MovieAPI {
        @GET(Constants.URL_EXT)
        Call<Movie> fetchMovieDetails();
    }

}
