package sonia.moviemania.com.moviemania.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import sonia.moviemania.com.moviemania.network.MovieAPI;
import sonia.moviemania.com.moviemania.utils.Constants;

@Module(includes = OkHttpClientModule.class)
public class MovieModule {

    @Provides
    public MovieAPI getMovieAPI(Retrofit retrofit) {
        return retrofit.create(MovieAPI.class);
    }

    @MovieApplicationScope
    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}

